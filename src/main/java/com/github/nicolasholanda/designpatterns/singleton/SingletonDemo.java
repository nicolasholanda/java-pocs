package com.github.nicolasholanda.designpatterns.singleton;

public class SingletonDemo {

    static void execute() {
        SingletonLazy lazy1 = SingletonLazy.getInstance();
        SingletonLazy lazy2 = SingletonLazy.getInstance();
        System.out.println("Lazy - Same instance: " + (lazy1 == lazy2));

        SingletonThreadSafe safe1 = SingletonThreadSafe.getInstance();
        SingletonThreadSafe safe2 = SingletonThreadSafe.getInstance();
        System.out.println("Thread-safe - Same instance: " + (safe1 == safe2));

        SingletonDoubleChecked dc1 = SingletonDoubleChecked.getInstance();
        SingletonDoubleChecked dc2 = SingletonDoubleChecked.getInstance();
        System.out.println("Double-checked - Same instance: " + (dc1 == dc2));

        SingletonEager eager1 = SingletonEager.getInstance();
        SingletonEager eager2 = SingletonEager.getInstance();
        System.out.println("Eager - Same instance: " + (eager1 == eager2));

        SingletonBillPugh bp1 = SingletonBillPugh.getInstance();
        SingletonBillPugh bp2 = SingletonBillPugh.getInstance();
        System.out.println("Bill Pugh - Same instance: " + (bp1 == bp2));

        SingletonEnum enum1 = SingletonEnum.INSTANCE;
        SingletonEnum enum2 = SingletonEnum.INSTANCE;
        System.out.println("Enum - Same instance: " + (enum1 == enum2));
        enum1.doSomething();
    }
}

