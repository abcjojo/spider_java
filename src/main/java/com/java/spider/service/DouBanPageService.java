package com.java.spider.service;

import com.java.spider.entity.Page;
import com.java.spider.entity.TestSpiderDoubanmovietop250;
import java.util.List;


public interface DouBanPageService {

    Page getById(int id);

    int deleteByPrimaryKey(Integer id);

    int insert(Page record);

    Page selectByPrimaryKey(Integer id);

    List<Page> selectAll();

    int updateByPrimaryKey(Page record);
}
