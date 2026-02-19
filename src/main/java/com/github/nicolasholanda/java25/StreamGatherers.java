package com.github.nicolasholanda.java25;

import java.util.List;
import java.util.stream.Gatherers;
import java.util.stream.Stream;

public class StreamGatherers {

    public static void execute() {
        System.out.println("Stream Gatherers:");

        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        System.out.println("Fixed window (size 3):");
        numbers.stream()
                .gather(Gatherers.windowFixed(3))
                .forEach(System.out::println);

        System.out.println("Sliding window (size 3):");
        numbers.stream()
                .gather(Gatherers.windowSliding(3))
                .forEach(System.out::println);

        System.out.println("Fold operation (sum):");
        Integer sum = numbers.stream()
                .gather(Gatherers.fold(() -> 0, Integer::sum))
                .findFirst()
                .orElse(0);
        System.out.println("Sum: " + sum);

        System.out.println("Map concurrent:");
        Stream.of("apple", "banana", "cherry")
                .gather(Gatherers.mapConcurrent(3, String::toUpperCase))
                .forEach(System.out::println);

        System.out.println("Scan (running sum):");
        numbers.stream()
                .gather(Gatherers.scan(() -> 0, Integer::sum))
                .forEach(n -> System.out.print(n + " "));
        System.out.println();
    }
}
