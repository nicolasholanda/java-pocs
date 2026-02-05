package com.github.nicolasholanda.designpatterns.creational.factory;

class ShapeFactory {

    Shape getShape(String shapeType) {
        if (shapeType == null) {
            return null;
        }
        return switch (shapeType.toUpperCase()) {
            case "CIRCLE" -> new Circle();
            case "RECTANGLE" -> new Rectangle();
            case "SQUARE" -> new Square();
            default -> null;
        };
    }
}

