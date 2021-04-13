package com.sobhan.producer;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


import java.util.Random;

@Component
public class Generator  implements Processor {

    private static final int MIN = 0;
    private static final int MAX = 100;

    private int getRandomNumberInRange() {
        return new Random().nextInt((MAX - MIN) + 1) + MIN;
    }

    @Override
    public void process(Exchange exchange) {
        exchange.getMessage().setBody(getRandomNumberInRange());
    }
}
