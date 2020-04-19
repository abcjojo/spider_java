package com.java.spider;

import com.java.spider.controller.SolrController;
import com.java.spider.controller.SpiderController;
import com.java.spider.service.DouBanPageService;
import com.java.spider.service.IRepositoryService;
import com.java.spider.service.SolrService;
import com.java.spider.start.StartMovieCount;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@SpringBootApplication
//@ComponentScan(basePackages = {"com.java.spider"})
@EntityScan("com.java.spider.entity")
public class SpiderApplication {

//    @Resource
//    private SpiderController spiderController;

    public static void main(String[] args) {
        SpringApplication.run(SpiderApplication.class, args);
        //new SpiderApplication().start();
    }
    public void start(){
        String url = "https://movie.douban.com/subject/1309163/";
        new SpiderController().startDouBanTop(url);
    }

}
