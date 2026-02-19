package com.github.nicolasholanda.java25;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ScopedValuesDemo {

    private static final ScopedValue<String> USER_ID = ScopedValue.newInstance();
    private static final ScopedValue<String> REQUEST_ID = ScopedValue.newInstance();

    public static void execute() {
        System.out.println("Scoped Values:");

        processRequest("user123", "req-001");
        processRequest("user456", "req-002");

        System.out.println("Parallel requests:");
        try (ExecutorService executor = Executors.newFixedThreadPool(2)) {
            executor.submit(() -> processRequest("user789", "req-003"));
            executor.submit(() -> processRequest("user999", "req-004"));
        }
    }

    static void processRequest(String userId, String requestId) {
        ScopedValue.where(USER_ID, userId)
                .where(REQUEST_ID, requestId)
                .run(() -> {
                    handleRequest();
                    performOperation();
                });
    }

    static void handleRequest() {
        System.out.println("Handling request - User: " + USER_ID.get() + ", Request: " + REQUEST_ID.get());
        validateUser();
    }

    static void validateUser() {
        String user = USER_ID.get();
        System.out.println("Validating user: " + user);
    }

    static void performOperation() {
        String reqId = REQUEST_ID.get();
        System.out.println("Performing operation for request: " + reqId);
        logActivity();
    }

    static void logActivity() {
        System.out.println("Log - User: " + USER_ID.get() + ", Request: " + REQUEST_ID.get());
    }
}
