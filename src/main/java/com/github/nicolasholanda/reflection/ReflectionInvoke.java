package com.github.nicolasholanda.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class ReflectionInvoke {
    public static void execute() throws Exception {
        Class<?> personClass = Person.class;

        System.out.println("Creating instance with no args constructor:");
        Constructor<?> noArgConstructor = personClass.getDeclaredConstructor();
        Person person1 = (Person) noArgConstructor.newInstance();

        System.out.println("Creating instance with parameterized constructor:");
        Constructor<?> paramConstructor = personClass.getDeclaredConstructor(String.class, int.class);
        Person person2 = (Person) paramConstructor.newInstance("Alice", 30);

        System.out.println("Invoking public methods:");
        Method setNameMethod = personClass.getDeclaredMethod("setName", String.class);
        setNameMethod.invoke(person1, "Bob");

        Method getNameMethod = personClass.getDeclaredMethod("getName");
        String name = (String) getNameMethod.invoke(person1);
        System.out.println("Name: " + name);

        Method greetMethod = personClass.getDeclaredMethod("greet", String.class);
        greetMethod.invoke(person2, "Hello World");

        System.out.println("Invoking private method:");
        Method privateMethod = personClass.getDeclaredMethod("privateMethod");
        privateMethod.setAccessible(true);
        privateMethod.invoke(person2);
    }
}

