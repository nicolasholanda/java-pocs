package com.github.nicolasholanda.grpc;

import com.github.nicolasholanda.grpc.generated.GreeterServiceGrpc;
import com.github.nicolasholanda.grpc.generated.HelloRequest;
import com.github.nicolasholanda.grpc.generated.HelloResponse;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.concurrent.TimeUnit;

public class GrpcClient {

    static void execute(int port) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", port)
                .usePlaintext()
                .build();

        try {
            GreeterServiceGrpc.GreeterServiceBlockingStub stub = GreeterServiceGrpc.newBlockingStub(channel);

            HelloRequest request = HelloRequest.newBuilder()
                    .setName("World")
                    .build();

            HelloResponse response = stub.sayHello(request);
            System.out.println("sayHello response: " + response.getMessage());

            HelloResponse response2 = stub.sayHelloAgain(request);
            System.out.println("sayHelloAgain response: " + response2.getMessage());
        } finally {
            try {
                channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
