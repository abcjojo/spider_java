package com.java.spider.service.impl;

import com.java.spider.service.IRepositoryService;
import com.java.spider.util.RedisUtil;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.stereotype.Component;

/**
 * @program: learn_spider
 * @description: redis  url仓库实现类
 * @author: Jojo.Lee
 * @create: 2020-03-30 20:02
 **/
@Component
public class RedisRepositoryServiceImpl implements IRepositoryService {

    RedisUtil redisUtil = new RedisUtil();

    public String poll() {
        String url = redisUtil.poll(RedisUtil.highkey);
        if (StringUtils.isBlank(url)) {
            url = redisUtil.poll(RedisUtil.lowkey);
        }
        return url;
    }

    public void addHighLevel(String url) {
        redisUtil.add(RedisUtil.highkey,url);
    }

    public void addLowLevel(String url) {
        redisUtil.add(RedisUtil.lowkey,url);
    }
}
