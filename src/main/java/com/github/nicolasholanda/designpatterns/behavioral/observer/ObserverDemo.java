package com.github.nicolasholanda.designpatterns.behavioral.observer;

public class ObserverDemo {

    static void main() {
        Subject newsAgency = new Subject();

        Observer emailSub = new EmailNotifier("user@example.com");
        Observer smsSub = new SMSNotifier("123-456-7890");

        newsAgency.attach(emailSub);
        newsAgency.attach(smsSub);

        newsAgency.notifyObservers("Breaking News!");

        newsAgency.detach(smsSub);
        newsAgency.notifyObservers("Another update");
    }
}
