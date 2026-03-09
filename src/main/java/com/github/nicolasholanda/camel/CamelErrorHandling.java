package com.github.nicolasholanda.camel;

import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class CamelErrorHandling {

    static void execute() {
        try (CamelContext context = new DefaultCamelContext()) {
            context.addRoutes(new RouteBuilder() {
                @Override
                public void configure() {
                    errorHandler(deadLetterChannel("direct:deadLetter")
                            .maximumRedeliveries(2)
                            .redeliveryDelay(100)
                            .retryAttemptedLogLevel(org.apache.camel.LoggingLevel.WARN));

                    onException(IllegalArgumentException.class)
                            .handled(true)
                            .transform(simple("Invalid argument: ${exception.message}"))
                            .to("log:handled");

                    from("direct:risky")
                            .process(exchange -> {
                                String body = exchange.getIn().getBody(String.class);
                                if ("invalid".equals(body)) {
                                    throw new IllegalArgumentException("Bad input");
                                }
                                if ("fail".equals(body)) {
                                    throw new RuntimeException("Unexpected failure");
                                }
                                exchange.getIn().setBody("Processed: " + body);
                            });

                    from("direct:deadLetter")
                            .transform(simple("Dead letter received: ${body}"))
                            .to("log:deadLetter");
                }
            });

            context.start();

            ProducerTemplate template = context.createProducerTemplate();
            System.out.println(template.requestBody("direct:risky", "hello", String.class));
            System.out.println(template.requestBody("direct:risky", "invalid", String.class));

            try {
                template.requestBody("direct:risky", "fail", String.class);
            } catch (Exception e) {
                System.out.println("Caught after retries: " + e.getCause().getMessage());
            }

            context.stop();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
