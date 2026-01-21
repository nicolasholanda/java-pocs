package com.github.nicolasholanda.concurrency;

public class ConcurrencyDemo {

    static void main() throws Exception {

        System.out.println("--- Executor basics ---");
        ExecutorBasics.execute();

        System.out.println("--- Callable and Future ---");
        ExecutorCallable.execute();

        System.out.println("--- Scheduled executor ---");
        ExecutorScheduled.execute();

        System.out.println("--- Locks ---");
        ConcurrencyLocks.execute();
    }
}

