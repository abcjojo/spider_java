package com.java.spider.dao;

import com.java.spider.entity.TestSpiderDoubanmovietop250;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface TestSpiderDoubanmovietop250Mapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TestSpiderDoubanmovietop250 record);

    TestSpiderDoubanmovietop250 selectByPrimaryKey(Integer id);

    List<TestSpiderDoubanmovietop250> selectAll();

    int updateByPrimaryKey(TestSpiderDoubanmovietop250 record);

    int select123();
}