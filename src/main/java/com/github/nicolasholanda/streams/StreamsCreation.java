package com.github.nicolasholanda.streams;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamsCreation {
    static void execute() {
        System.out.println("Stream.of():");
        Stream.of("apple", "banana", "cherry")
            .forEach(System.out::println);
        
        

        System.out.println("Stream.iterate():");
        Stream.iterate(0, n -> n + 2)
            .limit(5)
            .forEach(System.out::println);
        
        

        System.out.println("Stream.generate():");
        Stream.generate(() -> "Hello")
            .limit(3)
            .forEach(System.out::println);
    }
}

