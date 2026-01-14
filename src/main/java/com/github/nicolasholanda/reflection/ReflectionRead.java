package com.github.nicolasholanda.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionRead {
    public static void execute() throws Exception {
        Class<?> personClass = Person.class;

        System.out.println("Class name: " + personClass.getName());
        System.out.println("Simple name: " + personClass.getSimpleName());

        System.out.println("- Fields:");
        Field[] fields = personClass.getDeclaredFields();
        for (Field field : fields) {
            System.out.println("  " + field.getName() + " - " + field.getType().getSimpleName());
        }

        System.out.println("- Methods:");
        Method[] methods = personClass.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println("  " + method.getName() + " - returns " + method.getReturnType().getSimpleName());
        }

        System.out.println("- Constructors:");
        Constructor<?>[] constructors = personClass.getDeclaredConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.print("  " + constructor.getName() + "(");
            Class<?>[] paramTypes = constructor.getParameterTypes();
            for (int i = 0; i < paramTypes.length; i++) {
                System.out.print(paramTypes[i].getSimpleName());
                if (i < paramTypes.length - 1) System.out.print(", ");
            }
            System.out.println(")");
        }
    }
}

