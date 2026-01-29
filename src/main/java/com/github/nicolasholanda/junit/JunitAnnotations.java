package com.github.nicolasholanda.junit;

import org.junit.jupiter.api.*;

public class JunitAnnotations {

    @Test
    @DisplayName("Test with  display name")
    void testWithDisplayName() {
        System.out.println("Running test with display name");
        Assertions.assertEquals(4, 2 + 2);
    }

    @Test
    @Disabled("This test is disabled")
    void testDisabled() {
        System.out.println("Should not run");
        Assertions.fail("The test should be skipped");
    }

    @RepeatedTest(3)
    @DisplayName("Repeated test")
    void testRepeated(RepetitionInfo repetitionInfo) {
        System.out.println("Repetition " + repetitionInfo.getCurrentRepetition() +
                         " of " + repetitionInfo.getTotalRepetitions());
        Assertions.assertTrue(true);
    }

    @Test
    @Tag("fast")
    @DisplayName("Fast test")
    void testFast() {
        System.out.println("Running fast test");
        Assertions.assertTrue(true);
    }
}

