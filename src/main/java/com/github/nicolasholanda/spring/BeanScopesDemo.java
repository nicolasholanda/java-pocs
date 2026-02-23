package com.github.nicolasholanda.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
class SingletonService {
    private int counter = 0;

    void increment() {
        counter++;
    }

    int getCounter() {
        return counter;
    }
}

@Component
@Scope("prototype")
class PrototypeService {
    private int counter = 0;

    void increment() {
        counter++;
    }

    int getCounter() {
        return counter;
    }
}

@Component
class RequestHandler {
    private final String id;

    RequestHandler() {
        this.id = "ID-" + System.currentTimeMillis();
    }

    String getId() {
        return id;
    }
}

@Component
@Scope("prototype")
class SessionHandler {
    private final String sessionId;

    SessionHandler() {
        this.sessionId = "SESSION-" + System.currentTimeMillis();
    }

    String getSessionId() {
        return sessionId;
    }
}

public class BeanScopesDemo {

    public static void execute() {
        System.out.println("Bean Scopes:");

        try (var context = new AnnotationConfigApplicationContext()) {
            context.scan("com.github.nicolasholanda.spring");
            context.refresh();

            System.out.println("Singleton scope:");
            SingletonService s1 = context.getBean(SingletonService.class);
            SingletonService s2 = context.getBean(SingletonService.class);
            System.out.println("Same instance? " + (s1 == s2));
            s1.increment();
            s1.increment();
            System.out.println("s1 counter: " + s1.getCounter());
            System.out.println("s2 counter: " + s2.getCounter());

            System.out.println("Prototype scope:");
            PrototypeService p1 = context.getBean(PrototypeService.class);
            PrototypeService p2 = context.getBean(PrototypeService.class);
            System.out.println("Same instance? " + (p1 == p2));
            p1.increment();
            p1.increment();
            System.out.println("p1 counter: " + p1.getCounter());
            System.out.println("p2 counter: " + p2.getCounter());

            System.out.println("Request handlers:");
            RequestHandler r1 = context.getBean(RequestHandler.class);
            RequestHandler r2 = context.getBean(RequestHandler.class);
            System.out.println("r1 ID: " + r1.getId());
            System.out.println("r2 ID: " + r2.getId());
            System.out.println("Same ID? " + r1.getId().equals(r2.getId()));

            System.out.println("Session handlers:");
            SessionHandler sh1 = context.getBean(SessionHandler.class);
            SessionHandler sh2 = context.getBean(SessionHandler.class);
            System.out.println("sh1 ID: " + sh1.getSessionId());
            System.out.println("sh2 ID: " + sh2.getSessionId());
            System.out.println("Same ID? " + sh1.getSessionId().equals(sh2.getSessionId()));
        }
    }
}
