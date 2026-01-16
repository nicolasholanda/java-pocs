package com.github.nicolasholanda.streams;

import java.util.List;

public class StreamsBasics {
    static void execute() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        System.out.println("Filter evens:");
        numbers.stream()
            .filter(n -> n % 2 == 0)
            .forEach(System.out::println);
    }
}

