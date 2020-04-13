package com.java.spider.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: learn_spider
 * @description: 优酷页面对应实体类
 * @author: Jojo.Lee
 * @create: 2020-03-25 14:25
 **/

public class YouKuPage {

    //页面内容
    @Getter
    @Setter
    private String content;

    //URL集合(包含列表url和详情url)
    @Getter
    List<String> urlList = new ArrayList<String>();

    //url
    @Getter
    @Setter
    private String url;

    @Getter
    @Setter
    //视屏id
    private String videoId;

    @Getter
    @Setter
    //视屏名称
    private String name;

    @Getter
    @Setter
    //热度
    private String hot;

    @Getter
    @Setter
    //评分
    private String score;

    @Getter
    @Setter
    //类型
    private String type;

    @Getter
    @Setter
    //内容简介
    private String quote;

    @Getter
    @Setter
    //评价人数
    private String number;

    @Getter
    @Setter
    //主演
    private String protagonist;

    @Getter
    @Setter
    //声优
    private String seiy;

    @Getter
    @Setter
    //国家
    private String country;

    @Getter
    @Setter
    //年份
    private int year;

    public void addUrlList(String url){
        this.urlList.add(url);
    }
}
