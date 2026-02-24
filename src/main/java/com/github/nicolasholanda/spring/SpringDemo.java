package com.github.nicolasholanda.spring;

public class SpringDemo {

    static void main() {
        IoCDemo.execute();
        System.out.println();
        BeanScopesDemo.execute();
        System.out.println();
        DependencyInjectionDemo.execute();
        System.out.println();
        BeanPostProcessorDemo.execute();
        System.out.println();
        ValueAnnotationDemo.execute();
        System.out.println();
        SpringBootDemo.execute();
        System.out.println();
        RestSupportDemo.execute();
    }
}
