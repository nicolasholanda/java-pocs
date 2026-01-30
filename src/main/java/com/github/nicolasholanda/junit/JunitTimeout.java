package com.github.nicolasholanda.junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;

public class JunitTimeout {

    @Test
    @Timeout(value = 2, unit = TimeUnit.SECONDS)
    void testWithTimeout() {
        System.out.println("Test completes within 2 seconds");
        Assertions.assertTrue(true);
    }

    @Test
    @Timeout(1)
    void testFastOperation() throws InterruptedException {
        System.out.println("Fast operation");
        Thread.sleep(500);
        Assertions.assertTrue(true);
    }

    @Test
    void testAssertTimeout() {
        assertTimeout(Duration.ofSeconds(2), () -> {
            System.out.println("Executing within timeout");
            Thread.sleep(1000);
        });
    }

    @Test
    void testAssertTimeoutWithResult() {
        String result = assertTimeout(Duration.ofSeconds(2), () -> {
            Thread.sleep(500);
            return "Completed";
        });
        System.out.println("Result: " + result);
        Assertions.assertEquals("Completed", result);
    }

    @Test
    void testAssertTimeoutPreemptively() {
        assertTimeoutPreemptively(Duration.ofSeconds(2), () -> {
            System.out.println("Preemptive timeout test");
            Thread.sleep(500);
        });
    }
}

