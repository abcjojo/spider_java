package com.java.spider.util;

import com.java.spider.entity.Page;
import flexjson.JSONSerializer;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @program: spider
 * @description:
 * @author: Jojo.Lee
 * @create: 2020-04-21 17:03
 **/
@Component
public class BasicUtil {

    //json数据转换成String类型
    public String toString(List<Page> list){
        JSONSerializer serializer = new JSONSerializer();
        //去除class属性
        serializer.exclude("class");
        return serializer.serialize(list);
    }
}
