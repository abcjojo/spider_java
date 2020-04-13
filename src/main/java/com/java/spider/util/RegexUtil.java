package com.java.spider.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @program: learn_spider
 * @description: 正则匹配工具类
 * @author: Jojo.Lee
 * @create: 2020-03-22 21:27
 **/
public class RegexUtil {

    public static String getPageInfoByRegex(String content, Pattern pattern, int groupNo){
        Matcher matcher = pattern.matcher(content);
        if (matcher.find()) {
            return matcher.group(groupNo).trim();
        }
        return "-1";
    }

}
