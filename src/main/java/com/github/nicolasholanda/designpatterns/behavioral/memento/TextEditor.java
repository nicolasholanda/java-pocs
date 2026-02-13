package com.github.nicolasholanda.designpatterns.behavioral.memento;

class TextEditor {
    private String content;

    void write(String text) {
        content = text;
    }

    String getContent() {
        return content;
    }

    TextMemento save() {
        return new TextMemento(content);
    }

    void restore(TextMemento memento) {
        content = memento.getState();
    }
}
