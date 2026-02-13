package com.github.nicolasholanda.designpatterns.behavioral.visitor;

interface ShapeVisitor {
    void visit(Circle circle);
    void visit(Rectangle rectangle);
}
