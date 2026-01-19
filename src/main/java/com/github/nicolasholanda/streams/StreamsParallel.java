package com.github.nicolasholanda.streams;

import java.util.List;
import java.util.stream.IntStream;

public class StreamsParallel {
    static void execute() {
        List<Integer> numbers = IntStream.rangeClosed(1, 1000).boxed().toList();

        System.out.println("Sequential stream:");
        long start = System.currentTimeMillis();
        long sum = numbers.stream()
            .map(n -> n * n)
            .reduce(0, Integer::sum);
        long end = System.currentTimeMillis();
        System.out.println("Sum: " + sum + " (Time: " + (end - start) + "ms)");

        System.out.println("Parallel stream:");
        start = System.currentTimeMillis();
        sum = numbers.parallelStream()
            .map(n -> n * n)
            .reduce(0, Integer::sum);
        end = System.currentTimeMillis();
        System.out.println("Sum: " + sum + " (Time: " + (end - start) + "ms)");

        System.out.println("Thread usage in parallel:");
        List.of(1, 2, 3, 4, 5).parallelStream()
            .forEach(n -> System.out.println("Processing " + n + " on " + Thread.currentThread().getName()));
    }
}

