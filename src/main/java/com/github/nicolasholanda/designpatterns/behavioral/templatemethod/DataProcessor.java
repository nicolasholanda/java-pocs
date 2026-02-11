package com.github.nicolasholanda.designpatterns.behavioral.templatemethod;

abstract class DataProcessor {

    final void process() {
        readData();
        parseData();
        processData();
        writeData();
    }

    abstract void readData();
    abstract void parseData();
    abstract void writeData();

    void processData() {
        System.out.println("Processing data...");
    }
}
