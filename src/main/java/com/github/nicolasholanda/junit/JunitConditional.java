package com.github.nicolasholanda.junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;

public class JunitConditional {

    @Test
    @EnabledOnOs(OS.WINDOWS)
    void testOnWindows() {
        System.out.println("Running on Windows");
        Assertions.assertTrue(true);
    }

    @Test
    @EnabledOnOs({OS.LINUX, OS.MAC})
    void testOnLinuxOrMac() {
        System.out.println("Running on Linux or Mac");
        Assertions.assertTrue(true);
    }

    @Test
    @DisabledOnOs(OS.WINDOWS)
    void testNotOnWindows() {
        System.out.println("Not running on Windows");
        Assertions.assertTrue(true);
    }

    @Test
    @EnabledOnJre(JRE.JAVA_21)
    void testOnJava21() {
        System.out.println("Running on Java 21");
        Assertions.assertTrue(true);
    }

    @Test
    @DisabledOnJre(JRE.JAVA_8)
    void testNotOnJava8() {
        System.out.println("Not running on Java 8");
        Assertions.assertTrue(true);
    }

    @Test
    @EnabledIfSystemProperty(named = "os.arch", matches = ".*64.*")
    void testOn64BitArchitecture() {
        System.out.println("Running on 64-bit architecture");
        Assertions.assertTrue(true);
    }

    @Test
    @DisabledIfSystemProperty(named = "user.name", matches = "admin")
    void testNotAsAdmin() {
        System.out.println("Not running as admin");
        Assertions.assertTrue(true);
    }

    @Test
    @EnabledIfEnvironmentVariable(named = "ENV", matches = "prod")
    void testInProduction() {
        System.out.println("Running in production");
        Assertions.assertTrue(true);
    }

    @Test
    @DisabledIfEnvironmentVariable(named = "CI", matches = "true")
    void testNotInCI() {
        System.out.println("Not running in CI");
        Assertions.assertTrue(true);
    }
}

