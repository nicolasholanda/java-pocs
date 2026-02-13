package com.github.nicolasholanda.designpatterns.behavioral.visitor;

interface Shape {
    void accept(ShapeVisitor visitor);
}
