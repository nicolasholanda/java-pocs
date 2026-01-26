package com.github.nicolasholanda.mockito;

public class MockitoDemo {

    static void main() {

        System.out.println("--- Mockito basics ---");
        MockitoBasics.execute();

        System.out.println("--- Argument matchers ---");
        MockitoArguments.execute();

        System.out.println("--- Verify ---");
        MockitoVerify.execute();
    }
}

