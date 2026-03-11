package com.github.nicolasholanda.vertx;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Vertx;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

class VertxBasics {

    static class HelloVerticle extends AbstractVerticle {
        @Override
        public void start() {
            System.out.println("HelloVerticle started on thread: " + Thread.currentThread().getName());
            vertx.setPeriodic(1000, id -> System.out.println("Tick from HelloVerticle"));
        }
    }

    static void execute() {
        try {
            Vertx vertx = Vertx.vertx();
            CountDownLatch deployLatch = new CountDownLatch(1);

            vertx.deployVerticle(new HelloVerticle()).onComplete(result -> {
                if (result.succeeded()) {
                    System.out.println("Verticle deployed with ID: " + result.result());
                } else {
                    System.out.println("Deploy failed: " + result.cause().getMessage());
                }
                deployLatch.countDown();
            });

            deployLatch.await(5, TimeUnit.SECONDS);
            Thread.sleep(3000);

            CountDownLatch closeLatch = new CountDownLatch(1);
            vertx.close().onComplete(r -> closeLatch.countDown());
            closeLatch.await(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
