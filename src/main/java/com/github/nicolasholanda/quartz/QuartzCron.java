package com.github.nicolasholanda.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

public class QuartzCron {

    static class CronJob implements Job {
        public void execute(JobExecutionContext context) throws JobExecutionException {
            System.out.println("CronJob executed at: " + new java.util.Date());
        }
    }

    static void execute() {
        try {
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
            scheduler.start();

            JobDetail job = JobBuilder.newJob(CronJob.class)
                    .withIdentity("cronJob", "cron")
                    .build();

            CronTrigger trigger = TriggerBuilder.newTrigger()
                    .withIdentity("cronTrigger", "cron")
                    .withSchedule(CronScheduleBuilder.cronSchedule("0/1 * * * * ?"))
                    .build();

            scheduler.scheduleJob(job, trigger);
            Thread.sleep(4000);
            scheduler.shutdown();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
