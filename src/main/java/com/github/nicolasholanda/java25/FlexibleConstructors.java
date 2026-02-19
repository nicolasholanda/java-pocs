package com.github.nicolasholanda.java25;

class Person {
    private final String name;
    private final int age;

    Person(String name, int age) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        if (age < 0 || age > 150) {
            throw new IllegalArgumentException("Invalid age");
        }
        this.name = name;
        this.age = age;
    }

    public String toString() {
        return name + " (" + age + ")";
    }
}

class Employee extends Person {
    private final String employeeId;

    Employee(String name, int age, String employeeId) {
        if (employeeId == null || employeeId.length() < 5) {
            throw new IllegalArgumentException("Invalid employee ID");
        }
        String formattedName = name.trim().toUpperCase();
        super(formattedName, age);
        this.employeeId = employeeId;
    }

    public String toString() {
        return super.toString() + " - ID: " + employeeId;
    }
}

class Manager extends Employee {
    private final int teamSize;

    Manager(String name, int age, String employeeId, int teamSize) {
        int minAge = 25;
        if (age < minAge) {
            throw new IllegalArgumentException("Manager must be at least " + minAge);
        }
        super(name, age, employeeId);
        if (teamSize < 1) {
            throw new IllegalArgumentException("Team size must be positive");
        }
        this.teamSize = teamSize;
    }

    public String toString() {
        return super.toString() + " - Team: " + teamSize;
    }
}

public class FlexibleConstructors {

    public static void execute() {
        System.out.println("Flexible Constructor Bodies:");

        Person person = new Person("Alice", 30);
        System.out.println(person);

        Employee employee = new Employee("  bob  ", 28, "EMP12345");
        System.out.println(employee);

        Manager manager = new Manager("Carol", 35, "MGR98765", 10);
        System.out.println(manager);

        try {
            new Person("", 25);
        } catch (IllegalArgumentException e) {
            System.out.println("Caught: " + e.getMessage());
        }

        try {
            new Employee("Dave", 30, "E123");
        } catch (IllegalArgumentException e) {
            System.out.println("Caught: " + e.getMessage());
        }

        try {
            new Manager("Eve", 22, "MGR11111", 5);
        } catch (IllegalArgumentException e) {
            System.out.println("Caught: " + e.getMessage());
        }
    }
}
