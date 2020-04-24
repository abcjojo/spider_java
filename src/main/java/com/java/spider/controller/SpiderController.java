package com.java.spider.controller;

import com.java.spider.entity.Page;
import com.java.spider.service.*;
import com.java.spider.util.LoadPropertyUtil;
import com.java.spider.util.ThreadUtil;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @program: spider
 * @description:
 * @author: Jojo.Lee
 * @create: 2020-04-19 15:11
 **/
@RestController
@RequestMapping("/start")
public class SpiderController {

    //固定线程池
    private ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(Integer.parseInt(LoadPropertyUtil.getConfig("threadNum")));

    @Resource
    private SolrService solrService;
    @Resource
    private IRepositoryService iRepositoryService;
    @Resource
    private IStoreService iStoreService;
    @Resource
    private IDownloadService iDownloadService;
    @Resource
    private IProcessService iProcessService;



    @RequestMapping("/startDouBanTop")
    public void startDouBanTop(String startUrl) {
        iRepositoryService.addHighLevel(startUrl);
        while(true){
            //从队列中取出需要解析的url
//            String url = urlQueue.poll();
            final String url = iRepositoryService.poll();
            //判断url是否为空
            if (StringUtils.isNotBlank(url)){

//                newFixedThreadPool.execute(new Runnable() {
//                    public void run() {

                        System.out.println("当前第"+Thread.currentThread().getId()+"个线程");

                        //分割详情页url和引述
                        String[] detailUrl = url.split("@");
                        //下载
                        Page page = iDownloadService.download(detailUrl[0]);
                        if (detailUrl.length == 2) {
                            page.setQuote(detailUrl[1]);
                        }
                        //解析
                        iProcessService.process(page);

                        List<String> urlList = page.getUrlList();
                        for (String eachUrl : urlList){
                            if (eachUrl.startsWith("https://movie.douban.com/subject/")){
                                iRepositoryService.addLowLevel(eachUrl);
                            }else if (eachUrl.startsWith("https://movie.douban.com/top250?start=")){
                                iRepositoryService.addHighLevel(eachUrl);
                            }
                        }
                        //如果是详情页就存储数据
                        if (page.getUrl().startsWith("https://movie.douban.com/subject/")){
                            iStoreService.store(page);
                            solrService.add(page);
                        }
                        ThreadUtil.sleep(Long.parseLong(LoadPropertyUtil.getConfig("millions_3")));
//                    }
//                });
            }else{
                System.out.println("队列中的url解析完毕。。。");

                //如果暂时没有url，则休眠5秒钟
                ThreadUtil.sleep(Long.parseLong(LoadPropertyUtil.getConfig("millions_5")));
            }
        }
    }
}
