package com.github.nicolasholanda.designpatterns.creational.prototype;

public class PrototypeDemo {

    static void main() {
        var original = new Document("Report", "Original content", "John");
        System.out.println("Original: " + original);

        var clone = original.clone();
        clone.setContent("Modified content");
        System.out.println("Clone: " + clone);
        System.out.println("Original unchanged: " + original);
    }
}
