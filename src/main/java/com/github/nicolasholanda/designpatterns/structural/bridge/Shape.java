package com.github.nicolasholanda.designpatterns.structural.bridge;

abstract class Shape {
    protected Color color;

    Shape(Color color) {
        this.color = color;
    }

    abstract void draw();
}
