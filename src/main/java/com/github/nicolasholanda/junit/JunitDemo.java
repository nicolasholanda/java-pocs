package com.github.nicolasholanda.junit;

import org.junit.platform.launcher.Launcher;
import org.junit.platform.launcher.LauncherDiscoveryRequest;
import org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder;
import org.junit.platform.launcher.core.LauncherFactory;
import org.junit.platform.launcher.listeners.SummaryGeneratingListener;
import org.junit.platform.launcher.listeners.TestExecutionSummary;

import static org.junit.platform.engine.discovery.DiscoverySelectors.selectClass;

public class JunitDemo {

    static void main() {

        System.out.println("--- JUnit Assertions ---");
        runTests(JunitAssertions.class);

        System.out.println("--- JUnit Lifecycle ---");
        runTests(JunitLifecycle.class);

        System.out.println("--- JUnit Annotations ---");
        runTests(JunitAnnotations.class);

        System.out.println("--- JUnit Parameterized ---");
        runTests(JunitParameterized.class);

        System.out.println("--- JUnit Nested ---");
        runTests(JunitNested.class);

        System.out.println("--- JUnit Conditional ---");
        runTests(JunitConditional.class);

        System.out.println("--- JUnit Timeout ---");
        runTests(JunitTimeout.class);

        System.out.println("--- JUnit Assumptions ---");
        runTests(JunitAssumptions.class);

        System.out.println("--- JUnit Exceptions ---");
        runTests(JunitExceptions.class);
    }

    static void runTests(Class<?> testClass) {
        LauncherDiscoveryRequest request = LauncherDiscoveryRequestBuilder.request()
            .selectors(selectClass(testClass))
            .build();

        Launcher launcher = LauncherFactory.create();
        SummaryGeneratingListener listener = new SummaryGeneratingListener();
        launcher.registerTestExecutionListeners(listener);
        launcher.execute(request);

        TestExecutionSummary summary = listener.getSummary();
        System.out.println("Tests run: " + summary.getTestsSucceededCount());
        System.out.println("Tests failed: " + summary.getTestsFailedCount());
    }
}

