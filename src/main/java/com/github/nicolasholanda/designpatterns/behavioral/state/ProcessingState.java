package com.github.nicolasholanda.designpatterns.behavioral.state;

class ProcessingState implements OrderState {
    @Override
    public void next(Order order) {
        order.setState(new ShippedState());
    }

    @Override
    public void prev(Order order) {
        order.setState(new NewState());
    }

    @Override
    public void printStatus() {
        System.out.println("Order is PROCESSING");
    }
}
