package com.github.nicolasholanda.spring;

import org.springframework.stereotype.Service;

@Service
class CalculatorService {
    int add(int a, int b) {
        return a + b;
    }

    int multiply(int a, int b) {
        return a * b;
    }
}

@Service
class MathService {
    private final CalculatorService calculator;

    MathService(CalculatorService calculator) {
        this.calculator = calculator;
    }

    int sum(int... numbers) {
        int result = 0;
        for (int num : numbers) {
            result = calculator.add(result, num);
        }
        return result;
    }

    int factorial(int n) {
        int result = 1;
        for (int i = 2; i <= n; i++) {
            result = calculator.multiply(result, i);
        }
        return result;
    }
}

public class SpringTestingDemo {

    public static void execute() {
        System.out.println("Spring Testing Demo:");
        System.out.println("Testing features:");
        System.out.println("- @SpringBootTest - loads full application context");
        System.out.println("- @Autowired - injects beans in test classes");
        System.out.println("- @MockBean - creates mocks for beans");
        System.out.println("- @WebMvcTest - tests MVC controllers");
        System.out.println("- TestRestTemplate - tests REST endpoints");
        System.out.println("See test classes for examples");
    }
}
