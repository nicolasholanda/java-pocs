package com.github.nicolasholanda.java25;

import java.lang.classfile.ClassFile;
import java.lang.classfile.ClassModel;
import java.lang.classfile.MethodModel;
import java.nio.file.Files;
import java.nio.file.Path;

public class ClassFileApiDemo {

    public static void execute() {
        System.out.println("Class-File API:");

        try {
            String className = "com.github.nicolasholanda.java25.FlexibleConstructors";
            Path classPath = Path.of("target/classes/" + className.replace('.', '/') + ".class");

            if (!Files.exists(classPath)) {
                System.out.println("Class file not found, skipping demo");
                return;
            }

            byte[] classBytes = Files.readAllBytes(classPath);
            ClassModel classModel = ClassFile.of().parse(classBytes);

            System.out.println("Class name: " + classModel.thisClass().asInternalName());
            System.out.println("Super class: " + classModel.superclass().map(e -> e.asSymbol().displayName()).orElse("none"));
            System.out.println("Access flags: " + classModel.flags().flagsMask());

            System.out.println("Methods:");
            for (MethodModel method : classModel.methods()) {
                System.out.println("  - " + method.methodName() + method.methodType().stringValue());
            }

            System.out.println("Fields:");
            classModel.fields().forEach(field ->
                System.out.println("  - " + field.fieldName() + ": " + field.fieldType().stringValue())
            );

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
