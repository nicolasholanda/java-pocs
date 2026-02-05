package com.github.nicolasholanda.designpatterns.creational.builder;

class User {
    private final String name;
    private final String email;
    private final int age;
    private final String phone;

    private User(Builder builder) {
        this.name = builder.name;
        this.email = builder.email;
        this.age = builder.age;
        this.phone = builder.phone;
    }

    @Override
    public String toString() {
        return "User{name='%s', email='%s', age=%d, phone='%s'}".formatted(name, email, age, phone);
    }

    static class Builder {
        private String name;
        private String email;
        private int age;
        private String phone;

        Builder name(String name) {
            this.name = name;
            return this;
        }

        Builder email(String email) {
            this.email = email;
            return this;
        }

        Builder age(int age) {
            this.age = age;
            return this;
        }

        Builder phone(String phone) {
            this.phone = phone;
            return this;
        }

        User build() {
            return new User(this);
        }
    }
}
