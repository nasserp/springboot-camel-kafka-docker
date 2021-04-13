package com.sobhan.producer.routes;

import com.sobhan.producer.services.Generator;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component(value = "exchanger")
public class Exchanger implements Processor {

    @Autowired
    Generator generator;

    @Override
    public void process(Exchange exchange) {
        exchange.getMessage().setBody(generator.getRandomNumberInRange());
    }
}


