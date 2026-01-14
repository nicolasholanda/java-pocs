package com.github.nicolasholanda.reflection;

import java.lang.reflect.Array;

public class ReflectionArrays {
    public static void execute() throws Exception {
        System.out.println("Creating String array:");

        Object stringArray = Array.newInstance(String.class, 3);

        Array.set(stringArray, 0, "First");
        Array.set(stringArray, 1, "Second");
        Array.set(stringArray, 2, "Third");
        
        System.out.println("Length: " + Array.getLength(stringArray));
        for (int i = 0; i < Array.getLength(stringArray); i++) {
            System.out.println("Element " + i + ": " + Array.get(stringArray, i));
        }


        System.out.println("Creating int array:");
        Object intArray = Array.newInstance(int.class, 5);
        for (int i = 0; i < Array.getLength(intArray); i++) {
            Array.setInt(intArray, i, i * 10);
        }
        
        for (int i = 0; i < Array.getLength(intArray); i++) {
            System.out.println("Element " + i + ": " + Array.getInt(intArray, i));
        }
    }
}

