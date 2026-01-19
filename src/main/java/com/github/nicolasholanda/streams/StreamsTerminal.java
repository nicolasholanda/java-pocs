package com.github.nicolasholanda.streams;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

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


        System.out.println("findFirst:");
        Optional<Integer> first = numbers.stream().filter(n -> n > 5).findFirst();
        first.ifPresent(System.out::println);

        System.out.println("findAny:");
        Optional<Integer> any = numbers.parallelStream().filter(n -> n > 5).findAny();
        any.ifPresent(System.out::println);

        System.out.println("count:");
        long count = numbers.stream().filter(n -> n > 5).count();
        System.out.println(count);

        System.out.println("min:");
        Optional<Integer> min = numbers.stream().min(Comparator.naturalOrder());
        min.ifPresent(System.out::println);

        System.out.println("max:");
        Optional<Integer> max = numbers.stream().max(Comparator.naturalOrder());
        max.ifPresent(System.out::println);
    }
}

