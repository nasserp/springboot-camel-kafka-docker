package com.sobhan.producer.infrastructure;

import org.springframework.stereotype.Component;

@Component
public class Endpoint {

    public static String getKafkaUrl(String topicName, String brokerUrl) {
        return String.format("kafka:%s?brokers=%s", topicName, brokerUrl);
    }

    public static String getTimerUrl(String name, int period) {
        return String.format("timer:%s?period=%d", name, period);
    }

}
