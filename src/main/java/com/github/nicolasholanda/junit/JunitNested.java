package com.github.nicolasholanda.junit;

import org.junit.jupiter.api.*;

public class JunitNested {

    @BeforeEach
    void setUp() {
        System.out.println("Outer setUp");
    }

    @Test
    void testOuter() {
        System.out.println("Running outer test");
        Assertions.assertTrue(true);
    }

    @Nested
    @DisplayName("User operations")
    class UserTests {

        @BeforeEach
        void setUp() {
            System.out.println("User setUp");
        }

        @Test
        void testCreateUser() {
            System.out.println("Testing create user");
            Assertions.assertTrue(true);
        }

        @Test
        void testDeleteUser() {
            System.out.println("Testing delete user");
            Assertions.assertTrue(true);
        }

        @Nested
        @DisplayName("User validation")
        class ValidationTests {

            @Test
            void testValidEmail() {
                System.out.println("Testing valid email");
                Assertions.assertTrue(true);
            }

            @Test
            void testInvalidEmail() {
                System.out.println("Testing invalid email");
                Assertions.assertTrue(true);
            }
        }
    }

    @Nested
    @DisplayName("Product operations")
    class ProductTests {

        @Test
        void testCreateProduct() {
            System.out.println("Testing create product");
            Assertions.assertTrue(true);
        }

        @Test
        void testUpdateProduct() {
            System.out.println("Testing update product");
            Assertions.assertTrue(true);
        }
    }
}

