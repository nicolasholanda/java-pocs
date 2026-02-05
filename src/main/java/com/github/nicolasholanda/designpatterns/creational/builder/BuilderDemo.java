package com.github.nicolasholanda.designpatterns.creational.builder;

public class BuilderDemo {

    static void main() {
        var user1 = new User.Builder()
                .name("John")
                .email("john@example.com")
                .age(30)
                .phone("123-456-7890")
                .build();

        var user2 = new User.Builder()
                .name("Jane")
                .email("jane@example.com")
                .build();

        System.out.println(user1);
        System.out.println(user2);
    }
}

