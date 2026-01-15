package com.github.nicolasholanda.functional;

public class FunctionalDemo {
    static void main() {
        System.out.println("--- Built-in functional interfaces ---");
        FunctionalBasics.execute();

        System.out.println("\n--- Custom functional interfaces ---");
        FunctionalCustom.execute();
    }
}
