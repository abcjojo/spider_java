package com.java.spider.crontab;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import static org.quartz.JobBuilder.newJob;

/**
 * @program: learn_spider
 * @description:   学习笔记：Quartz使用总结： https://www.cnblogs.com/drift-ice/p/3817269.html
 * @author: Jojo.Lee
 * @create: 2020-03-31 21:40
 **/
public class UrlScheduler {

    public static void main(String[] args) {

        try {
            Scheduler scheduler = new StdSchedulerFactory().getScheduler();
            JobDetail jobDetail = newJob(AddUrlJob.class) //定义Job类为AddUrlJob类，这是真正的执行逻辑所在
                    .withDescription("this is a job") //添加描述
                    .withIdentity("job",Scheduler.DEFAULT_GROUP)//定义name/group
                    .usingJobData("level","test")//定义属性
                    .build();

            JobDataMap jobDataMap = jobDetail.getJobDataMap();
            jobDataMap.put("job","-quartz");


            //cron在线生成时间间隔格式：https://qqe2.com/cron
            Trigger trigger = TriggerBuilder.newTrigger()
                    .withDescription("this is a trigger")//添加描述
                    //每30分钟刷一次
                    .withSchedule(CronScheduleBuilder.cronSchedule("* 0/30 * * * ? "))
                    //测试数据 每1分钟跑一次
                    //.withSchedule(CronScheduleBuilder.cronSchedule("0/59 * * * * ? "))
                    .withIdentity("trigger",Scheduler.DEFAULT_GROUP)//定义name/group
                    .build();
            //将触发器以及调度任务详情绑定到调度器上
            scheduler.scheduleJob(jobDetail,trigger);
            //启动调度器
            scheduler.start();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }

    }
}
