package com.github.nicolasholanda.designpatterns.behavioral.interpreter;

class NumberExpression implements Expression {
    private int number;

    NumberExpression(int number) {
        this.number = number;
    }

    public int interpret() {
        return number;
    }
}
