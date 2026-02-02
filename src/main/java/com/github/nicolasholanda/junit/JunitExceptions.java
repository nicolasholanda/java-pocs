package com.github.nicolasholanda.junit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class JunitExceptions {

    @Test
    void testExpectedException() {
        Exception exception = assertThrows(
            ArithmeticException.class,
            () -> divide(10, 0)
        );
        assertEquals("/ by zero", exception.getMessage());
    }

    @Test
    void testExceptionMessage() {
        assertThrows(
            IllegalArgumentException.class,
            () -> validateAge(-1),
            "Age cannot be negative"
        );
    }

    @Test
    void testNoException() {
        assertDoesNotThrow(() -> divide(10, 2));
    }

    private int divide(int a, int b) {
        return a / b;
    }

    private void validateAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative");
        }
    }
}

