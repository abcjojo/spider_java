package com.java.spider.service.impl;

import com.java.spider.entity.Page;
import com.java.spider.entity.TestSpiderDoubanmovietop250;
import com.java.spider.dao.DouBanPageMapper;
import com.java.spider.dao.TestSpiderDoubanmovietop250Mapper;
import com.java.spider.service.DouBanPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: learn_spider
 * @description:
 * @author: Jojo.Lee
 * @create: 2020-04-12 16:39
 **/


@Service
public class DouBanPageServiceImpl implements DouBanPageService {

    @Autowired
    private TestSpiderDoubanmovietop250Mapper testSpiderDoubanmovietop250Mapper;

    public List<TestSpiderDoubanmovietop250> selectAll(){
        return testSpiderDoubanmovietop250Mapper.selectAll();
    }

    @Override
    public TestSpiderDoubanmovietop250 selectByPrimaryKey(Integer id) {
        return testSpiderDoubanmovietop250Mapper.selectByPrimaryKey(id);
    }

    @Override
    public int select123() {
        System.out.println("213 over");
        return this.testSpiderDoubanmovietop250Mapper.select123();
    }


}
