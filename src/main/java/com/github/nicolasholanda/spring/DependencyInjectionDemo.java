package com.github.nicolasholanda.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
class DatabaseService {
    String connect() {
        return "Connected to database";
    }
}

@Component
class LoggerService {
    void log(String message) {
        System.out.println("LOG: " + message);
    }
}

@Component
class ConstructorInjectionService {
    private final DatabaseService database;
    private final LoggerService logger;

    ConstructorInjectionService(DatabaseService database, LoggerService logger) {
        this.database = database;
        this.logger = logger;
        logger.log("ConstructorInjectionService created");
    }

    void execute() {
        logger.log(database.connect());
    }
}

@Component
class SetterInjectionService {
    private DatabaseService database;
    private LoggerService logger;

    @Autowired
    void setDatabase(DatabaseService database) {
        this.database = database;
    }

    @Autowired
    void setLogger(LoggerService logger) {
        this.logger = logger;
        logger.log("SetterInjectionService dependencies set");
    }

    void execute() {
        logger.log(database.connect());
    }
}

@Component
class MixedInjectionService {
    private final DatabaseService database;
    private LoggerService logger;

    MixedInjectionService(DatabaseService database) {
        this.database = database;
    }

    @Autowired
    void setLogger(LoggerService logger) {
        this.logger = logger;
    }

    void execute() {
        logger.log(database.connect());
    }
}

public class DependencyInjectionDemo {

    public static void execute() {
        System.out.println("Dependency Injection:");

        try (var context = new AnnotationConfigApplicationContext()) {
            context.scan("com.github.nicolasholanda.spring");
            context.refresh();

            System.out.println("Constructor injection:");
            ConstructorInjectionService constructorService = context.getBean(ConstructorInjectionService.class);
            constructorService.execute();

            System.out.println("Setter injection:");
            SetterInjectionService setterService = context.getBean(SetterInjectionService.class);
            setterService.execute();

            System.out.println("Mixed injection:");
            MixedInjectionService mixedService = context.getBean(MixedInjectionService.class);
            mixedService.execute();
        }
    }
}
