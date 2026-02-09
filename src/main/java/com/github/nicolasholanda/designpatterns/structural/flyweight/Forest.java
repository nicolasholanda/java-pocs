package com.github.nicolasholanda.designpatterns.structural.flyweight;

import java.util.ArrayList;
import java.util.List;

class Forest {
    private List<Tree> trees = new ArrayList<>();

    void plantTree(int x, int y, String name, String color, String texture) {
        TreeType type = TreeFactory.getTreeType(name, color, texture);
        Tree tree = new Tree(x, y, type);
        trees.add(tree);
    }

    void draw() {
        for (Tree tree : trees) {
            tree.draw();
        }
    }
}
