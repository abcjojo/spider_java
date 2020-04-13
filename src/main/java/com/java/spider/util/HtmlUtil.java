package com.java.spider.util;

import org.htmlcleaner.TagNode;
import org.htmlcleaner.XPatherException;

import java.util.regex.Pattern;

/**
 * @program: learn_spider
 * @description:    html页面解析工具类
 * @author: Jojo.Lee
 * @create: 2020-03-24 11:01
 **/
public class HtmlUtil {

    //获取标签属性值
    public static String getAttributeByName(TagNode rootNode, String xpath, String att){
        String result = null;
        Object[] evaluateXPath = null;
        try {
            evaluateXPath = rootNode.evaluateXPath(xpath);
            if (evaluateXPath.length>0){
                TagNode node = (TagNode) evaluateXPath[0];
                result = node.getAttributeByName(att);
            }
        } catch (XPatherException e) {
            e.printStackTrace();
        }
        return result;
    }


    //通过xpath、regex获取字段
    public static String getFildByRegex(TagNode rootNode, String xpath, String regex){

        String result = "-1";
        Object[] evaluateXPath = null;
        try {
            //获取xpath中的数据   //*[@id="app"]/div/div[2]/div[2]/div[2]/div/div/div/div/div[2]/a[1]
            evaluateXPath = rootNode.evaluateXPath(xpath);
            if (evaluateXPath.length > 0) {
                TagNode node = (TagNode) evaluateXPath[0];
                //正则表达式匹配相应的优酷视频的热度  [\u4E00-\u9FA5]+
                Pattern pattern = Pattern.compile(regex, Pattern.DOTALL);
                //调用正则匹配工具类方法
                result = RegexUtil.getPageInfoByRegex(node.getText().toString(), pattern, 0);
                //System.out.println(result);
            }
        } catch (XPatherException e) {
            e.printStackTrace();
        }

        return result;
    }



}
