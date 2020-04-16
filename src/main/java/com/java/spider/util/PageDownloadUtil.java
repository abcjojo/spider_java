package com.java.spider.util;


import com.java.spider.entity.Page;
import com.java.spider.service.impl.HttpClientDownloadServiceImpl;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * @program: learn_spider
 * @description: 页面下载工具类
 * @author: Jojo.Lee
 * @create: 2020-03-04 12:21
 **/
public class PageDownloadUtil {

    public static String getPageContent(String url){

        HttpClientBuilder buider = HttpClients.custom();
        CloseableHttpClient client = buider.build();
        String content = null;
        HttpGet request = new HttpGet(url);

        // 设置请求头消息User-Agent
        request.setHeader("User-Agent", UserAgentUtil.getUserAgent());

        try {

            CloseableHttpResponse response  = client.execute(request);
            HttpEntity entity = response.getEntity();
            content = EntityUtils.toString(entity);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return content;
    }

    public static void main(String[] args) {

        String url = "https://movie.douban.com/top250";
//        String content = PageDownloadUtil.getPageContent(url);

        HttpClientDownloadServiceImpl down = new HttpClientDownloadServiceImpl();
        Page youKuPagepage = down.download(url);

        System.out.println(youKuPagepage.getContent());


    }

}
