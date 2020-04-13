package com.java.spider.mytest;

import com.java.spider.entity.Page;
import com.java.spider.service.DouBanPageService;
import org.junit.Test;
import org.mybatis.spring.annotation.MapperScan;

import javax.annotation.Resource;

/**
 * @program: learn_spider
 * @description:
 * @author: Jojo.Lee
 * @create: 2020-03-22 11:33
 **/

@MapperScan("com.java.mapper")
public class TestClass {

    @Resource
    private DouBanPageService service ;

    @Test
    public  void test() {

        Page page = service.getById(1);
        System.out.println(page.getUrl());

    }
}