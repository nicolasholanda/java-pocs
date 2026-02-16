package com.github.nicolasholanda.designpatterns.behavioral.interpreter;

class SubtractExpression implements Expression {
    private Expression left;
    private Expression right;

    SubtractExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    public int interpret() {
        return left.interpret() - right.interpret();
    }
}
