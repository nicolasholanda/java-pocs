package com.github.nicolasholanda.designpatterns.structural.bridge;

class RedColor implements Color {
    @Override
    public void applyColor() {
        System.out.println("Applying red color");
    }
}
