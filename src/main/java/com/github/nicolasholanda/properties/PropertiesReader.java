package com.github.nicolasholanda.properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {
    public static void execute() {
        Properties props = new Properties();

        try (FileInputStream fis = new FileInputStream("app.properties")) {
            props.load(fis);

            System.out.println("app.name: " + props.getProperty("app.name"));
            System.out.println("app.version: " + props.getProperty("app.version"));
            System.out.println("database.host: " + props.getProperty("database.host"));
            System.out.println("Non-existent key: " + props.getProperty("nonexistent"));
            System.out.println("With default: " + props.getProperty("nonexistent", "default-value"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

