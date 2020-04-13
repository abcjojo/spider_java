package com.java.spider.util;

import java.util.ArrayList;
import java.util.Random;

/**
 * @program: learn_spider
 * @description:  用户代理 UA 爬虫头信息工具类
 * @author: Jojo.Lee
 * @create: 2020-03-25 15:01
 **/
public class UserAgentUtil {

    //随机返回一个UA
    public static String getUserAgent(){

        ArrayList<String> list = new ArrayList<String>(){{
            add("Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML); like Gecko) Chrome/41.0.2228.0 Safari/537.36");
            add("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_10_1) AppleWebKit/537.36 (KHTML); like Gecko) Chrome/41.0.2227.1 Safari/537.36");
            add("Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML); like Gecko) Chrome/41.0.2227.0 Safari/537.36");
            add("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML); like Gecko) Chrome/41.0.2227.0 Safari/537.36");
            add("Mozilla/5.0 (Windows NT 6.3; WOW64) AppleWebKit/537.36 (KHTML); like Gecko) Chrome/41.0.2226.0 Safari/537.36");
            add("Mozilla/5.0 (Windows NT 6.4; WOW64) AppleWebKit/537.36 (KHTML); like Gecko) Chrome/41.0.2225.0 Safari/537.36");
            add("Mozilla/5.0 (Windows NT 6.3; WOW64) AppleWebKit/537.36 (KHTML); like Gecko) Chrome/41.0.2225.0 Safari/537.36");
            add("Mozilla/5.0 (Windows NT 5.1) AppleWebKit/537.36 (KHTML); like Gecko) Chrome/41.0.2224.3 Safari/537.36");
            add("Mozilla/5.0 (Windows NT 10.0) AppleWebKit/537.36 (KHTML); like Gecko) Chrome/40.0.2214.93 Safari/537.36");
            add("Mozilla/5.0 (Windows NT 10.0) AppleWebKit/537.36 (KHTML); like Gecko) Chrome/40.0.2214.93 Safari/537.36");
            add("Mozilla/5.0 (Windows NT 6.3; Win64; x64) AppleWebKit/537.36 (KHTML); like Gecko) Chrome/37.0.2049.0 Safari/537.36");
            add("Mozilla/5.0 (Windows NT 4.0; WOW64) AppleWebKit/537.36 (KHTML); like Gecko) Chrome/37.0.2049.0 Safari/537.36");
            add("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML); like Gecko) Chrome/36.0.1985.67 Safari/537.36");
            add("Mozilla/5.0 (Windows NT 5.1) AppleWebKit/537.36 (KHTML); like Gecko) Chrome/36.0.1985.67 Safari/537.36");
            add("Mozilla/5.0 (Windows NT 5.1) AppleWebKit/537.36 (KHTML); like Gecko) Chrome/35.0.3319.102 Safari/537.36");
            add("Mozilla/5.0 (Windows NT 5.1) AppleWebKit/537.36 (KHTML); like Gecko) Chrome/35.0.2309.372 Safari/537.36");
            add("Mozilla/5.0 (Windows NT 5.1) AppleWebKit/537.36 (KHTML); like Gecko) Chrome/35.0.2117.157 Safari/537.36");
            add("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_9_3) AppleWebKit/537.36 (KHTML); like Gecko) Chrome/35.0.1916.47 Safari/537.36");
            add("Mozilla/5.0 (Windows NT 5.1) AppleWebKit/537.36 (KHTML); like Gecko) Chrome/34.0.1866.237 Safari/537.36");
            add("Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/62.0.3202.94 Safari/537.36");
        }};

        int index = new Random().nextInt( list.size() );
        return list.get(index);

    }

}
