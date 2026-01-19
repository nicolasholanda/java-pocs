package com.github.nicolasholanda.streams;

public class StreamsDemo {

    static void main() {

        System.out.println("--- Stream basics ---");
        StreamsBasics.execute();

        System.out.println("--- Stream collectors ---");
        StreamsCollectors.execute();

        System.out.println("--- Advanced streams ---");
        StreamsAdvanced.execute();

        System.out.println("--- Parallel streams ---");
        StreamsParallel.execute();
    }
}
