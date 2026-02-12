package com.github.nicolasholanda.designpatterns.behavioral.state;

class DeliveredState implements OrderState {
    @Override
    public void next(Order order) {
        System.out.println("Already at final state");
    }

    @Override
    public void prev(Order order) {
        order.setState(new ShippedState());
    }

    @Override
    public void printStatus() {
        System.out.println("Order is DELIVERED");
    }
}
