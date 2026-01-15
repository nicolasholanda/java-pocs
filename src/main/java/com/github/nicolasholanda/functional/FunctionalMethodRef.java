package com.github.nicolasholanda.functional;

import java.util.List;
import java.util.function.Function;

class Person {

    String name;

    Person(String name) {
        this.name = name;
    }

    static boolean isLongName(String name) { return name.length() > 5; }

    String toUpperCase() { return name.toUpperCase(); }
}

public class FunctionalMethodRef {
    static void execute() {
        List<String> names = List.of("Alice", "Bob", "Charlie");

        System.out.println("Static method reference:");
        names.stream().filter(Person::isLongName).forEach(System.out::println);

        System.out.println("Instance method reference:");
        Person person = new Person("john");
        Function<Person, String> upperFunc = Person::toUpperCase;
        System.out.println(upperFunc.apply(person));

        System.out.println("Constructor reference:");
        Function<String, Person> personFactory = Person::new;
        System.out.println(personFactory.apply("factory").name);
    }
}

