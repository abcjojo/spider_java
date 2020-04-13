package com.java.spider.util;

import java.util.ResourceBundle;

/**
 * @program: learn_spider
 * @description: 配置文件加载工具类
 * @author: Jojo.Lee
 * @create: 2020-03-24 15:00
 **/
public class LoadPropertyUtil {

    public static String getYOUKU(String key){

        String value = "";
        ResourceBundle resource = ResourceBundle.getBundle("YOUKU");
        value = resource.getString(key);

        // 3.在控制台中打印出取出的值
        //System.out.println(value);
        return value;
    }

    public static String getDouBan(String key){

        String value = "";
        ResourceBundle resource = ResourceBundle.getBundle("DOUBAN");
        value = resource.getString(key);
        // 3.在控制台中打印出取出的值
        //System.out.println("key:"+value);
        return value;
    }

    //读取配置文件
    public static String getConfig(String key){

        String value = "";
        ResourceBundle resource = ResourceBundle.getBundle("config");
        value = resource.getString(key);

        // 3.在控制台中打印出取出的值
        //System.out.println("key:"+value);
        return value;
    }

//    public static void main(String[] args) {
//        System.out.println(getConfig("threadNum"));
//    }

}
