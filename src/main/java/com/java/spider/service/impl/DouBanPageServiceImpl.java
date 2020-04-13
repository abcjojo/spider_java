package com.java.spider.service.impl;

import com.java.spider.entity.Page;
import com.java.spider.mapper.DouBanPageDao;
import com.java.spider.service.DouBanPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: learn_spider
 * @description:
 * @author: Jojo.Lee
 * @create: 2020-04-12 16:39
 **/


@Service
public class DouBanPageServiceImpl implements DouBanPageService {

    @Autowired
    private DouBanPageDao dao;

    @Override
    public Page getById(int id) {
        System.out.println("service over");
        return dao.getById(id);
    }

}
