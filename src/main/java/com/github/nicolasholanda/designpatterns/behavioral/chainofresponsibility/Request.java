package com.github.nicolasholanda.designpatterns.behavioral.chainofresponsibility;

class Request {
    private String description;
    private Priority priority;

    Request(String description, Priority priority) {
        this.description = description;
        this.priority = priority;
    }

    String getDescription() {
        return description;
    }

    Priority getPriority() {
        return priority;
    }
}
