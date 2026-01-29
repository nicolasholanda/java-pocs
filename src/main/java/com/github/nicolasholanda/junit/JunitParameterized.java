package com.github.nicolasholanda.junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

enum Status {
    ACTIVE, INACTIVE, PENDING
}

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

    @ParameterizedTest
    @MethodSource("provideNumbers")
    void testMethodSource(int number) {
        System.out.println("Testing with number from method: " + number);
        Assertions.assertTrue(number % 2 == 0);
    }

    static Stream<Integer> provideNumbers() {
        return Stream.of(2, 4, 6, 8, 10);
    }

    @ParameterizedTest
    @EnumSource(Status.class)
    void testEnumSource(Status status) {
        System.out.println("Testing with status: " + status);
        Assertions.assertNotNull(status);
    }

    @ParameterizedTest
    @EnumSource(value = Status.class, names = {"ACTIVE", "INACTIVE"})
    void testEnumSourceFiltered(Status status) {
        System.out.println("Testing status: " + status);
        Assertions.assertTrue(status == Status.ACTIVE || status == Status.INACTIVE);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"  ", "\t", "\n"})
    void testNullAndEmpty(String input) {
        System.out.println("Testing with blank inputt: [" + input + "]");
        Assertions.assertTrue(input == null || input.trim().isEmpty());
    }
}

