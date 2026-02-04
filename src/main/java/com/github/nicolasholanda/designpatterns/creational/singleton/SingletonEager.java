package com.github.nicolasholanda.designpatterns.creational.singleton;

public class SingletonEager {

    private static final SingletonEager instance = new SingletonEager();

    private SingletonEager() {
    }

    public static SingletonEager getInstance() {
        return instance;
    }
}

