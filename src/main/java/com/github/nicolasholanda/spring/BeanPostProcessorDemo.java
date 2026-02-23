package com.github.nicolasholanda.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
class OrderService {
    void process() {
        System.out.println("Processing order");
    }
}

@Component
class PaymentService {
    void charge() {
        System.out.println("Charging payment");
    }
}

@Component
class LoggingBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof OrderService || bean instanceof PaymentService) {
            System.out.println("Before init: " + beanName + " - " + bean.getClass().getSimpleName());
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof OrderService || bean instanceof PaymentService) {
            System.out.println("After init: " + beanName + " - " + bean.getClass().getSimpleName());
        }
        return bean;
    }
}

@Component
class TimingBeanPostProcessor implements BeanPostProcessor {
    private long startTime;

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof OrderService || bean instanceof PaymentService) {
            startTime = System.nanoTime();
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof OrderService || bean instanceof PaymentService) {
            long elapsed = System.nanoTime() - startTime;
            System.out.println("Bean " + beanName + " initialized in " + elapsed + " ns");
        }
        return bean;
    }
}

public class BeanPostProcessorDemo {

    public static void execute() {
        System.out.println("Bean Post Processor:");

        try (var context = new AnnotationConfigApplicationContext()) {
            context.scan("com.github.nicolasholanda.spring");
            context.refresh();

            System.out.println("Using beans:");
            OrderService orderService = context.getBean(OrderService.class);
            orderService.process();

            PaymentService paymentService = context.getBean(PaymentService.class);
            paymentService.charge();
        }
    }
}
