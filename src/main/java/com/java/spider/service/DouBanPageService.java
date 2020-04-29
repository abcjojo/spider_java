package com.java.spider.service;

import com.java.spider.entity.Page;

import java.util.List;
import java.util.Map;


public interface DouBanPageService {

    Page getById(int id);

    int deleteByPrimaryKey(Integer id);

    int insert(Page record);

    Page selectByPrimaryKey(Map map);

    Page selectByVedioId(String videoId);

    List<Page> selectAll();

    int updateByPrimaryKey(Page record);

    List<Map> countByParse(Page page);
}
