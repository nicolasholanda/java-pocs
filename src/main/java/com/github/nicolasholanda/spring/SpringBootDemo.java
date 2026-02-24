package com.github.nicolasholanda.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

@Component
class GreetingService {
    String greet(String name) {
        return "Hello, " + name + "!";
    }
}

@Component
class StartupService {
    private final GreetingService greetingService;

    StartupService(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    void run() {
        System.out.println(greetingService.greet("Spring Boot"));
        System.out.println("Application started successfully");
    }
}

@SpringBootApplication
public class SpringBootDemo {

    public static void execute() {
        System.out.println("Spring Boot Application:");

        SpringApplication app = new SpringApplication(SpringBootDemo.class);
        app.setLogStartupInfo(false);
        ConfigurableApplicationContext context = app.run();

        StartupService startupService = context.getBean(StartupService.class);
        startupService.run();

        System.out.println("Beans count: " + context.getBeanDefinitionCount());
        System.out.println("Active profiles: " + String.join(", ", context.getEnvironment().getActiveProfiles()));

        context.close();
    }
}
