package com.github.nicolasholanda.spring;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Configuration
@PropertySource("classpath:application.properties")
class PropertyConfig {
}

@Component
class ApplicationConfig {
    @Value("${app.name}")
    private String appName;

    @Value("${app.version}")
    private String appVersion;

    @Value("${app.environment}")
    private String environment;

    void display() {
        System.out.println("App: " + appName);
        System.out.println("Version: " + appVersion);
        System.out.println("Environment: " + environment);
    }
}

@Component
class ServerConfig {
    @Value("${server.port}")
    private int port;

    @Value("${server.host}")
    private String host;

    void display() {
        System.out.println("Server: " + host + ":" + port);
    }
}

@Component
class DatabaseConfig {
    @Value("${database.url}")
    private String url;

    @Value("${database.username}")
    private String username;

    @Value("${database.password}")
    private String password;

    void display() {
        System.out.println("DB URL: " + url);
        System.out.println("DB User: " + username);
        System.out.println("DB Pass: " + "*".repeat(password.length()));
    }
}

@Component
class FeatureConfig {
    @Value("${feature.enabled}")
    private boolean enabled;

    @Value("${max.connections}")
    private int maxConnections;

    @Value("${timeout.seconds}")
    private int timeoutSeconds;

    @Value("${missing.property:default-value}")
    private String defaultValue;

    void display() {
        System.out.println("Feature enabled: " + enabled);
        System.out.println("Max connections: " + maxConnections);
        System.out.println("Timeout: " + timeoutSeconds + "s");
        System.out.println("Default value: " + defaultValue);
    }
}

public class ValueAnnotationDemo {

    public static void execute() {
        System.out.println("@Value Annotation:");

        try (var context = new AnnotationConfigApplicationContext()) {
            context.scan("com.github.nicolasholanda.spring");
            context.refresh();

            ApplicationConfig appConfig = context.getBean(ApplicationConfig.class);
            appConfig.display();

            System.out.println();
            ServerConfig serverConfig = context.getBean(ServerConfig.class);
            serverConfig.display();

            System.out.println();
            DatabaseConfig dbConfig = context.getBean(DatabaseConfig.class);
            dbConfig.display();

            System.out.println();
            FeatureConfig featureConfig = context.getBean(FeatureConfig.class);
            featureConfig.display();
        }
    }
}
