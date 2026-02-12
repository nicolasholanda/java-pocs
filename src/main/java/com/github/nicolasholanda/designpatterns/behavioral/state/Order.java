package com.github.nicolasholanda.designpatterns.behavioral.state;

class Order {
    private OrderState state;

    Order() {
        state = new NewState();
    }

    void setState(OrderState state) {
        this.state = state;
    }

    void next() {
        state.next(this);
    }

    void prev() {
        state.prev(this);
    }

    void printStatus() {
        state.printStatus();
    }
}
