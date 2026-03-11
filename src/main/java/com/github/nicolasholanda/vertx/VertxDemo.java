package com.github.nicolasholanda.vertx;

public class VertxDemo {

    static void main() {
        System.out.println("--- Vert.x basics ---");
        VertxBasics.execute();

        System.out.println("\n--- Vert.x HTTP server ---");
        VertxHttpServer.execute();

        System.out.println("\n--- Vert.x event bus ---");
        VertxEventBus.execute();
    }
}
