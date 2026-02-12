package com.github.nicolasholanda.designpatterns.behavioral.state;

class ShippedState implements OrderState {
    @Override
    public void next(Order order) {
        order.setState(new DeliveredState());
    }

    @Override
    public void prev(Order order) {
        order.setState(new ProcessingState());
    }

    @Override
    public void printStatus() {
        System.out.println("Order is SHIPPED");
    }
}
