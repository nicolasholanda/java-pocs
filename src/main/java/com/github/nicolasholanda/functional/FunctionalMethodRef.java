package com.github.nicolasholanda.functional;

import java.util.List;

class Person {

    String name;

    static boolean isLongName(String name) { return name.length() > 5; }
}

public class FunctionalMethodRef {
    static void execute() {
        List<String> names = List.of("Alice", "Bob", "Charlie");

        System.out.println("Static method reference:");
        names.stream().filter(Person::isLongName).forEach(System.out::println);
    }
}

