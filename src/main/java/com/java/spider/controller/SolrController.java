package com.java.spider.controller;

import com.java.spider.entity.Page;
import com.java.spider.service.SolrService;
import com.java.spider.start.StartMovieCount;
import org.apache.solr.client.solrj.SolrServerException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @program: spider
 * @description:
 * @author: Jojo.Lee
 * @create: 2020-04-17 21:13
 **/

@RestController
@RequestMapping("/solr")
public class SolrController {

    @Resource
    private SolrService solrService;

    @RequestMapping("/delById")
    public Integer delById(int id) throws IOException, SolrServerException {
        return solrService.delById(id);
    }

    @RequestMapping("/add")
    public void add(Page page){
        solrService.add(page);
    }


    @RequestMapping(value = "/selectAll")
    public List selectAll() throws IOException, SolrServerException {
        return solrService.selectAll();
    }

    /**
    * @Description:    根据参数查找
    * @Param:
    * @return:
    * @Author: Jojo.Lee
    * @Date:
    */

    @RequestMapping("/selectByParse")
    public Map<String,Object> selectByParse(Page page, Integer pageNow, Integer pageSiza) throws IOException, SolrServerException {
        return solrService.selectByParse(page, pageNow, pageSiza);
    }

}
