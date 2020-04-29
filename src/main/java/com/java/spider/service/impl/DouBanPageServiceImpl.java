package com.java.spider.service.impl;

import com.java.spider.dao.DouBanPageMapper;
import com.java.spider.entity.Page;
import com.java.spider.service.DouBanPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @program: learn_spider
 * @description:
 * @author: Jojo.Lee
 * @create: 2020-04-12 16:39
 **/

@Service
@Transactional
public class DouBanPageServiceImpl implements DouBanPageService {


    @Autowired
    private DouBanPageMapper douBanPageMapper;


    @Override
    public Page getById(int id) {
        return douBanPageMapper.getById(id);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return douBanPageMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Page record) {
        return douBanPageMapper.insert(record);
    }

    @Override
    public Page selectByPrimaryKey(Map map) {
        return douBanPageMapper.selectByPrimaryKey(map);
    }

    @Override
    public Page selectByVedioId(String videoId) {
        return douBanPageMapper.selectByVedioId(videoId);
    }

    @Override
    public List<Page> selectAll() {
        return douBanPageMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(Page record) {
        return douBanPageMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Map> countByParse(Page page) {
        return douBanPageMapper.countByParse(page);
    }

}
