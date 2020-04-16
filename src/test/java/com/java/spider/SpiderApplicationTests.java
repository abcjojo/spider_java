package com.java.spider;

import com.java.spider.entity.Page;
import com.java.spider.service.DouBanPageService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;


@SpringBootTest(classes = SpiderApplication.class)
@RunWith(SpringRunner.class)
public class SpiderApplicationTests {

    @Resource
    private DouBanPageService douBanPageService;



    @Test
    public void contextLoads() {

        Page data = douBanPageService.getById(1);
        System.out.println(data.getUrl());

        data.setName("insertTest");
        int insert = douBanPageService.insert(data);
        System.out.println(insert);

        data.setName("updataTest");
        int update = douBanPageService.updateByPrimaryKey(data);

        Page data1 = douBanPageService.selectByPrimaryKey(2);
        System.out.println(data1.getUrl());

        int delect = douBanPageService.deleteByPrimaryKey(3);
        System.out.println(delect);

        List<Page> selectAll = douBanPageService.selectAll();
        System.out.println(selectAll.get(0).getUrl());
    }

}
