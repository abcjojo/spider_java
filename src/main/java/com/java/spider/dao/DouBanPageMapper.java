package com.java.spider.dao;

import com.java.spider.entity.Page;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface DouBanPageMapper {

    Page getById(int id);

    int deleteByPrimaryKey(Integer id);

    int insert(Page record);

    Page selectByPrimaryKey(Integer id);

    List<Page> selectAll();

    int updateByPrimaryKey(Page record);
}
