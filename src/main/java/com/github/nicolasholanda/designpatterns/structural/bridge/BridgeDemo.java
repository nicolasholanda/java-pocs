package com.github.nicolasholanda.designpatterns.structural.bridge;

public class BridgeDemo {

    static void main() {
        Shape redCircle = new Circle(new RedColor());
        Shape blueSquare = new Square(new BlueColor());

        redCircle.draw();
        blueSquare.draw();
    }
}
