package com.java.spider.controller;

import com.java.spider.entity.TestSpiderDoubanmovietop250;
import com.java.spider.service.DouBanPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public TestSpiderDoubanmovietop250 getById(int id){
        return douBanPageService.selectByPrimaryKey(id);
     }
}
