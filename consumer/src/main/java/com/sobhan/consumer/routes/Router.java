package com.sobhan.consumer.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class Router extends RouteBuilder {

    private static final int TIMER_PERIOD = 9000;
    private static final String TIMER_NAME = "consumer-timer";

    @Autowired
    Processor processor;

    @Override
    public void configure() {
        from(Endpoint.getTimerUrl(TIMER_NAME, TIMER_PERIOD))
                .bean(processor);
    }
}
