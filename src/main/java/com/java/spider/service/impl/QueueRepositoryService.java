package com.java.spider.service.impl;

import com.java.spider.service.IRepositoryService;
import org.junit.platform.commons.util.StringUtils;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @program: learn_spider
 * @description:    url仓库实现类
 * @author: Jojo.Lee
 * @create: 2020-03-29 11:29
 **/
public class QueueRepositoryService implements IRepositoryService {

    //高优先级队列
    private Queue<String> highLevelQueue = new ConcurrentLinkedQueue<String>();
    //低优先级队列
    private Queue<String> lowLevelQueue = new ConcurrentLinkedQueue<String>();

    public String poll() {
        String url = highLevelQueue.poll();
        if (StringUtils.isBlank(url)){
            url = lowLevelQueue.poll();
        }
        return url;
    }

    public void addHighLevel(String url) {
        this.highLevelQueue.add(url);
    }

    public void addLowLevel(String url) {
        this.lowLevelQueue.add(url);
    }
}
