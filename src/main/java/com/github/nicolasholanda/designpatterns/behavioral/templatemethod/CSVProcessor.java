package com.github.nicolasholanda.designpatterns.behavioral.templatemethod;

class CSVProcessor extends DataProcessor {

    @Override
    void readData() {
        System.out.println("Reading CSV file...");
    }

    @Override
    void parseData() {
        System.out.println("Parsing CSV format...");
    }

    @Override
    void writeData() {
        System.out.println("Writing CSV output...");
    }
}
