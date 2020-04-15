package com.java.spider;

import com.java.spider.entity.TestSpiderDoubanmovietop250;
import com.java.spider.service.DouBanPageService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@SpringBootTest(classes = SpiderApplication.class)
@RunWith(SpringRunner.class)
public class SpiderApplicationTests {

    @Autowired
    private DouBanPageService douBanPageService;

//    @Autowired
//    private TestController testController;

    @Test
    void contextLoads() {
        //List<TestSpiderDoubanmovietop250> list = controller.getAll();
        TestSpiderDoubanmovietop250 data = douBanPageService.selectByPrimaryKey(1);
        System.out.println(data.getUrl());

//        System.out.println(list.get(0));
    }

}
