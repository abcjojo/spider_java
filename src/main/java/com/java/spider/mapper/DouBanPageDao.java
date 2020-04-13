package com.java.spider.mapper;

import com.java.spider.entity.Page;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DouBanPageDao {

    public Page getById(@Param("id") int id);

}
