package com.github.nicolasholanda.spring;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = {CalculatorService.class, MathService.class})
class SpringTestingTest {

    @Autowired
    private MathService mathService;

    @Autowired
    private CalculatorService calculatorService;

    @Test
    void testAutowiredService() {
        int result = calculatorService.add(5, 3);
        assertEquals(8, result);
    }

    @Test
    void testDependencyInjection() {
        int result = mathService.sum(1, 2, 3, 4, 5);
        assertEquals(15, result);
    }

    @Test
    void testFactorial() {
        int result = mathService.factorial(5);
        assertEquals(120, result);
    }
}

@SpringBootTest(classes = {CalculatorService.class, MathService.class})
class MockBeanTest {

    @Autowired
    private MathService mathService;

    @MockitoBean
    private CalculatorService calculatorService;

    @Test
    void testWithMockBean() {
        when(calculatorService.add(0, 10)).thenReturn(10);
        when(calculatorService.add(10, 20)).thenReturn(30);
        when(calculatorService.add(30, 30)).thenReturn(60);

        int result = mathService.sum(10, 20, 30);
        assertEquals(60, result);
    }

    @Test
    void testMultiplyWithMock() {
        when(calculatorService.multiply(1, 2)).thenReturn(2);
        when(calculatorService.multiply(2, 3)).thenReturn(6);
        when(calculatorService.multiply(6, 4)).thenReturn(24);

        int result = mathService.factorial(4);
        assertEquals(24, result);
    }
}
