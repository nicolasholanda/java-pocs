package com.github.nicolasholanda.designpatterns.creational.singleton;

public enum SingletonEnum {
    INSTANCE;

    public void doSomething() {
        System.out.println("Enum singleton method called");
    }
}

