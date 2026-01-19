package com.github.nicolasholanda.streams;

import java.util.List;

public class StreamsTerminal {
    static void execute() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        System.out.println("anyMatch (any even):");
        boolean hasEven = numbers.stream().anyMatch(n -> n % 2 == 0);
        System.out.println(hasEven);

        System.out.println("allMatch (all positive):");
        boolean allPositive = numbers.stream().allMatch(n -> n > 0);
        System.out.println(allPositive);

        System.out.println("noneMatch (none negative):");
        boolean noneNegative = numbers.stream().noneMatch(n -> n < 0);
        System.out.println(noneNegative);
    }
}

