package com.github.nicolasholanda.junit;

import org.junit.jupiter.api.*;

public class JunitLifecycle {

    @BeforeAll
    static void beforeAll() {
        System.out.println("@BeforeAll runs one time before all tests");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("@AfterAll runs one timr after all tests");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("@BeforeEach runs before each test");
    }

    @AfterEach
    void afterEach() {
        System.out.println("@AfterEach  runs after each test");
    }

    @Test
    void testOne() {
        System.out.println("Running test 1");
        Assertions.assertTrue(true);
    }

    @Test
    void testTwo() {
        System.out.println("Running test 2");
        Assertions.assertTrue(true);
    }

    @Test
    void testThree() {
        System.out.println("Running test 3");
        Assertions.assertTrue(true);
    }
}

