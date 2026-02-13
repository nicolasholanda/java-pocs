package com.github.nicolasholanda.designpatterns.behavioral.mediator;

class ChatUser extends User {

    ChatUser(ChatMediator mediator, String name) {
        super(mediator, name);
    }

    @Override
    void send(String message) {
        System.out.println(name + " sends: " + message);
        mediator.sendMessage(message, this);
    }

    @Override
    void receive(String message) {
        System.out.println(name + " received: " + message);
    }
}
