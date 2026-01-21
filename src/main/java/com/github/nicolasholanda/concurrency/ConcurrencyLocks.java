package com.github.nicolasholanda.concurrency;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ConcurrencyLocks {

    static void execute() throws InterruptedException {

        System.out.println("ReentrantLock:");

        Lock lock = new ReentrantLock();

        Thread t1 = new Thread(() -> {
            lock.lock();
            try {
                System.out.println("Thread 1 acquired lock");
                Thread.sleep(1000);
            } catch (InterruptedException _) {
            } finally {
                lock.unlock();
                System.out.println("Thread 1 released lock");
            }
        });

        Thread t2 = new Thread(() -> {
            lock.lock();
            try {
                System.out.println("Thread 2 acquired lock");
            } finally {
                lock.unlock();
                System.out.println("Thread 2 released lock");
            }
        });

        t1.start();
        Thread.sleep(100);
        t2.start();

        t1.join();

        t2.join();
    }
}

