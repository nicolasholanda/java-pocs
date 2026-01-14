package com.github.nicolasholanda.reflection;

public class ReflectionDemo {
    static void main() throws Exception {
        System.out.println("--- Read class metadata ---");
        ReflectionRead.execute();

        System.out.println("\n--- Invoke methods and constructors ---");
        ReflectionInvoke.execute();

        System.out.println("\n--- Modify field values ---");
        ReflectionModify.execute();

        System.out.println("\n--- Working with arrays ---");
        ReflectionArrays.execute();

        System.out.println("\n--- Working with generics ---");
        ReflectionGenerics.execute();
    }
}

