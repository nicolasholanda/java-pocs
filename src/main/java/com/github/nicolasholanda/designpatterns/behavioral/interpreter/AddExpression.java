package com.github.nicolasholanda.designpatterns.behavioral.interpreter;

class AddExpression implements Expression {
    private Expression left;
    private Expression right;

    AddExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    public int interpret() {
        return left.interpret() + right.interpret();
    }
}
