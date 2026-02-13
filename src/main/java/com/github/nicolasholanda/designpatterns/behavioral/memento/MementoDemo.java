package com.github.nicolasholanda.designpatterns.behavioral.memento;

public class MementoDemo {

    static void main() {
        TextEditor editor = new TextEditor();
        History history = new History();

        editor.write("Version 1");
        history.save(editor.save());
        System.out.println("Current: " + editor.getContent());

        editor.write("Version 2");
        history.save(editor.save());
        System.out.println("Current: " + editor.getContent());

        editor.write("Version 3");
        System.out.println("Current: " + editor.getContent());

        editor.restore(history.undo());
        System.out.println("After undo: " + editor.getContent());

        editor.restore(history.undo());
        System.out.println("After undo: " + editor.getContent());
    }
}
