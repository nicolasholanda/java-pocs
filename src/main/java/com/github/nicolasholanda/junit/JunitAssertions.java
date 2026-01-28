package com.github.nicolasholanda.junit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Calculator {
    int add(int a, int b) {
        return a + b;
    }

    int divide(int a, int b) {
        if (b == 0) throw new ArithmeticException("Division by zero");
        return a / b;
    }

    String getName() {
        return "Calculator";
    }
}

public class JunitAssertions {

    @Test
    void testAssertEquals() {
        Calculator calc = new Calculator();
        assertEquals(5, calc.add(2, 3));
        System.out.println("assertEquals passed");
    }

    @Test
    void testAssertTrue() {
        assertTrue(5 > 3);
        System.out.println("assertTrue passed");
    }

    @Test
    void testAssertFalse() {
        assertFalse(3 > 5);
        System.out.println("assertFalse passed");
    }

    @Test
    void testAssertNull() {
        String value = null;
        assertNull(value);
        System.out.println("assertNull passed");
    }

    @Test
    void testAssertNotNull() {
        Calculator calc = new Calculator();
        assertNotNull(calc);
        System.out.println("assertNotNull passed");
    }

    @Test
    void testAssertSame() {
        Calculator calc1 = new Calculator();
        Calculator calc2 = calc1;
        assertSame(calc1, calc2);
        System.out.println("assertSame passed");
    }

    @Test
    void testAssertNotSame() {
        Calculator calc1 = new Calculator();
        Calculator calc2 = new Calculator();
        assertNotSame(calc1, calc2);
        System.out.println("assertNotSame passed");
    }

    @Test
    void testAssertThrows() {
        Calculator calc = new Calculator();
        assertThrows(ArithmeticException.class, () -> calc.divide(10, 0));
        System.out.println("assertThrows passed");
    }

    @Test
    void testAssertAll() {
        Calculator calc = new Calculator();
        assertAll(
            () -> assertEquals(5, calc.add(2, 3)),
            () -> assertEquals("Calculator", calc.getName()),
            () -> assertNotNull(calc)
        );
        System.out.println("assertAll passed");
    }
}

