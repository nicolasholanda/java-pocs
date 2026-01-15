package com.github.nicolasholanda.functional;

@FunctionalInterface
interface Calculator {
    int calculate(int a, int b);
}

@FunctionalInterface
interface Validator<T> {
    boolean validate(T value);
}

@FunctionalInterface
interface Processor {
    void process(String data);
}

public class FunctionalCustom {
    static void execute() {
        Calculator add = (a, b) -> a + b;
        Calculator multiply = (a, b) -> a * b;
        System.out.println("Add: " + add.calculate(5, 3));
        System.out.println("Multiply: " + multiply.calculate(5, 3));

        Validator<String> notEmpty = s -> s != null && !s.isEmpty();
        Validator<Integer> positive = n -> n > 0;
        System.out.println("Valid string: " + notEmpty.validate("hello"));
        System.out.println("Valid number: " + positive.validate(10));

        Processor logger = data -> System.out.println("Processing: " + data);
        logger.process("important data");
    }
}

