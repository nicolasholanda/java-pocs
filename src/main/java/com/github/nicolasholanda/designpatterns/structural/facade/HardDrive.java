package com.github.nicolasholanda.designpatterns.structural.facade;

class HardDrive {
    byte[] read(long lba, int size) {
        System.out.println("HardDrive: Reading " + size + " bytes from sector " + lba);
        return new byte[size];
    }
}
