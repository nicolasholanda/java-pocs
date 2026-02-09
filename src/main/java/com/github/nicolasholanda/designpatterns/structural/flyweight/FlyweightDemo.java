package com.github.nicolasholanda.designpatterns.structural.flyweight;

public class FlyweightDemo {

    static void main() {
        Forest forest = new Forest();

        forest.plantTree(1, 2, "Oak", "Green", "Rough");
        forest.plantTree(3, 4, "Pine", "Dark Green", "Smooth");
        forest.plantTree(5, 6, "Oak", "Green", "Rough");
        forest.plantTree(7, 8, "Pine", "Dark Green", "Smooth");
        forest.plantTree(9, 10, "Oak", "Green", "Rough");

        forest.draw();
        System.out.println("Total TreeType objects created: " + TreeFactory.getTotalTreeTypes());
    }
}
