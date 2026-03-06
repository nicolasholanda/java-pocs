package com.github.nicolasholanda.camel;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

import java.nio.file.Files;
import java.nio.file.Path;

public class CamelFileRoute {

    static void execute() {
        try (CamelContext context = new DefaultCamelContext()) {
            Path inputDir = Files.createTempDirectory("camel-input");
            Path outputDir = Files.createTempDirectory("camel-output");

            Files.writeString(inputDir.resolve("test.txt"), "Hello from Camel file route!");

            context.addRoutes(new RouteBuilder() {
                @Override
                public void configure() {
                    from("file:" + inputDir + "?noop=true")
                            .log("Processing file: ${header.CamelFileName}")
                            .to("file:" + outputDir);
                }
            });

            context.start();
            Thread.sleep(3000);
            context.stop();

            Path outputFile = outputDir.resolve("test.txt");
            if (Files.exists(outputFile)) {
                System.out.println("Output file content: " + Files.readString(outputFile));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
