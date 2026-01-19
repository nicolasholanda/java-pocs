package com.github.nicolasholanda.streams;

public class StreamsDemo {

    static void main() {

        System.out.println("--- Stream basics ---");
        StreamsBasics.execute();

        System.out.println("--- Stream collectors ---");
        StreamsCollectors.execute();

        System.out.println("--- Advanced streams ---");
        StreamsAdvanced.execute();

        System.out.println("\n--- Parallel streams ---");
        StreamsParallel.execute();

        System.out.println("\n--- Stream creation ---");
        StreamsCreation.execute();

        System.out.println("\n--- Terminal operations ---");
        StreamsTerminal.execute();
    }
}
