package com.github.nicolasholanda.junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assumptions.*;

public class JunitAssumptions {

    @Test
    void testAssumeTrue() {
        String env = System.getProperty("env", "dev");
        assumeTrue(env.equals("dev"));
        System.out.println("Running test in dev environment");
        Assertions.assertTrue(true);
    }

    @Test
    void testAssumeFalse() {
        String os = System.getProperty("os.name");
        assumeFalse(os.contains("Linux"));
        System.out.println("Running test on non-Linux OS");
        Assertions.assertTrue(true);
    }

    @Test
    void testAssumingThat() {
        String env = System.getProperty("env", "dev");

        assumingThat(env.equals("dev"), () -> {
            System.out.println("Running dev-specific code");
            Assertions.assertEquals("dev", env);
        });

        System.out.println("This always runs regardless of env");
        Assertions.assertTrue(true);
    }

    @Test
    void testMultipleAssumptions() {
        String os = System.getProperty("os.name");
        String arch = System.getProperty("os.arch");

        assumeTrue(os.contains("Windows"));
        assumeTrue(arch.contains("64"));

        System.out.println("Running on Windows 64-bit");
        Assertions.assertTrue(true);
    }

    @Test
    void testAssumingThatMultiple() {
        boolean isCI = System.getenv("CI") != null;

        assumingThat(isCI, () -> {
            System.out.println("Running in CI environment");
        });

        assumingThat(!isCI, () -> {
            System.out.println("Running locally");
        });

        System.out.println("Common test logic");
        Assertions.assertTrue(true);
    }
}

