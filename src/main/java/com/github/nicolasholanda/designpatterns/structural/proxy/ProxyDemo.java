package com.github.nicolasholanda.designpatterns.structural.proxy;

public class ProxyDemo {

    static void main() {
        Image image1 = new ProxyImage("photo1.jpg");
        Image image2 = new ProxyImage("photo2.jpg");

        System.out.println("First display of image1:");
        image1.display();

        System.out.println("Second display of image1:");
        image1.display();

        System.out.println("First display of image2:");
        image2.display();
    }
}
