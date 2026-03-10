package com.github.nicolasholanda.grpc;

import com.github.nicolasholanda.grpc.generated.GreeterServiceGrpc;
import com.github.nicolasholanda.grpc.generated.HelloRequest;
import com.github.nicolasholanda.grpc.generated.HelloResponse;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class GrpcServer {

    static class GreeterServiceImpl extends GreeterServiceGrpc.GreeterServiceImplBase {
        @Override
        public void sayHello(HelloRequest request, StreamObserver<HelloResponse> responseObserver) {
            HelloResponse response = HelloResponse.newBuilder()
                    .setMessage("Hello, " + request.getName() + "!")
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }

        @Override
        public void sayHelloAgain(HelloRequest request, StreamObserver<HelloResponse> responseObserver) {
            HelloResponse response = HelloResponse.newBuilder()
                    .setMessage("Hello again, " + request.getName() + "!")
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
    }

    static Server start(int port) throws Exception {
        Server server = ServerBuilder.forPort(port)
                .addService(new GreeterServiceImpl())
                .build()
                .start();
        System.out.println("gRPC server started on port " + port);
        return server;
    }
}
