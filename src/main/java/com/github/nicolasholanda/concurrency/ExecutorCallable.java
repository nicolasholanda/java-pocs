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
    }
}

