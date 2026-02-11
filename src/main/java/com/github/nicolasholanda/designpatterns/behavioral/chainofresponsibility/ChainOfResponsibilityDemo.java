package com.github.nicolasholanda.designpatterns.behavioral.chainofresponsibility;

public class ChainOfResponsibilityDemo {

    static void main() {
        SupportHandler level1 = new Level1Support();
        SupportHandler level2 = new Level2Support();
        SupportHandler level3 = new Level3Support();

        level1.setNext(level2);
        level2.setNext(level3);

        Request r1 = new Request("Password reset", Priority.LOW);
        Request r2 = new Request("System crash", Priority.HIGH);
        Request r3 = new Request("Slow performance", Priority.MEDIUM);

        level1.handleRequest(r1);
        level1.handleRequest(r2);
        level1.handleRequest(r3);
    }
}
