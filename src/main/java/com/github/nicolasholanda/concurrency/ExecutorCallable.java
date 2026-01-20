package com.github.nicolasholanda.concurrency;

import java.util.concurrent.*;

public class ExecutorCallable {
    
    static void execute() throws ExecutionException, InterruptedException {
        
        System.out.println("Callable returning value:");
        try (ExecutorService executor = Executors.newSingleThreadExecutor()) {
            Callable<Integer> task = () -> {
                Thread.sleep(1000);
                return 42;
            };
            Future<Integer> future = executor.submit(task);
            System.out.println("Result: " + future.get());
        }



        System.out.println("Exception handling:");
        try (ExecutorService executor = Executors.newSingleThreadExecutor()) {
            Future<Integer> future = executor.submit(() -> {
                throw new RuntimeException("Task failed");
            });
            try {
                future.get();
            } catch (ExecutionException e) {
                System.out.println("Exception: " + e.getCause().getMessage());
            }
        }



        System.out.println("Future status:");
        try (ExecutorService executor = Executors.newSingleThreadExecutor()) {
            Future<String> future = executor.submit(() -> {
                Thread.sleep(2000);
                return "Done";
            });
            System.out.println("Is done: " + future.isDone());
            System.out.println("Is cancelled: " + future.isCancelled());
            System.out.println("Result: " + future.get());
            System.out.println("Is done: " + future.isDone());
        }
    }
}

