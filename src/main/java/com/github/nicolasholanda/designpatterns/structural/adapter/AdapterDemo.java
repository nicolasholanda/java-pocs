package com.github.nicolasholanda.designpatterns.structural.adapter;

public class AdapterDemo {

    static void main() {
        LegacyRectangle legacyRect = new LegacyRectangle();
        Shape adapter = new RectangleAdapter(legacyRect);

        adapter.draw(10, 20, 30, 40);
    }
}
