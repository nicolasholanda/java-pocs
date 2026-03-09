package com.github.nicolasholanda.camel;

import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class CamelFilter {

    static void execute() {
        try (CamelContext context = new DefaultCamelContext()) {
            context.addRoutes(new RouteBuilder() {
                @Override
                public void configure() {
                    from("direct:filter")
                            .choice()
                                .when(simple("${body} contains 'urgent'"))
                                    .transform(simple("URGENT: ${body}"))
                                    .to("log:urgent")
                                .when(simple("${body} contains 'info'"))
                                    .transform(simple("INFO: ${body}"))
                                    .to("log:info")
                                .otherwise()
                                    .transform(simple("OTHER: ${body}"))
                                    .to("log:other")
                            .end();
                }
            });

            context.start();

            ProducerTemplate template = context.createProducerTemplate();
            System.out.println(template.requestBody("direct:filter", "urgent task pending", String.class));
            System.out.println(template.requestBody("direct:filter", "info system started", String.class));
            System.out.println(template.requestBody("direct:filter", "random message", String.class));

            context.stop();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
