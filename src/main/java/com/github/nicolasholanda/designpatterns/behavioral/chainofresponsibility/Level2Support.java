package com.github.nicolasholanda.designpatterns.behavioral.chainofresponsibility;

class Level2Support extends SupportHandler {
    @Override
    void handleRequest(Request request) {
        if (request.getPriority() == Priority.MEDIUM) {
            System.out.println("Level 2 handled: " + request.getDescription());
        } else if (next != null) {
            next.handleRequest(request);
        }
    }
}
