package com.github.nicolasholanda.designpatterns.behavioral.mediator;

interface ChatMediator {
    void sendMessage(String message, User user);
    void addUser(User user);
}
