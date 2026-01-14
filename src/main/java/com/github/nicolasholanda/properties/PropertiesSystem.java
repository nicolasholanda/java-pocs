package com.github.nicolasholanda.properties;

import java.util.Properties;

public class PropertiesSystem {
    public static void execute() {
        System.out.println("java.version: " + System.getProperty("java.version"));
        System.out.println("os.name: " + System.getProperty("os.name"));
        System.out.println("user.home: " + System.getProperty("user.home"));
        System.out.println("user.dir: " + System.getProperty("user.dir"));

        System.setProperty("custom.property", "custom-value");
        System.out.println("custom.property: " + System.getProperty("custom.property"));

        System.out.println("All system properties:");
        Properties systemProps = System.getProperties();
        systemProps.forEach((key, value) ->
            System.out.println(key + ": " + value)
        );
    }
}

