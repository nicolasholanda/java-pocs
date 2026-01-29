package com.github.nicolasholanda.junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;


public class JunitParameterized {

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    void testValueSource(int number) {
        System.out.println("Testing with number: " + number);
        Assertions.assertTrue(number > 0);
    }

    @ParameterizedTest
    @ValueSource(strings = {"apple", "banana", "cherry"})
    void testValueSourceStrings(String fruit) {
        System.out.println("Testing with fruit: " + fruit);
        Assertions.assertNotNull(fruit);
    }

    @ParameterizedTest
    @CsvSource({
        "1, 2, 3",
        "5, 5, 10",
        "10, 20, 30"
    })
    void testCsvSource(int a, int b, int sum) {
        System.out.println(a + " + " + b + " = " + sum);
        Assertions.assertEquals(sum, a + b);
    }

    @ParameterizedTest
    @CsvSource({
        "John, 25",
        "Alice, 30",
        "Bob, 35"
    })
    void testCsvSourceStrings(String name, int age) {
        System.out.println(name + " is " + age + " years old");
        Assertions.assertNotNull(name);
        Assertions.assertTrue(age > 0);
    }


}

