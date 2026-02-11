package com.github.nicolasholanda.designpatterns.behavioral.chainofresponsibility;

class Level1Support extends SupportHandler {
    @Override
    void handleRequest(Request request) {
        if (request.getPriority() == Priority.LOW) {
            System.out.println("Level 1 handled: " + request.getDescription());
        } else if (next != null) {
            next.handleRequest(request);
        }
    }
}
