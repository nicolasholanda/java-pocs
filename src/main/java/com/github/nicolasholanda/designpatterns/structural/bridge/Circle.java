package com.github.nicolasholanda.designpatterns.structural.bridge;

class Circle extends Shape {
    Circle(Color color) {
        super(color);
    }

    @Override
    void draw() {
        System.out.print("Drawing Circle. ");
        color.applyColor();
    }
}
