package com.github.nicolasholanda.designpatterns.structural.facade;

import java.util.Arrays;

class Memory {
    void load(long position, byte[] data) {
        System.out.printf("Memory: Loading data %s at %s", Arrays.toString(data), position);
    }
}
