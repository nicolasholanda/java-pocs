package com.github.nicolasholanda.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

public class QuartzJobData {

    static class DataJob implements Job {
        public void execute(JobExecutionContext context) throws JobExecutionException {
            JobDataMap data = context.getJobDetail().getJobDataMap();
            String name = data.getString("name");
            int count = data.getInt("count");
            System.out.println("DataJob executed - name: " + name + ", count: " + count);
        }
    }

    static void execute() {
        try {
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
            scheduler.start();

            JobDetail job = JobBuilder.newJob(DataJob.class)
                    .withIdentity("dataJob", "data")
                    .usingJobData("name", "Quartz")
                    .usingJobData("count", 42)
                    .build();

            Trigger trigger = TriggerBuilder.newTrigger()
                    .withIdentity("dataTrigger", "data")
                    .startNow()
                    .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                            .withIntervalInSeconds(1)
                            .withRepeatCount(1))
                    .build();

            scheduler.scheduleJob(job, trigger);
            Thread.sleep(3000);
            scheduler.shutdown();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
