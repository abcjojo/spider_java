package com.java.spider.entity;

import lombok.Getter;
import lombok.Setter;
import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.solr.core.mapping.SolrDocument;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: learn_spider
 * @description:存储页面信息实体类
 * @author: Jojo.Lee
 * @create: 2020-03-04 20:13
 **/
@Getter
@Setter
@SolrDocument(collection = "spider")
public class Page {

    @Field
    private Integer id;
    //页面内容
    private String content;
    //URL集合(包含列表url和详情url)
    List<String> urlList = new ArrayList<String>();

    //url
    private String url;
    //视屏id
    private String videoId;
    //视屏名称
    @Field
    private String name;
    //热度
    private String hot;
    //评分
    @Field
    private double score;
    //类型
    @Field
    private String type1;
    @Field
    private String type2;
    @Field
    private String type3;
    //引述
    private String quote;
    //内容简介
    private String introduction;
    //评价人数
    @Field
    private int number;
    //声优
    private String seiy;
    //国家
    @Field
    private String country;
    //年份
    private Integer year;
    //主演
    private String protagonists;
    //编剧
    private String scriptwriter;
    //导演
    private String director;
    //IMDb播放链接
    private String IMDbUrl;
    //片长
    @Field
    private Integer mins;
    //上映日期
    @Field
    private String releaseDate;
    //语言
    @Field
    private String language;
    //又名
    private String alternateName;
    //排名
    @Field
    private int no;

    public void addUrlList(String url){
        this.urlList.add(url);
    }
}