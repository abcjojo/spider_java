package com.java.spider.start;

import com.java.spider.entity.Page;
import com.java.spider.service.IDownloadService;
import com.java.spider.service.IProcessService;
import com.java.spider.service.IRepositoryService;
import com.java.spider.service.IStoreService;
import com.java.spider.service.impl.*;
import com.java.spider.util.LoadPropertyUtil;
import com.java.spider.util.ThreadUtil;
import lombok.Getter;
import lombok.Setter;
import org.junit.platform.commons.util.StringUtils;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @program: learn_spider
 * @description: 电影爬虫执行入口类
 * @author: Jojo.Lee
 * @create: 2020-03-05 15:59
 **/
public class StartMovieCount {

    //用队列存储爬取到的url，实现循环爬取
//    private Queue<String> urlQueue = new ConcurrentLinkedQueue<String>();

    //固定线程池
    private ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(Integer.parseInt(LoadPropertyUtil.getConfig("threadNum")));

    @Setter
    @Getter
    private IRepositoryService repositoryService;

    @Getter
    @Setter
    private IDownloadService downloadService;

    @Getter
    @Setter
    private IProcessService processService;

    @Setter
    @Getter
    private IStoreService storeService;

    public void storePageInfo(Page page){
        this.storeService.store(page);
    }

    public Page downloadPage(String url) {
        return downloadService.download(url);
    }

    public void processPage(Page page){
        this.processService.process(page);
    }


    public static void main (String [] args){

        StartMovieCount movie = new StartMovieCount();

        movie.setDownloadService(new HttpClientDownloadService());
        movie.setProcessService(new DBMovieProcessService());
        movie.setStoreService(new ConsoleStoreService());
        //movie.setRepositoryService(new QueueRepositoryService());
        movie.setRepositoryService(new RedisRepositoryService());


//        //豆瓣top250页面
        String url = "https://movie.douban.com/top250?start=0&filter=";

        //设置起始url
//        movie.urlQueue.add(url);
        movie.repositoryService.addHighLevel(url);

        //开启爬虫
        movie.startSpider();

    }

    //爬虫入口
    public void startSpider(){
        while(true){
            //从队列中取出需要解析的url
//            String url = urlQueue.poll();
            final String url = repositoryService.poll();

            //判断url是否为空
            if (StringUtils.isNotBlank(url)){

                newFixedThreadPool.execute(new Runnable() {
                    public void run() {

                        System.out.println("当前第"+Thread.currentThread().getId()+"个线程");

                        //分割详情页url和引述
                        String[] detailUrl = url.split("@");
                        //下载
                        Page page = StartMovieCount.this.downloadPage(detailUrl[0]);
                        if (detailUrl.length == 2) {
                            page.setQuote(detailUrl[1]);
                        }
                        //解析
                        StartMovieCount.this.processPage(page);

                        List<String> urlList = page.getUrlList();
                        for (String eachUrl : urlList){
                            if (eachUrl.startsWith("https://movie.douban.com/subject/")){
                                repositoryService.addLowLevel(eachUrl);
                            }else if (eachUrl.startsWith("https://movie.douban.com/top250?start=")){
                                repositoryService.addHighLevel(eachUrl);
                            }
                        }
                        //如果是详情页就存储数据
                        if (page.getUrl().startsWith("https://movie.douban.com/subject/")){
                            StartMovieCount.this.storePageInfo(page);
                        }
                        ThreadUtil.sleep(Long.parseLong(LoadPropertyUtil.getConfig("millions_3")));
                    }
                });
            }else{
                System.out.println("队列中的url解析完毕。。。");

                //如果暂时没有url，则休眠5秒钟
                ThreadUtil.sleep(Long.parseLong(LoadPropertyUtil.getConfig("millions_5")));
            }
        }
    }
}
