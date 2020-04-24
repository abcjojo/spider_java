package com.java.spider.service;

import com.java.spider.entity.Page;
import org.apache.solr.client.solrj.SolrServerException;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @program: spider
 * @description:
 * @author: Jojo.Lee
 * @create: 2020-04-17 21:13
 **/
public interface SolrService {
    Integer delById(int id) throws IOException, SolrServerException;

    void add(Page page);

    Map<String,Object> selectByParse(Page page, Integer pageNow, Integer pageSiza) throws IOException, SolrServerException;

    List selectAll() throws IOException, SolrServerException;

    void testQueryFromSolr() throws IOException, SolrServerException;
}
