package com.github.nicolasholanda.java25;

import java.util.concurrent.StructuredTaskScope;

public class StructuredConcurrencyDemo {

    public static void execute() {
        System.out.println("Structured Concurrency:");

        try {
            String result = fetchUserData("user123");
            System.out.println("Result: " + result);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            processOrderRace();
        } catch (Exception e) {
            System.out.println("Order processing failed: " + e.getMessage());
        }
    }

    static String fetchUserData(String userId) throws Exception {
        try (var scope = StructuredTaskScope.open()) {
            var userTask = scope.fork(() -> fetchUser(userId));
            var profileTask = scope.fork(() -> fetchProfile(userId));
            var prefsTask = scope.fork(() -> fetchPreferences(userId));

            scope.join();

            return "User: " + userTask.get() +
                   ", Profile: " + profileTask.get() +
                   ", Prefs: " + prefsTask.get();
        }
    }

    static void processOrderRace() throws Exception {
        try (var scope = StructuredTaskScope.open()) {
            var paymentTask = scope.fork(StructuredConcurrencyDemo::processPayment);
            var inventoryTask = scope.fork(StructuredConcurrencyDemo::verifyInventory);

            scope.join();

            System.out.println("Payment: " + paymentTask.get());
            System.out.println("Inventory: " + inventoryTask.get());
        }
    }

    static String fetchUser(String userId) throws InterruptedException {
        Thread.sleep(100);
        return "UserData[" + userId + "]";
    }

    static String fetchProfile(String userId) throws InterruptedException {
        Thread.sleep(150);
        return "Profile[" + userId + "]";
    }

    static String fetchPreferences(String userId) throws InterruptedException {
        Thread.sleep(120);
        return "Preferences[" + userId + "]";
    }

    static String processPayment() throws InterruptedException {
        Thread.sleep(200);
        return "Payment processed";
    }

    static String verifyInventory() throws InterruptedException {
        Thread.sleep(100);
        return "Inventory verified";
    }
}
