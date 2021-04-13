package com.sobhan.consumer.routes;

import com.sobhan.consumer.services.Calculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;


@Component
public class Processor {

    private static final String KAFKA_TOPIC_NAME = "randomNumber_topic";

    @Autowired
    Calculator calculator;

    @KafkaListener(topics = KAFKA_TOPIC_NAME)
    public void process(String message) {
        calculator.calculate(message);
    }

}
