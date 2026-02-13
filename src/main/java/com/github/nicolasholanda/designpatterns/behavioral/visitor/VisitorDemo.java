package com.github.nicolasholanda.designpatterns.behavioral.visitor;

public class VisitorDemo {

    static void main() {
        Shape circle = new Circle(5);
        Shape rectangle = new Rectangle(4, 6);

        ShapeVisitor areaCalculator = new AreaCalculator();
        ShapeVisitor perimeterCalculator = new PerimeterCalculator();

        circle.accept(areaCalculator);
        circle.accept(perimeterCalculator);

        rectangle.accept(areaCalculator);
        rectangle.accept(perimeterCalculator);
    }
}
