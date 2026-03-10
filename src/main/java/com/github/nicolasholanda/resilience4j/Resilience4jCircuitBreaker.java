package com.github.nicolasholanda.resilience4j;

import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;

import java.time.Duration;
import java.util.function.Supplier;

public class Resilience4jCircuitBreaker {

    private static int callCount = 0;

    private static String unreliableService() {
        callCount++;
        if (callCount % 3 != 0) {
            throw new RuntimeException("Service failure #" + callCount);
        }
        return "Success on call #" + callCount;
    }

    static void execute() {
        CircuitBreakerConfig config = CircuitBreakerConfig.custom()
                .failureRateThreshold(50)
                .waitDurationInOpenState(Duration.ofMillis(500))
                .slidingWindowSize(4)
                .minimumNumberOfCalls(2)
                .build();

        CircuitBreakerRegistry registry = CircuitBreakerRegistry.of(config);
        CircuitBreaker circuitBreaker = registry.circuitBreaker("myService");

        circuitBreaker.getEventPublisher()
                .onStateTransition(event -> System.out.println("State transition: " + event));

        Supplier<String> decorated = CircuitBreaker.decorateSupplier(circuitBreaker, Resilience4jCircuitBreaker::unreliableService);

        for (int i = 0; i < 8; i++) {
            try {
                String result = decorated.get();
                System.out.println("Result: " + result);
            } catch (Exception e) {
                System.out.println("Call failed: " + e.getMessage());
            }
        }

        System.out.println("Final state: " + circuitBreaker.getState());
        System.out.println("Metrics - failed: " + circuitBreaker.getMetrics().getNumberOfFailedCalls()
                + ", successful: " + circuitBreaker.getMetrics().getNumberOfSuccessfulCalls());
    }
}
