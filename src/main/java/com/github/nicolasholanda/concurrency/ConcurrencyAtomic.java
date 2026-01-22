package com.github.nicolasholanda.concurrency;

import java.util.concurrent.atomic.*;

public class ConcurrencyAtomic {

    static void execute() throws InterruptedException {

        System.out.println("AtomicInteger:");
        AtomicInteger counter = new AtomicInteger(0);
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.incrementAndGet();
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.incrementAndGet();
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("Counter: " + counter.get());
    }
}

