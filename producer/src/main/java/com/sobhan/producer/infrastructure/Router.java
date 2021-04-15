package com.sobhan.producer.infrastructure;

import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Router extends RouteBuilder {

    private static final int TIMER_PERIOD = 10000;
    private static final String TIMER_NAME = "producer-timer";
    private static final String KAFKA_TOPIC_NAME = "randomNumber_topic";
    private static final String KAFKA_BROKER_URL = "localhost:9092";

    @Autowired
    @Qualifier(value = "exchanger")
    Processor exchanger;

    @Override
    public void configure() {
        from(Endpoint.getTimerUrl(TIMER_NAME, TIMER_PERIOD))
                .process(exchanger)
                .to(Endpoint.getKafkaUrl(KAFKA_TOPIC_NAME, KAFKA_BROKER_URL));

    }
}
