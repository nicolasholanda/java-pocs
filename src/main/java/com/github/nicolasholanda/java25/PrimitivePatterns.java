package com.github.nicolasholanda.java25;

public class PrimitivePatterns {

    public static void execute() {
        System.out.println("Primitive type patterns in switch:");

        int value = 42;
        String result = switch (value) {
            case 0 -> "Zero";
            case int i when i > 0 && i < 10 -> "Small positive: " + i;
            case int i when i >= 10 && i < 100 -> "Medium number: " + i;
            case int i when i >= 100 -> "Large number: " + i;
            case int i -> "Negative: " + i;
        };
        System.out.println(result);

        processNumber(-5);
        processNumber(3);
        processNumber(150);

        System.out.println("Long patterns with guards:");
        long amount = 1_000_000L;
        String category = switch (amount) {
            case long l when l < 1000 -> "Small";
            case long l when l < 1_000_000 -> "Medium";
            case long l -> "Large";
        };
        System.out.println("Amount " + amount + " is: " + category);

        byte status = 2;
        String statusName = switch (status) {
            case 0 -> "PENDING";
            case 1 -> "PROCESSING";
            case 2 -> "COMPLETED";
            case byte b -> "UNKNOWN: " + b;
        };
        System.out.println("Status: " + statusName);
    }

    static void processNumber(int num) {
        String description = switch (num) {
            case int i when i < 0 -> "negative";
            case 0 -> "zero";
            case int i when i % 2 == 0 -> "even positive";
            case int i -> "odd positive";
        };
        System.out.println(num + " is " + description);
    }
}
