package com.github.nicolasholanda.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
class MessageService {
    String getMessage() {
        return "Hello from Spring IoC!";
    }
}

@Component
class UserService {
    String getUser() {
        return "User: John Doe";
    }
}

@Configuration
class AppConfig {
    @Bean
    EmailService emailService() {
        return new EmailService("smtp.example.com");
    }
}

class EmailService {
    private final String server;

    EmailService(String server) {
        this.server = server;
    }

    String send(String message) {
        return "Sending '" + message + "' via " + server;
    }
}

public class IoCDemo {

    public static void execute() {
        System.out.println("Spring IoC Container:");

        try (var context = new AnnotationConfigApplicationContext()) {
            context.scan("com.github.nicolasholanda.spring");
            context.refresh();

            MessageService messageService = context.getBean(MessageService.class);
            System.out.println(messageService.getMessage());

            UserService userService = context.getBean(UserService.class);
            System.out.println(userService.getUser());

            EmailService emailService = context.getBean(EmailService.class);
            System.out.println(emailService.send("Test email"));

            System.out.println("Bean count: " + context.getBeanDefinitionCount());
            System.out.println("Container ID: " + context.getId());
        }
    }
}
