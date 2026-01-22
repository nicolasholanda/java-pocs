package com.github.nicolasholanda.annotations;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

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

        System.out.println("Reading field annotations:");
        for (Field field : userClass.getDeclaredFields()) {
            if (field.isAnnotationPresent(Column.class)) {
                Column column = field.getAnnotation(Column.class);
                System.out.println("Field: " + field.getName() + ", Column: " + column.name() + ", Nullable: " + column.nullable());
            }
        }

        System.out.println("Reading method annotations:");
        for (Method method : userClass.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Execute.class)) {
                Execute execute = method.getAnnotation(Execute.class);
                System.out.println("Method: " + method.getName() + ", Priority: " + execute.priority());
            }
            if (method.isAnnotationPresent(Deprecated.class)) {
                Deprecated deprecated = method.getAnnotation(Deprecated.class);
                System.out.println("Method " + method.getName() + " deprecated - " + deprecated.reason());
            }
        }
    }
}

