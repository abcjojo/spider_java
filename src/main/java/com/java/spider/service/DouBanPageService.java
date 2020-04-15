package com.java.spider.service;

import com.java.spider.entity.Page;
import com.java.spider.entity.TestSpiderDoubanmovietop250;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
public interface DouBanPageService {

//    Page getById(int id);

    List<TestSpiderDoubanmovietop250> selectAll();

    TestSpiderDoubanmovietop250 selectByPrimaryKey(Integer id);

    int select123();
}
