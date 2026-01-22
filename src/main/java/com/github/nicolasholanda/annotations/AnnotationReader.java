package com.github.nicolasholanda.annotations;

public class AnnotationReader {

    static void execute() {

        System.out.println("Reading class annotations:");
        Class<User> userClass = User.class;
        if (userClass.isAnnotationPresent(Entity.class)) {
            Entity entity = userClass.getAnnotation(Entity.class);
            System.out.println("Table: " + entity.table());
        }
        if (userClass.isAnnotationPresent(Deprecated.class)) {
            Deprecated deprecated = userClass.getAnnotation(Deprecated.class);
            System.out.println("Deprecated - Reason: " + deprecated.reason() + ", Since: " + deprecated.since());
        }
    }
}

