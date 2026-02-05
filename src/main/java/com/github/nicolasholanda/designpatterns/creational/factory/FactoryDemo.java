package com.github.nicolasholanda.designpatterns.creational.factory;

public class FactoryDemo {

    static void main() {
        ShapeFactory factory = new ShapeFactory();

        factory.getShape("CIRCLE").draw();
        factory.getShape("RECTANGLE").draw();
        factory.getShape("SQUARE").draw();
    }
}

