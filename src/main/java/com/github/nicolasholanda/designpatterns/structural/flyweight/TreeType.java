package com.github.nicolasholanda.designpatterns.structural.flyweight;

class TreeType {
    private String name;
    private String color;
    private String texture;

    TreeType(String name, String color, String texture) {
        this.name = name;
        this.color = color;
        this.texture = texture;
    }

    void draw(int x, int y) {
        System.out.println("Drawing %s tree at (%d,%d) with color %s".formatted(name, x, y, color));
    }
}
