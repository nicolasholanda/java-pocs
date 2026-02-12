package com.github.nicolasholanda.designpatterns.behavioral.state;

interface OrderState {
    void next(Order order);
    void prev(Order order);
    void printStatus();
}
