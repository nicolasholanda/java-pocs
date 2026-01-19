package com.github.nicolasholanda.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorBasics {

    static void execute() {

        System.out.println("Fixed thread pool:");
        try(ExecutorService fixed = Executors.newFixedThreadPool(2)) {
            for (int i = 1; i <= 4; i++) {
                int taskId = i;
                fixed.submit(() -> {
                    System.out.println("Task " + taskId + " on " + Thread.currentThread().getName());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException _) {
                    }
                });
            }
        }


        System.out.println("Cached thread pool:");
        try (ExecutorService cached = Executors.newCachedThreadPool()) {
            for (int i = 1; i <= 3; i++) {
                int taskId = i;
                cached.submit(() -> System.out.println("Task " + taskId + " on " + Thread.currentThread().getName()));
            }
        }
    }
}

