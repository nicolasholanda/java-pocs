package com.github.nicolasholanda.camel;

public class CamelDemo {

    static void main() {
        System.out.println("--- Camel basics ---");
        CamelBasics.execute();

        System.out.println("\n--- Camel file route ---");
        CamelFileRoute.execute();

        System.out.println("\n--- Camel transform ---");
        CamelTransform.execute();

        System.out.println("\n--- Camel filter ---");
        CamelFilter.execute();

        System.out.println("\n--- Camel split aggregate ---");
        CamelSplitAggregate.execute();
    }
}
