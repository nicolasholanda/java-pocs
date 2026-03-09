package com.github.nicolasholanda.camel;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class CamelTransform {

    static class UpperCaseProcessor implements Processor {
        @Override
        public void process(Exchange exchange) {
            String body = exchange.getIn().getBody(String.class);
            exchange.getIn().setBody(body.toUpperCase());
        }
    }

    static class ReverseBean {
        public String reverse(String body) {
            return new StringBuilder(body).reverse().toString();
        }
    }

    static void execute() {
        try (CamelContext context = new DefaultCamelContext()) {
            context.getRegistry().bind("reverseBean", new ReverseBean());

            context.addRoutes(new RouteBuilder() {
                @Override
                public void configure() {
                    from("direct:transform")
                            .process(new UpperCaseProcessor())
                            .log("After processor: ${body}")
                            .bean("reverseBean", "reverse")
                            .log("After bean: ${body}");
                }
            });

            context.start();

            ProducerTemplate template = context.createProducerTemplate();
            String result = template.requestBody("direct:transform", "Apache Camel", String.class);
            System.out.println("Final result: " + result);

            context.stop();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
