package com.github.nicolasholanda.reflection;

import java.lang.reflect.Field;

public class ReflectionModify {
    public static void execute() throws Exception {
        Person person = new Person("John", 25);

        System.out.println("Original values:");
        System.out.println("Name: " + person.getName());
        System.out.println("Age: " + person.getAge());

        System.out.println("Modifying private field name:");
        Field nameField = Person.class.getDeclaredField("name");
        nameField.setAccessible(true);
        nameField.set(person, "Jane");
        System.out.println("Name after modification: " + person.getName());

        System.out.println("Modifying private field age:");
        Field ageField = Person.class.getDeclaredField("age");
        ageField.setAccessible(true);
        ageField.set(person, 35);
        System.out.println("Age after modification: " + person.getAge());

        System.out.println("Modifying public field email:");
        Field emailField = Person.class.getDeclaredField("email");
        emailField.set(person, "jane@example.com");
        System.out.println("Email: " + person.email);

        System.out.println("Reading field value directly:");
        String nameValue = (String) nameField.get(person);
        int ageValue = (int) ageField.get(person);
        System.out.println("Name via reflection: " + nameValue);
        System.out.println("Age via reflection: " + ageValue);
    }
}

