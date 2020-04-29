package com.java.spider.service.impl;

import com.java.spider.entity.Page;
import com.java.spider.util.HtmlUtil;
import com.java.spider.util.LoadPropertyUtil;
import com.java.spider.util.RegexUtil;
import org.htmlcleaner.HtmlCleaner;
import org.htmlcleaner.TagNode;

import java.util.regex.Pattern;

/**
 * @program: learn_spider
 * @description: youku页面解析类
 * @author: Jojo.Lee
 * @create: 2020-03-27 10:39
 **/
public class YouKuProcessServiceImpl {

    public void process(Page page){
        String content = page.getContent();

        HtmlCleaner htmlCleaner = new HtmlCleaner();

        TagNode rootNode = htmlCleaner.clean(content);

        if (page.getUrl().startsWith("https://comic.youku.com/?spm=a2hcb.")){
            //解析非详情页的url
            parseDetail(page,rootNode);
        }




    }

    //解析视屏详情页
    public void parseDetail(Page page, TagNode rootNode){

        //视屏热度
        String hot = HtmlUtil.getFildByRegex(rootNode, LoadPropertyUtil.getYOUKU("parseHot"), LoadPropertyUtil.getYOUKU("numberRegex"));
        page.setHot(hot);

        //视屏类型
//        String type = HtmlUtil.getFildByRegex(rootNode, LoadPropertyUtil.getYOUKU("parseType"),LoadPropertyUtil.getYOUKU("hanziRegex"));
//        page.setType(type);

        String name = HtmlUtil.getFildByRegex(rootNode, LoadPropertyUtil.getYOUKU("parseName"),LoadPropertyUtil.getYOUKU("hanziRegex"));
        page.setName(name);

        page.setCountry("0");

        //获取优酷视频id
        Pattern pattern = Pattern.compile(LoadPropertyUtil.getYOUKU("videoIdRegex"));
        String url = page.getUrl();
        String videoId = RegexUtil.getPageInfoByRegex(url,pattern,1);
        page.setVideoId("youku_"+videoId);

    }

}
