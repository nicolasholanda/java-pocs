package com.github.nicolasholanda.designpatterns.structural.facade;

public class FacadeDemo {

    static void main() {
        ComputerFacade computer = new ComputerFacade();
        computer.start();
    }
}
