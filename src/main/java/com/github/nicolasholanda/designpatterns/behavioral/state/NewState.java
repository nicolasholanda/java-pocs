package com.github.nicolasholanda.designpatterns.behavioral.state;

class NewState implements OrderState {
    @Override
    public void next(Order order) {
        order.setState(new ProcessingState());
    }

    @Override
    public void prev(Order order) {
        System.out.println("Already at first state");
    }

    @Override
    public void printStatus() {
        System.out.println("Order is NEW");
    }
}
