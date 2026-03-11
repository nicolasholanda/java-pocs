package com.github.nicolasholanda.vertx;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Vertx;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.http.HttpClient;
import io.vertx.core.http.HttpClientRequest;
import io.vertx.core.http.HttpMethod;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

class VertxHttpServer {

    static class ServerVerticle extends AbstractVerticle {
        @Override
        public void start() {
            vertx.createHttpServer()
                    .requestHandler(req -> {
                        String path = req.path();
                        switch (path) {
                            case "/hello" -> req.response()
                                    .putHeader("Content-Type", "text/plain")
                                    .end("Hello from Vert.x!");
                            case "/json" -> req.response()
                                    .putHeader("Content-Type", "application/json")
                                    .end("{\"message\": \"Hello from Vert.x!\"}");
                            default -> req.response()
                                    .setStatusCode(404)
                                    .end("Not Found");
                        }
                    })
                    .listen(8888)
                    .onSuccess(server -> System.out.println("HTTP server started on port " + server.actualPort()));
        }
    }

    static void execute() {
        try {
            Vertx vertx = Vertx.vertx();
            CountDownLatch serverReady = new CountDownLatch(1);

            vertx.deployVerticle(new ServerVerticle()).onComplete(r -> serverReady.countDown());
            serverReady.await(5, TimeUnit.SECONDS);

            HttpClient client = vertx.createHttpClient();
            CountDownLatch requestsDone = new CountDownLatch(2);

            client.request(HttpMethod.GET, 8888, "localhost", "/hello")
                    .compose(HttpClientRequest::send)
                    .compose(resp -> {
                        System.out.println("GET /hello -> Status: " + resp.statusCode());
                        return resp.body();
                    })
                    .onSuccess(body -> {
                        System.out.println("Response body: " + body.toString());
                        requestsDone.countDown();
                    });

            client.request(HttpMethod.GET, 8888, "localhost", "/json")
                    .compose(HttpClientRequest::send)
                    .compose(resp -> {
                        System.out.println("GET /json -> Status: " + resp.statusCode());
                        return resp.body();
                    })
                    .onSuccess(body -> {
                        System.out.println("Response body: " + body.toString());
                        requestsDone.countDown();
                    });

            requestsDone.await(5, TimeUnit.SECONDS);

            CountDownLatch closeLatch = new CountDownLatch(1);
            vertx.close().onComplete(r -> closeLatch.countDown());
            closeLatch.await(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
