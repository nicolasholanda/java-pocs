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

        System.out.println("AtomicInteger compareAndSet:");
        AtomicInteger value = new AtomicInteger(10);
        boolean updated = value.compareAndSet(10, 20);
        System.out.println("Updated: " + updated + ", Value: " + value.get());
        updated = value.compareAndSet(10, 30);
        System.out.println("Updated: " + updated + ", Value: " + value.get());

        System.out.println("AtomicLong:");
        AtomicLong sum = new AtomicLong(0);
        sum.addAndGet(100);
        sum.addAndGet(200);
        System.out.println("Sum: " + sum.get());

        System.out.println("AtomicBoolean:");
        AtomicBoolean flag = new AtomicBoolean(false);
        System.out.println("Initial: " + flag.get());
        flag.set(true);
        System.out.println("After set: " + flag.get());
        boolean previous = flag.getAndSet(false);
        System.out.println("Previous: " + previous + ", Current: " + flag.get());

        System.out.println("AtomicReference:");
        AtomicReference<String> ref = new AtomicReference<>("initial");
        System.out.println("Value: " + ref.get());
        ref.set("updated");
        System.out.println("Value: " + ref.get());
        ref.compareAndSet("updated", "final");
        System.out.println("Value: " + ref.get());
    }
}

