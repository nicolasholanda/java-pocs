package com.github.nicolasholanda.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

class Order {

    String customer;
    List<String> items;
    
    Order(String customer, List<String> items) {
        this.customer = customer;
        this.items = items;
    }
}

public class StreamsAdvanced {
    static void execute() {
        List<Order> orders = List.of(
                new Order("Alice", List.of("Laptop", "Mouse")),
                new Order("Bob", List.of("Phone", "Case", "Charger")),
                new Order("Charlie", List.of("Monitor"))
        );

        System.out.println("flatMap:");
        orders.stream()
            .flatMap(order -> order.items.stream())
            .forEach(System.out::println);

        System.out.println("distinct:");
        List<Integer> numbers = Arrays.asList(1, 2, 2, 3, 3, 3, 4, 5, 5);
        numbers.stream()
            .distinct()
            .forEach(System.out::println);

        System.out.println("sorted:");
        Stream.of("banana", "apple", "cherry", "date")
            .sorted()
            .forEach(System.out::println);

        System.out.println("limit and skip:");
        Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
            .skip(3)
            .limit(4)
            .forEach(System.out::println);

        System.out.println("peek:");
        int sum = Stream.of(1, 2, 3, 4, 5)
            .peek(n -> System.out.println("Processing: " + n))
            .map(n -> n * 2)
            .peek(n -> System.out.println("After map: " + n))
            .reduce(0, Integer::sum);
        System.out.println("Sum: " + sum);
    }
}

