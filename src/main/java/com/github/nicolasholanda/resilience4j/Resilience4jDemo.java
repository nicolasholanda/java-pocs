package com.github.nicolasholanda.resilience4j;

public class Resilience4jDemo {

    static void main() {
        System.out.println("--- Resilience4j circuit breaker ---");
        Resilience4jCircuitBreaker.execute();

        System.out.println("\n--- Resilience4j retry ---");
        Resilience4jRetry.execute();
    }
}
