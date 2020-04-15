package com.java.spider.mytest;

import com.java.spider.service.DouBanPageService;
import com.java.spider.service.impl.DouBanPageServiceImpl;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * @program: learn_spider
 * @description:
 * @author: Jojo.Lee
 * @create: 2020-03-22 11:33
 **/

@Service
@Component
public class TestClass {


    @Autowired
    DouBanPageService douBanPageService;

    //DouBanPageService douBanPageService = new DouBanPageServiceImpl();

    public static TestClass testClass;
    @PostConstruct//在初始化的时候初始化静态对象和它的静态成员变量bean对象，静态存储下来，防止被释放
    public void init() {
        testClass = this;
        testClass.douBanPageService = this.douBanPageService;
    }


    @Test
    public void test() {
        System.out.println(douBanPageService.select123());

    }
}