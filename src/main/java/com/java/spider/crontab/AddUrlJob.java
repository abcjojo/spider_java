package com.java.spider.crontab;

import com.java.spider.util.LoadPropertyUtil;
import com.java.spider.util.RedisUtil;
import org.quartz.*;


/**
 * @program: learn_spider
 * @description:    为什么设计成JobDetail + Job，不直接使用Job？这是因为任务是有可能并发执行？
 *                  如果Scheduler直接使用Job，就会存在对同一个Job实例并发访问的问题。而JobDetail & Job 方式，
 *                  sheduler每次执行，都会根据JobDetail创建一个新的Job实例，这样就可以规避并发访问的问题。
 * @author: Jojo.Lee
 * @create: 2020-04-01 10:45
 **/
public class AddUrlJob implements Job {

    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("Quartz启动成功！");
        System.out.println("定时任务启动！系统将会每30分钟刷新一次任务。");
//        JobDataMap jobDataMap = jobExecutionContext.getJobDetail().getJobDataMap();
//        System.out.println(jobDataMap.get("level") + "   " + jobDataMap.get("job"));

        try {
            executeTask();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    //job逻辑主体
    private void executeTask() throws SchedulerException {

        //获取起始url，添加到redis中爬虫会自动解析
        String startUrl = LoadPropertyUtil.getDouBan("startUrl");
        new RedisUtil().add(RedisUtil.highkey,startUrl);

    }
}
