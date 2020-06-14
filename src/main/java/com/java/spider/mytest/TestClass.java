package com.java.spider.mytest;

import com.java.spider.entity.Page;
import com.java.spider.service.DouBanPageService;
import com.java.spider.service.SolrService;
import com.java.spider.service.impl.DouBanPageServiceImpl;
import com.java.spider.util.LoadPropertyUtil;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @program: learn_spider
 * @description:
 * @author: Jojo.Lee
 * @create: 2020-03-22 11:33
 **/

public class TestClass {

    private HttpSolrClient solrClient = new HttpSolrClient.Builder("http://localhost:8983/solr/").build();

    @Resource
    private SolrService solrService;
    @Resource
    private DouBanPageService douBanPageService;


    @Test
    public void method() {

       // String date1 = "1961(中国大陆) / 1964(中国大陆) / 1978(中国大陆) / 2004(中国大陆)";


        while (true) {
           // System.out.println(Long.parseLong(Math.random() * Integer.parseInt(LoadPropertyUtil.getConfig("millions_5"))+""));
            System.out.println((int)(Math.random() * Long.parseLong( Integer.parseInt(LoadPropertyUtil.getConfig("millions_5"))+"")));
        }

//        String[] temp = date1.split("/");
//        String sb = temp[0];
//        String[] time = sb.split("-");
//        String year = time[0].trim();// 2008-06-27(美国)
//        Pattern p = Pattern.compile("[^0-9]");
//        Matcher matcher = p.matcher(year);
//        String value = matcher.replaceAll("").trim();
//        System.out.println(value);
//        Pattern p = Pattern.compile("[\\d]+");
//        Matcher matcher = p.matcher("142分钟");
//        String value = "";
//        int i = 0;
//        while (matcher.find()) {
//            value = value + matcher.group(i);
//        }
//        int va = Integer.parseInt(value);
//        System.out.println(va==142);

    }
}