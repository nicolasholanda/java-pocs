package com.github.nicolasholanda.functional;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionalBasics {
    public static void execute() {
        System.out.println("- Predicate test one condition:");
        Predicate<Integer> isEven = n -> n % 2 == 0;
        System.out.println("Is 4 even? " + isEven.test(4));
        System.out.println("Is 7 even? " + isEven.test(7));


        System.out.println("- Function transform input to output:");
        Function<String, Integer> stringLength = s -> s.length();
        System.out.println("Length of 'Hello': " + stringLength.apply("Hello"));



        System.out.println("- Consumer consume input without return:");
        Consumer<String> printer = s -> System.out.println("Message: " + s);
        printer.accept("Hello World");



        System.out.println("- Supplier supply a value:");
        Supplier<Double> randomSupplier = () -> Math.random();
        System.out.println("Random value: " + randomSupplier.get());



        System.out.println("- Method references:");
        Function<String, Integer> lengthRef = String::length;
        System.out.println("Length of word Java: " + lengthRef.apply("Java"));


        Consumer<String> printlnRef = System.out::println;
        printlnRef.accept("Using method reference");


        Supplier<String> newString = String::new;
        System.out.println("New string: '" + newString.get() + "'");
    }
}

