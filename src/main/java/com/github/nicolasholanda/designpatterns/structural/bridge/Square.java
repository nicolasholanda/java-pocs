package com.github.nicolasholanda.designpatterns.structural.bridge;

class Square extends Shape {
    Square(Color color) {
        super(color);
    }

    @Override
    void draw() {
        System.out.print("Drawing Square. ");
        color.applyColor();
    }
}
