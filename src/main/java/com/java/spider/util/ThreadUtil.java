package com.java.spider.util;

/**
 * @program: learn_spider
 * @description: 线程工具类
 * @author: Jojo.Lee
 * @create: 2020-03-31 19:41
 **/
public class ThreadUtil {
    @SuppressWarnings("static-access")
    public static void sleep(long millions){
        try {
            Thread.currentThread().sleep(millions);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
