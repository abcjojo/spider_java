package com.java.spider.controller;

import com.java.spider.entity.Page;
import com.java.spider.service.DouBanPageService;
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

    @Resource
    private DouBanPageService douBanPageService;

    @RequestMapping(value = "/countByType1")
    public List<Map> countByType1() {
        Page page = new Page();
        page.setType1("type1");
        List<Map> list = douBanPageService.countByParse(page);
        System.out.println(list);
        return list;
    }

    @RequestMapping(value = "/countByType2")
    public List<Map> countByType2() {
        Page page = new Page();
        page.setType2("type2");
        List<Map> list = douBanPageService.countByParse(page);
        System.out.println(list);
        return list;
    }

    @RequestMapping(value = "/countByCountry")
    public List<Map> countByCountry() {
        Page page = new Page();
        page.setCountry("country");
        List<Map> list = douBanPageService.countByParse(page);
        System.out.println(list);
        return list;
    }

    @RequestMapping(value = "/countByLanguage")
    public List<Map> countByLanguage() {
        Page page = new Page();
        page.setLanguage("language");
        List<Map> list = douBanPageService.countByParse(page);
        System.out.println(list);
        return list;
    }

    @RequestMapping(value = "/countByYear")
    public List<Map> countByYear() {
        Page page = new Page();
        page.setYear(0010);
        List<Map> list = douBanPageService.countByParse(page);
        System.out.println(list);
        return list;
    }

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
        List<Page> list = solrService.selectAll();
        System.out.println();
        return list;
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
