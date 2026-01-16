package com.github.nicolasholanda.streams;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

class Product {
    String name;
    String category;
    double price;

    Product(String name, String category, double price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }
}

public class StreamsCollectors {
    static void execute() {
        List<Product> products = List.of(
            new Product("Laptop", "Electronics", 999.99),
            new Product("Phone", "Electronics", 699.99),
            new Product("Desk", "Furniture", 299.99),
            new Product("Chair", "Furniture", 149.99),
            new Product("Monitor", "Electronics", 399.99)
        );

        System.out.println("toList and toSet:");
        Set<String> categories = products.stream()
            .map(p -> p.category)
            .collect(Collectors.toSet());
        System.out.println(categories);
    }
}

