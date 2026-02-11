package com.github.nicolasholanda.designpatterns.behavioral.templatemethod;

public class TemplateMethodDemo {

    static void main() {
        DataProcessor csvProcessor = new CSVProcessor();
        csvProcessor.process();

        System.out.println();

        DataProcessor jsonProcessor = new JSONProcessor();
        jsonProcessor.process();
    }
}
