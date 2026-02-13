package com.github.nicolasholanda.designpatterns.behavioral.memento;

import java.util.Stack;

class History {
    private Stack<TextMemento> history = new Stack<>();

    void save(TextMemento memento) {
        history.push(memento);
    }

    TextMemento undo() {
        if (!history.isEmpty()) {
            return history.pop();
        }
        return null;
    }
}
