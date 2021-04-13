package com.sobhan.producer;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class Router extends RouteBuilder {

    @Override
    public void configure() {
        from("timer:producer-timer?period=3000")
                .process(new Generator())
                .log("${body}")
                .to("kafka:my_topic?brokers=localhost:9092");
    }
}
