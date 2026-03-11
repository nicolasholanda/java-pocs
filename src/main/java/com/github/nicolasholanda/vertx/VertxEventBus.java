package com.github.nicolasholanda.vertx;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Vertx;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

class VertxEventBus {

    static class ReceiverVerticle extends AbstractVerticle {
        @Override
        public void start() {
            vertx.eventBus().consumer("chat.message", message -> {
                System.out.println("Receiver got: " + message.body());
                message.reply("ACK: " + message.body());
            });

            vertx.eventBus().consumer("news.broadcast", message ->
                    System.out.println("News subscriber got: " + message.body()));
        }
    }

    static class SenderVerticle extends AbstractVerticle {
        @Override
        public void start() {
            vertx.eventBus().request("chat.message", "Hello via point-to-point")
                    .onSuccess(reply -> System.out.println("Sender got reply: " + reply.body()));

            vertx.eventBus().publish("news.broadcast", "Breaking news via publish!");
        }
    }

    static void execute() {
        try {
            Vertx vertx = Vertx.vertx();
            CountDownLatch receiverReady = new CountDownLatch(1);

            vertx.deployVerticle(new ReceiverVerticle()).onComplete(r -> receiverReady.countDown());
            receiverReady.await(5, TimeUnit.SECONDS);

            CountDownLatch senderDone = new CountDownLatch(1);
            vertx.deployVerticle(new SenderVerticle()).onComplete(r -> senderDone.countDown());
            senderDone.await(5, TimeUnit.SECONDS);

            Thread.sleep(1000);

            CountDownLatch closeLatch = new CountDownLatch(1);
            vertx.close().onComplete(r -> closeLatch.countDown());
            closeLatch.await(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
