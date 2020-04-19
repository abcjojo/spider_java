package com.java.spider.Repository.impl;

import com.java.spider.Repository.SolrRepository;
import com.java.spider.entity.Page;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: spider
 * @description:    solr数据访问层
 * @author: Jojo.Lee
 * @create: 2020-04-17 21:17
 **/

@Repository
public class SolrRepositoryImpl implements SolrRepository {

    @Autowired
    private SolrClient solrClient;

    @Override
    public Integer delById(Integer id) throws IOException, SolrServerException {

        UpdateResponse updateResponse =  solrClient.deleteById("spider",id.toString());
        solrClient.commit("spider");
        return updateResponse.getStatus();
    }

    @Override
    public void insert(Page page) {
        UpdateResponse updateResponse = null;
        try {
            updateResponse = solrClient.addBean("spider",page);
            int status = updateResponse.getStatus();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SolrServerException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Map<String, Object> selectByParse(Page page, Integer start, Integer pageSiza) throws IOException, SolrServerException {

        SolrQuery solrQuery = new SolrQuery();
        if (StringUtils.isNotBlank(page.getName())){
            solrQuery.addHighlightField(page.getName());
            solrQuery.set("name:"+page.getName());
        }

        if (StringUtils.isNotBlank(page.getCountry())) {
            solrQuery.set("country:"+page.getCountry());
            solrQuery.addHighlightField(page.getCountry());//需要添加的高亮显示的字段
        }
        if (StringUtils.isNotBlank(page.getLanguage())){
            solrQuery.set("language:"+page.getLanguage());
            solrQuery.addHighlightField(page.getLanguage());
        }
        if (StringUtils.isNotBlank(page.getType())){
            solrQuery.set("type:"+page.getType());
            solrQuery.addHighlightField(page.getType());
        }

        solrQuery.setStart(start);
        solrQuery.setRows(pageSiza);
        solrQuery.setHighlight(true);//启用高亮查询
        solrQuery.setHighlightSimplePre("<font color='red'>");//高亮前缀
        solrQuery.setHighlightSimplePost("</font>");//高亮后缀

        QueryResponse queryResponse = solrClient.query("spider", solrQuery);
        //获取数据总行数
        long numFound = queryResponse.getResults().getNumFound();
        //获取普通结果
        List<Page> paegList = queryResponse.getBeans(Page.class);
        //获取高亮结果
        Map<String, Map<String, List<String>>> highlighting= queryResponse.getHighlighting();

        //将普通结果中的字段name替换为高亮后的值
        for (Page data : paegList){
            //获取高亮结果
            String name_high = highlighting.get(data.getId()).get("name").get(0);
            //替换
            data.setName(name_high);
        }
        Map<String, Object> map = new HashMap<>();
        map.put("numFound",numFound);
        map.put("list",paegList);
        return map;
    }
}
