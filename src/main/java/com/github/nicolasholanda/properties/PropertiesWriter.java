package com.github.nicolasholanda.properties;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesWriter {
    public static void execute() {
        Properties props = new Properties();

        props.setProperty("app.name", "My application");
        props.setProperty("app.version", "1.0.0");
        props.setProperty("app.author", "John Doe");
        props.setProperty("database.host", "localhost");
        props.setProperty("database.port", "8080");

        try (FileOutputStream fos = new FileOutputStream("app.properties")) {
            props.store(fos, "Application Configuration");
            System.out.println("Properties written successfully");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

