package com.java.spider.util;


import org.junit.platform.commons.util.StringUtils;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * @program: learn_spider
 * @description: redis连接工具类
 * @author: Jojo.Lee
 * @create: 2020-03-30 19:19
 **/
public class RedisUtil {

    //redis中列表key的名称
    public static String highkey = "spider.highlevel";
    public static String lowkey = "spider.lowlevel";

    public static String starturl = "start.url";

    //已解析的url集合
    public static String urlSet = "spider.urlset";
   // public static String urlSet = "spider.lowlevel";

    JedisPool jedisPool = null;

    public RedisUtil(){
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxIdle(100);//最大空闲
        poolConfig.setMaxTotal(100);
        poolConfig.setMaxWaitMillis(10000);
        poolConfig.setTestOnBorrow(true);

        //记得改ip
        //jedisPool = new JedisPool(poolConfig,"192.168.1.108",6379);
        jedisPool = new JedisPool(poolConfig,"localhost",6379);
    }

    //查询指定范围数据
    public List<String> lrange(String key, int start, int end){
        Jedis resource = jedisPool.getResource();
        List<String> list = resource.lrange(key,start,end);
        jedisPool.returnResourceObject(resource);
        return list;
    }

    //添加数据     lpush + rpop = Queue（队列）
    public void add(String key, String url){
        Jedis resource = jedisPool.getResource();
        resource.lpush(key,url);
        jedisPool.returnResourceObject(resource);
    }

    //获取url
    public String poll(String key){
        Jedis resource = jedisPool.getResource();
        String result = resource.rpop(key);
        jedisPool.returnResourceObject(resource);
        if (StringUtils.isNotBlank(result)) {
            int parse = addUrlToSet(result);
            //url插入set时失败返回0，则该url已解析过，跳过此url,pop下一条url
            if (parse == 0){
                poll(key);
            }
        }
        return result;
    }

    //把从队列中poll出去(已解析)的url添加到set中，供url定时更新使用
    public int addUrlToSet(String url){
        Jedis resource = jedisPool.getResource();
        Long result = resource.sadd(urlSet,url);
        jedisPool.returnResourceObject(resource);
        return result.intValue();
    }

    //查看set中的数据
    public void showSet(String key){
        Jedis resource = jedisPool.getResource();
        Set<String> sets =  resource.smembers(key);
        Iterator<String> iterator = sets.iterator();
        System.out.println("The members of myset are: ");
        while(iterator.hasNext()){
            String it = iterator.next();
            System.out.println(it);
        }
    }

//    测试redis
    public static void main(String[] args) {
        RedisUtil redis = new RedisUtil();
        String url = "https://movie.douban.com/top250?start=50&filter=";
        redis.add(lowkey,"https://movie.douban.com/subject/1292063/");
        redis.add(lowkey,"https://movie.douban.com/subject/1292063/");
        redis.add(lowkey,"jojo");
        redis.add(lowkey,"java");
        //redis.add(lowkey,null);
        redis.add(lowkey,url);
        System.out.println(redis.poll(lowkey));
        System.out.println(redis.poll(lowkey));
        System.out.println(redis.poll(lowkey));
    }

}
