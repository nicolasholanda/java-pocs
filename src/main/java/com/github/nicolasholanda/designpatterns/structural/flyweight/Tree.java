package com.github.nicolasholanda.designpatterns.structural.flyweight;

class Tree {
    private int x;
    private int y;
    private TreeType type;

    Tree(int x, int y, TreeType type) {
        this.x = x;
        this.y = y;
        this.type = type;
    }

    void draw() {
        type.draw(x, y);
    }
}
