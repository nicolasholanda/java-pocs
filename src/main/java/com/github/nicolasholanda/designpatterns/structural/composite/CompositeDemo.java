package com.github.nicolasholanda.designpatterns.structural.composite;

public class CompositeDemo {

    static void main() {
        File file1 = new File("file1.txt", 10);
        File file2 = new File("file2.txt", 20);
        File file3 = new File("file3.txt", 30);

        Directory dir1 = new Directory("Documents");
        dir1.add(file1);
        dir1.add(file2);

        Directory dir2 = new Directory("Projects");
        dir2.add(file3);

        Directory root = new Directory("Root");
        root.add(dir1);
        root.add(dir2);

        root.display("");
        System.out.println("Total size: " + root.getSize() + "KB");
    }
}
