package com.github.nicolasholanda.resilience4j;

import io.github.resilience4j.retry.Retry;
import io.github.resilience4j.retry.RetryConfig;
import io.github.resilience4j.retry.RetryRegistry;

import java.time.Duration;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Supplier;

public class Resilience4jRetry {

    static void execute() {
        RetryConfig config = RetryConfig.custom()
                .maxAttempts(4)
                .waitDuration(Duration.ofMillis(200))
                .retryExceptions(RuntimeException.class)
                .build();

        RetryRegistry registry = RetryRegistry.of(config);
        Retry retry = registry.retry("myRetry");

        retry.getEventPublisher()
                .onRetry(event -> System.out.println("Retry attempt #" + event.getNumberOfRetryAttempts()));

        AtomicInteger attempts = new AtomicInteger(0);
        Supplier<String> decorated = Retry.decorateSupplier(retry, () -> {
            int attempt = attempts.incrementAndGet();
            if (attempt < 3) {
                throw new RuntimeException("Failure on attempt " + attempt);
            }
            return "Success on attempt " + attempt;
        });

        try {
            String result = decorated.get();
            System.out.println("Result: " + result);
        } catch (Exception e) {
            System.out.println("All retries failed: " + e.getMessage());
        }

        System.out.println("Metrics - successful without retry: " + retry.getMetrics().getNumberOfSuccessfulCallsWithoutRetryAttempt()
                + ", successful with retry: " + retry.getMetrics().getNumberOfSuccessfulCallsWithRetryAttempt()
                + ", failed: " + retry.getMetrics().getNumberOfFailedCallsWithRetryAttempt());
    }
}
