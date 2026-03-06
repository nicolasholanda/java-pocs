package com.github.nicolasholanda.camel;

import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class CamelBasics {

    static void execute() {
        try (CamelContext context = new DefaultCamelContext()) {
            context.addRoutes(new RouteBuilder() {
                @Override
                public void configure() {
                    from("direct:start")
                            .log("Received: ${body}")
                            .transform(simple("Hello, ${body}!"))
                            .to("log:result");
                }
            });

            context.start();

            ProducerTemplate template = context.createProducerTemplate();
            String result = template.requestBody("direct:start", "Camel", String.class);
            System.out.println("Result: " + result);

            context.stop();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
