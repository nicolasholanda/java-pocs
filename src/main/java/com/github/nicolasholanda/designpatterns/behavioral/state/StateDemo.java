package com.github.nicolasholanda.designpatterns.behavioral.state;

public class StateDemo {

    static void main() {
        Order order = new Order();
        order.printStatus();

        order.next();
        order.printStatus();

        order.next();
        order.printStatus();

        order.next();
        order.printStatus();

        order.next();

        order.prev();
        order.printStatus();
    }
}
