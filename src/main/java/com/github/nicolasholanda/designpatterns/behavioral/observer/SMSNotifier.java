package com.github.nicolasholanda.designpatterns.behavioral.observer;

class SMSNotifier implements Observer {
    private String phone;

    SMSNotifier(String phone) {
        this.phone = phone;
    }

    @Override
    public void update(String message) {
        System.out.println("SMS to " + phone + ": " + message);
    }
}
