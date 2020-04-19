package com.java.spider.mytest;

import com.java.spider.entity.Page;
import com.java.spider.service.DouBanPageService;
import com.java.spider.service.SolrService;
import com.java.spider.service.impl.DouBanPageServiceImpl;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.io.IOException;

/**
 * @program: learn_spider
 * @description:
 * @author: Jojo.Lee
 * @create: 2020-03-22 11:33
 **/

public class TestClass {

    private HttpSolrClient solrClient = new HttpSolrClient.Builder("http://localhost:8983/solr/").build();

    @Resource
    private SolrService solrService;
    @Resource
    private DouBanPageService douBanPageService;


    @Test
    public void method() throws IOException, SolrServerException {
//        UpdateResponse updateResponse = solrClient.deleteById("spider","2");
//        solrClient.commit("spider");
//        int status = updateResponse.getStatus();
//        System.out.println("状态码："+status);

        Page page = new Page();
        page.setId(1);
        page.setName("test00101");
        page.setVideoId("1101101");
        page.setUrl("www.ertesf.sf.sfs.fsf");
        page.setNo(11012);
        douBanPageService.insert(page);

    }
}