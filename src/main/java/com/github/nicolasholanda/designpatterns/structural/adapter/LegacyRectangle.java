package com.github.nicolasholanda.designpatterns.structural.adapter;

class LegacyRectangle {
    void display(int x1, int y1, int x2, int y2) {
        System.out.printf("LegacyRectangle: (%d,%d) to (%d,%d)%n", x1, y1, x2, y2);
    }
}
