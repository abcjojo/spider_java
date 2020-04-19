package com.java.spider.service.impl;

import com.java.spider.entity.Page;
import com.java.spider.service.IDownloadService;
import com.java.spider.util.PageDownloadUtil;
import org.springframework.stereotype.Component;

/**
 * @program: learn_spider
 * @description: HttpClient页面下载实现类
 * @author: Jojo.Lee
 * @create: 2020-03-05 14:51
 **/
@Component
public class HttpClientDownloadServiceImpl implements IDownloadService {


    public Page download(String url) {

        Page page = new Page();
        page.setContent(PageDownloadUtil.getPageContent(url));
        page.setUrl(url);
        return page;
    }
}
