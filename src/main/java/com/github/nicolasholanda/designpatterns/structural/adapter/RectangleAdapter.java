package com.github.nicolasholanda.designpatterns.structural.adapter;

class RectangleAdapter implements Shape {
    private LegacyRectangle legacyRectangle;

    RectangleAdapter(LegacyRectangle legacyRectangle) {
        this.legacyRectangle = legacyRectangle;
    }

    @Override
    public void draw(int x, int y, int width, int height) {
        int x2 = x + width;
        int y2 = y + height;
        legacyRectangle.display(x, y, x2, y2);
    }
}
