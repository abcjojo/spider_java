package com.java.spider.Repository;

import com.java.spider.entity.Page;
import org.apache.solr.client.solrj.SolrServerException;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface SolrRepository {
    Integer delById(Integer id) throws IOException, SolrServerException;

    void insert(Page page);

    Map<String, Object> selectByParse(Page page, Integer pageNow, Integer pageSiza) throws IOException, SolrServerException;

    List selectAll() throws IOException, SolrServerException;

    void testQueryFromSolr() throws IOException, SolrServerException;
}
