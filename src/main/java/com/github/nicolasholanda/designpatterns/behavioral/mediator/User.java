package com.github.nicolasholanda.designpatterns.behavioral.mediator;

abstract class User {
    protected ChatMediator mediator;
    protected String name;

    User(ChatMediator mediator, String name) {
        this.mediator = mediator;
        this.name = name;
    }

    abstract void send(String message);
    abstract void receive(String message);
}
