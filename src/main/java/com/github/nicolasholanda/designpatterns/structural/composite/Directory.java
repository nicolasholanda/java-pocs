package com.github.nicolasholanda.designpatterns.structural.composite;

import java.util.ArrayList;
import java.util.List;

class Directory implements FileSystemComponent {
    private String name;
    private List<FileSystemComponent> children = new ArrayList<>();

    Directory(String name) {
        this.name = name;
    }

    void add(FileSystemComponent component) {
        children.add(component);
    }

    @Override
    public void display(String indent) {
        System.out.println(indent + "Directory: " + name);
        for (FileSystemComponent child : children) {
            child.display(indent + "  ");
        }
    }

    @Override
    public int getSize() {
        return children.stream().mapToInt(FileSystemComponent::getSize).sum();
    }
}
