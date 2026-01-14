package com.github.nicolasholanda.reflection;

public class Person {
    private String name;
    private int age;
    public String email;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private void privateMethod() {
        System.out.println("This is a private method");
    }

    public void greet(String message) {
        System.out.println(name + " says: " + message);
    }
}


