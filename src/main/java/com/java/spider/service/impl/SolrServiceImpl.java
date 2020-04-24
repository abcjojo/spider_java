package com.java.spider.service.impl;

import com.java.spider.Repository.SolrRepository;
import com.java.spider.entity.Page;
import com.java.spider.service.DouBanPageService;
import com.java.spider.service.SolrService;
import org.apache.solr.client.solrj.SolrServerException;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: spider
 * @description:
 * @author: Jojo.Lee
 * @create: 2020-04-17 21:14
 **/

@Service
public class SolrServiceImpl implements SolrService {
    @Resource
    private SolrRepository solrRepository;
    @Resource
    private DouBanPageService douBanPageService;

//    private static SolrServiceImpl solrServiceImpl;
//    @PostConstruct //通过@PostConstruct实现初始化bean之前进行的操作
//    public void init() {
//        solrServiceImpl = this;
//        solrServiceImpl.solrRepository = this.solrRepository;
//        solrServiceImpl.douBanPageService = this.douBanPageService;
//        // 初使化时将已静态化的testService实例化
//    }

    @Override
    public Integer delById(int id) throws IOException, SolrServerException {
        //删除MySQL中的数据
        int res1 = douBanPageService.deleteByPrimaryKey(id);
        //删除solr中的数据
        int res2 =solrRepository.delById(id);
        return res1 & res2;
    }

    @Override
    public void add(Page page) {
        //新增MySQL中的数据
        douBanPageService.insert(page);
        //System.out.println("Mysql新增数据状态码："+statusMysql);
        System.out.println("数据库新增电影："+page.getName()+" 信息成功！");
        Page tmp = douBanPageService.selectByVedioId(page.getVideoId());
        page.setId(tmp.getId());
        //新增solr中的数据
        solrRepository.insert(page);
        System.out.println("solr新增电影："+page.getName()+" 信息成功！");
    }

    @Override
    public Map<String,Object> selectByParse(Page page, Integer pageNow, Integer pageSiza) throws IOException, SolrServerException {

        //起始页
        int start = (pageNow-1)*pageSiza;
        //直接到solr中查询数据
        return solrRepository.selectByParse(page, start, pageSiza);
    }

    @Override
    public List selectAll() throws IOException, SolrServerException {
        System.out.println("selectAll方法执行了");
        return solrRepository.selectAll();
    }

    @Override
    public void testQueryFromSolr() throws IOException, SolrServerException {
        solrRepository.testQueryFromSolr();
    }
}
