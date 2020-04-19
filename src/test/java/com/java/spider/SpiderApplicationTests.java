package com.java.spider;

import com.java.spider.controller.SolrController;
import com.java.spider.controller.SpiderController;
import com.java.spider.entity.Page;
import com.java.spider.service.DouBanPageService;
import com.java.spider.service.SolrService;
import com.java.spider.start.StartMovieCount;
import org.apache.solr.client.solrj.SolrServerException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;


@SpringBootTest(classes = SpiderApplication.class)
@RunWith(SpringRunner.class)
public class SpiderApplicationTests {

    @Resource
    private DouBanPageService douBanPageService;

    @Resource
    private SolrService solrService;
    @Resource
    private SpiderController spiderController;
    @Test
    public void contextLoads() throws IOException, SolrServerException {

        String url = "https://movie.douban.com/subject/1309163/";
        spiderController.startDouBanTop(url);

//        Page page = new Page();
//        page.setId(4);
//        page.setName("test00101");
//        page.setVideoId("1101101");
//        page.setUrl("www.ertesf.sf.sfs.fsf");
//        page.setNo(11012);
//        page.setScore(110);
//        page.setNumber(12);
//        page.setCountry("cha");
//        page.setReleaseDate("20200101");
//        page.setType("happy");
//        page.setLanguage("chinese");
//        page.setMins(1568);
//        solrService.add(page);
//
//        solrController.add(page);


//        Integer res = solrService.delById(1);
//        System.out.println(res);
//        Page data = douBanPageService.getById(1);
//        System.out.println(data.getUrl());
//
//        data.setName("insertTest");
//        int insert = douBanPageService.insert(data);
//        System.out.println(insert);
//
//        data.setName("updataTest");
//        int update = douBanPageService.updateByPrimaryKey(data);
//
//        Page data1 = douBanPageService.selectByPrimaryKey(2);
//        System.out.println(data1.getUrl());
//
//        int delect = douBanPageService.deleteByPrimaryKey(3);
//        System.out.println(delect);
//
//        List<Page> selectAll = douBanPageService.selectAll();
//        System.out.println(selectAll.get(0).getUrl());
    }

}
