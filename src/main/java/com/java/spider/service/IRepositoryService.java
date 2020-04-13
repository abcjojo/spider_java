package com.java.spider.service;
/**
* @Description: 存储url仓库接口
* @Param:
* @return:
* @Author: Jojo.Lee
* @Date:
*/
public interface IRepositoryService {

    public String poll();

    public void addHighLevel(String url);

    public void addLowLevel(String url);
}
