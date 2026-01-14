package com.github.nicolasholanda.properties;

public class PropertiesDemo {
    static void main() {
        System.out.println("--- Create and write properties ---");
        PropertiesWriter.execute();

        System.out.println("--- Read Properties from file ---");
        PropertiesReader.execute();

        System.out.println("--- System Properties ---");
        PropertiesSystem.execute();
    }
}

