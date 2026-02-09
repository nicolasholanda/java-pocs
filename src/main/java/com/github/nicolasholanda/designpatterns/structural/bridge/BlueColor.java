package com.github.nicolasholanda.designpatterns.structural.bridge;

class BlueColor implements Color {
    @Override
    public void applyColor() {
        System.out.println("Applying blue color");
    }
}
