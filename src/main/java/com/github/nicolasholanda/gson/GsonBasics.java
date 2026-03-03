package com.github.nicolasholanda.gson;

import com.google.gson.Gson;

public class GsonBasics {

    record Person(String name, int age, String email) {}

    static void execute() {
        Gson gson = new Gson();

        Person person = new Person("Alice", 30, "alice@example.com");
        String json = gson.toJson(person);
        System.out.println("Serialized: " + json);

        Person deserialized = gson.fromJson(json, Person.class);
        System.out.println("Deserialized: " + deserialized);

        System.out.println("Name: " + deserialized.name());
        System.out.println("Age: " + deserialized.age());

        String primitiveJson = gson.toJson(42);
        System.out.println("Primitive int: " + primitiveJson);

        String boolJson = gson.toJson(true);
        System.out.println("Primitive boolean: " + boolJson);

        int num = gson.fromJson("99", int.class);
        System.out.println("Parsed int: " + num);

        record WithNull(String name, String nickname) {}

        WithNull withNull = new WithNull("Bob", null);
        String nullJson = gson.toJson(withNull);
        System.out.println("Null field (omitted by default): " + nullJson);

        WithNull parsed = gson.fromJson("{\"name\":\"Bob\"}", WithNull.class);
        System.out.println("Missing field is null: " + parsed.nickname());
    }
}

