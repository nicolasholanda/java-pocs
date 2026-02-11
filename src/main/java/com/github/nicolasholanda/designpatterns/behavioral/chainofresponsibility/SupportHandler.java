package com.github.nicolasholanda.designpatterns.behavioral.chainofresponsibility;

abstract class SupportHandler {
    protected SupportHandler next;

    void setNext(SupportHandler next) {
        this.next = next;
    }

    abstract void handleRequest(Request request);
}
