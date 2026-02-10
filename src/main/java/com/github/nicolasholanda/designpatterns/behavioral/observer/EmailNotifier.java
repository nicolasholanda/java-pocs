package com.github.nicolasholanda.designpatterns.behavioral.observer;

class EmailNotifier implements Observer {
    private String email;

    EmailNotifier(String email) {
        this.email = email;
    }

    @Override
    public void update(String message) {
        System.out.println("Email to " + email + ": " + message);
    }
}
