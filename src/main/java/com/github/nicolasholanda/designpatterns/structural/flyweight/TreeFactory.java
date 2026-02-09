package com.github.nicolasholanda.designpatterns.structural.flyweight;

import java.util.HashMap;
import java.util.Map;

class TreeFactory {
    private static Map<String, TreeType> treeTypes = new HashMap<>();

    static TreeType getTreeType(String name, String color, String texture) {
        String key = name + color + texture;
        TreeType type = treeTypes.get(key);
        if (type == null) {
            type = new TreeType(name, color, texture);
            treeTypes.put(key, type);
            System.out.println("Creating new TreeType: " + name);
        }
        return type;
    }

    static int getTotalTreeTypes() {
        return treeTypes.size();
    }
}
