package com.github.nicolasholanda.designpatterns.behavioral.memento;

class TextMemento {
    private final String state;

    TextMemento(String state) {
        this.state = state;
    }

    String getState() {
        return state;
    }
}
