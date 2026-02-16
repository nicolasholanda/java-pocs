package com.github.nicolasholanda.designpatterns.behavioral.interpreter;

public class InterpreterDemo {

    static void main() {
        Expression five = new NumberExpression(5);
        Expression three = new NumberExpression(3);
        Expression two = new NumberExpression(2);

        Expression addExpr = new AddExpression(five, three);
        System.out.println("5 + 3 = " + addExpr.interpret());

        Expression subtractExpr = new SubtractExpression(addExpr, two);
        System.out.println("(5 + 3) - 2 = " + subtractExpr.interpret());

        Expression complexExpr = new AddExpression(
            new SubtractExpression(new NumberExpression(10), new NumberExpression(4)),
            new NumberExpression(2)
        );
        System.out.println("(10 - 4) + 2 = " + complexExpr.interpret());
    }
}
