package com.java.spider.service;
/**
* @Description: 存储url仓库接口
* @Param:
* @return:
* @Author: Jojo.Lee
* @Date:
*/
public interface IRepositoryService {

    String poll();

    void addHighLevel(String url);

    void addLowLevel(String url);
}
