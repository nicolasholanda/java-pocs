package com.github.nicolasholanda.designpatterns.behavioral.templatemethod;

class JSONProcessor extends DataProcessor {

    @Override
    void readData() {
        System.out.println("Reading JSON file...");
    }

    @Override
    void parseData() {
        System.out.println("Parsing JSON format...");
    }

    @Override
    void writeData() {
        System.out.println("Writing JSON output...");
    }

    @Override
    void processData() {
        System.out.println("Processing JSON with validation...");
    }
}
