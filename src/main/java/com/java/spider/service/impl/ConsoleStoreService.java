package com.java.spider.service.impl;

import com.java.spider.entity.Page;
import com.java.spider.service.DouBanPageService;
import com.java.spider.service.IStoreService;
import com.java.spider.service.SolrService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @program: learn_spider
 * @description: 数据存储实现类
 * @author: Jojo.Lee
 * @create: 2020-03-25 16:07
 **/
@Component
public class ConsoleStoreService implements IStoreService {

    public void store(Page page) {
        //System.out.println("number:"+page.getNumber());
        System.out.println("score:"+page.getScore());
        System.out.println("电影名:"+page.getName());
        System.out.println("country:"+page.getCountry());
        System.out.println("videoID:"+page.getVideoId());
        System.out.println("电影排名:"+page.getNo());
//        System.out.println("内容简介:"+page.getIntroduction());
//        System.out.println("导演:"+page.getDirector());
//        System.out.println("编剧:"+page.getScriptwriter());
//        System.out.println("主演:"+page.getProtagonists());
//        System.out.println("类型:"+page.getType());
//        System.out.println("语言:"+page.getLanguage());
//        System.out.println("上映日期:"+page.getReleaseDate());
//        System.out.println("片长:"+page.getMins());
//        System.out.println("又名:"+page.getAlternateName());
    }

}
