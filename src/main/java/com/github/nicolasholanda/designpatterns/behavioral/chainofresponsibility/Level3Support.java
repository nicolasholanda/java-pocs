package com.github.nicolasholanda.designpatterns.behavioral.chainofresponsibility;

class Level3Support extends SupportHandler {
    @Override
    void handleRequest(Request request) {
        if (request.getPriority() == Priority.HIGH) {
            System.out.println("Level 3 handled: " + request.getDescription());
        } else if (next != null) {
            next.handleRequest(request);
        }
    }
}
