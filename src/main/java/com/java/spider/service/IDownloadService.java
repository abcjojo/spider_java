package com.java.spider.service;

import com.java.spider.entity.Page;

/**
* @Description:   页面下载接口
* @Param:
* @return:
* @Author: Jojo.Lee
* @Date:
*/
public interface IDownloadService {

    Page download(String url);

}
