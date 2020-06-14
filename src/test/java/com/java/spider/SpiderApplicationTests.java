package com.java.spider;

import com.java.spider.controller.SolrController;
import com.java.spider.controller.SpiderController;
import com.java.spider.service.DouBanPageService;
import com.java.spider.service.SolrService;
import org.apache.solr.client.solrj.SolrServerException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;
import java.util.Map;


@SpringBootTest(classes = SpiderApplication.class)
@RunWith(SpringRunner.class)
public class SpiderApplicationTests {

    @Resource
    private DouBanPageService douBanPageService;

    @Resource
    private SolrService solrService;
    @Resource
    private SpiderController spiderController;
    @Resource
    private SolrController solrController;

    @Test
    public void contextLoads() throws IOException, SolrServerException {


//        List<Map> list = solrController.countByType1();
//        System.out.println(list.get(0).get("countType1"));
//        System.out.println(list.get(0).get("type1"));
//        System.out.println(list.get(0));


        //solrService.testQueryFromSolr();

        //String url = "https://movie.douban.com/subject/27191492/";
       // String test = "https://www.processon.com/";
        String url = "https://movie.douban.com/top250?start=0&filter=";

        spiderController.startDouBanTop(url);

       //String url = "https://movie.douban.com/subject/1309163/";
        //solrService.selectAll();'


        //Page page = new Page();
        //page.setName("恋恋笔记本");
        //solrService.selectByParse(page,1,10);

        //Page page = new Page();
//        page.setId(15);
        //page.setName("恋恋笔记本");
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
        //solrService.add(page);



        //solrController.add(page);


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
