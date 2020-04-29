package com.java.spider.dao;

import com.java.spider.entity.Page;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface DouBanPageMapper {

    Page getById(int id);

    int deleteByPrimaryKey(Integer id);

    int insert(Page record);

    Page selectByPrimaryKey(Map map);
    Page selectByVedioId(String videoId);

    List<Page> selectAll();

    int updateByPrimaryKey(Page record);

    List<Map> countByParse(Page page);
}
