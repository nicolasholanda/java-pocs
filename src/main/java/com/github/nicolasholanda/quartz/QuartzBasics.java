package com.github.nicolasholanda.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

public class QuartzBasics {

    static class HelloJob implements Job {
        public void execute(JobExecutionContext context) throws JobExecutionException {
            System.out.println("HelloJob executed at: " + new java.util.Date());
        }
    }

    static void execute() {
        try {
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
            scheduler.start();

            JobDetail job = JobBuilder.newJob(HelloJob.class)
                    .withIdentity("helloJob", "basics")
                    .build();

            Trigger trigger = TriggerBuilder.newTrigger()
                    .withIdentity("simpleTrigger", "basics")
                    .startNow()
                    .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                            .withIntervalInSeconds(1)
                            .withRepeatCount(2))
                    .build();

            scheduler.scheduleJob(job, trigger);
            Thread.sleep(4000);
            scheduler.shutdown();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
