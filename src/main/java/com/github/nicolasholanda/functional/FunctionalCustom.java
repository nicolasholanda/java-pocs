package com.github.nicolasholanda.functional;

@FunctionalInterface
interface Calculator {
    int calculate(int a, int b);
}


public class FunctionalCustom {
    static void execute() {
        Calculator add = (a, b) -> a + b;
        Calculator multiply = (a, b) -> a * b;
        System.out.println("Add: " + add.calculate(5, 3));
        System.out.println("Multiply: " + multiply.calculate(5, 3));
    }
}

