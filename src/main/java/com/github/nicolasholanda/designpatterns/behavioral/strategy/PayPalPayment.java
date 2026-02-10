package com.github.nicolasholanda.designpatterns.behavioral.strategy;

class PayPalPayment implements PaymentStrategy {
    private String email;

    PayPalPayment(String email) {
        this.email = email;
    }

    @Override
    public void pay(int amount) {
        System.out.println("Paid $" + amount + " using PayPal: " + email);
    }
}
