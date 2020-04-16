package com.java.spider.controller;

import com.java.spider.entity.Page;
import com.java.spider.entity.TestSpiderDoubanmovietop250;
import com.java.spider.service.DouBanPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @program: spider
 * @description:
 * @author: Jojo.Lee
 * @create: 2020-04-15 10:05
 **/
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    DouBanPageService douBanPageService;

     @RequestMapping("/getById")
    public void getById(){
         Page page = douBanPageService.getById(1);
         System.out.println(page.getUrl());
     }

    @RequestMapping("/123")
    public void test(){
        System.out.println("succeed");
    }
}
