package com.github.nicolasholanda.camel;

import org.apache.camel.AggregationStrategy;
import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class CamelSplitAggregate {

    static class ConcatStrategy implements AggregationStrategy {
        @Override
        public Exchange aggregate(Exchange oldExchange, Exchange newExchange) {
            if (oldExchange == null) {
                return newExchange;
            }
            String oldBody = oldExchange.getIn().getBody(String.class);
            String newBody = newExchange.getIn().getBody(String.class);
            oldExchange.getIn().setBody(oldBody + " | " + newBody);
            return oldExchange;
        }
    }

    static void execute() {
        try (CamelContext context = new DefaultCamelContext()) {
            context.addRoutes(new RouteBuilder() {
                @Override
                public void configure() {
                    from("direct:split")
                            .split(body().tokenize(","), new ConcatStrategy())
                                .transform(simple("${body.trim().toUpperCase()}"))
                            .end()
                            .log("Aggregated: ${body}");
                }
            });

            context.start();

            ProducerTemplate template = context.createProducerTemplate();
            String result = template.requestBody("direct:split", "apple, banana, cherry", String.class);
            System.out.println("Split + Aggregate result: " + result);

            context.stop();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
