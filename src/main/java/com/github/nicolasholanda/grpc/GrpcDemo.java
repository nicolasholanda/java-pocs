package com.github.nicolasholanda.grpc;

import io.grpc.Server;

public class GrpcDemo {

    static void main() {
        try {
            Server server = GrpcServer.start(50051);

            System.out.println("\n--- gRPC client ---");
            GrpcClient.execute(50051);

            server.shutdown();
            server.awaitTermination();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
