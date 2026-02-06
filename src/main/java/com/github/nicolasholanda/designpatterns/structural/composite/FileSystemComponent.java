package com.github.nicolasholanda.designpatterns.structural.composite;

interface FileSystemComponent {
    void display(String indent);
    int getSize();
}
