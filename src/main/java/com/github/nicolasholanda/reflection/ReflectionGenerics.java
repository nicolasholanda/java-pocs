package com.github.nicolasholanda.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ReflectionGenerics {

    private List<String> stringList;

    public List<Person> getPersonList() {
        return null;
    }

    public static void execute() throws Exception {
        Class<?> clazz = ReflectionGenerics.class;

        System.out.println("Field generic types:");
        Field stringListField = clazz.getDeclaredField("stringList");
        Type stringListType = stringListField.getGenericType();

        if (stringListType instanceof ParameterizedType pt) {
            System.out.println("Field: " + stringListField.getName());
            System.out.println("Raw type: " + pt.getRawType());
            System.out.println("Type arguments: " + Arrays.toString(pt.getActualTypeArguments()));
        }



        System.out.println("\nMethod generic types:");
        Method getMethod = clazz.getDeclaredMethod("getPersonList");
        Type returnType = getMethod.getGenericReturnType();

        if (returnType instanceof ParameterizedType pt) {
            System.out.println("Method: " + getMethod.getName());
            System.out.println("Return type: " + pt.getRawType());
            System.out.println("Type arguments: " + Arrays.toString(pt.getActualTypeArguments()));
        }
    }
}

