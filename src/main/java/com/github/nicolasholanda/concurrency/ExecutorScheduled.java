package com.github.nicolasholanda.concurrency;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ExecutorScheduled {
    
    static void execute() throws InterruptedException {
        
        System.out.println("run one time after delaay:");
        try (ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1)) {
            scheduler.schedule(() -> System.out.println("Task executed after 1s"), 1, TimeUnit.SECONDS);
            Thread.sleep(2000);
        }



        System.out.println("scheduleAtFixedRate:");
        try (ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1)) {
            scheduler.scheduleAtFixedRate(
                () -> System.out.println("Fixed rate task in " + System.currentTimeMillis()),
                0,
                1,
                TimeUnit.SECONDS
            );
            Thread.sleep(3500);
        }

    }
}

