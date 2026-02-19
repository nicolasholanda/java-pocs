package com.github.nicolasholanda.java25;

import module java.base;
// No import statements needed

public class ModuleImports {

    public static void execute() {
        System.out.println("Module Import Declarations:");

        List<String> names = List.of("Alice", "Bob", "Charlie");
        System.out.println("Names: " + names);

        Optional<String> first = names.stream().findFirst();
        first.ifPresent(name -> System.out.println("First: " + name));

        Map<String, Integer> ages = Map.of(
                "Alice", 30,
                "Bob", 25,
                "Charlie", 35
        );
        System.out.println("Ages: " + ages);

        Set<Integer> uniqueAges = Set.copyOf(ages.values());
        System.out.println("Unique ages: " + uniqueAges);

        String text = "Hello World";
        String upper = text.toUpperCase();
        System.out.println("Upper: " + upper);

        BigDecimal amount = new BigDecimal("99.99");
        BigDecimal tax = amount.multiply(new BigDecimal("0.15"));
        System.out.println("Tax: " + tax);
    }
}
