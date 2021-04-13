package com.sobhan.consumer.routes;

import org.springframework.stereotype.Component;

@Component
public class Endpoint {

    public static String getTimerUrl(String name, int period) {
        return String.format("timer:%s?period=%d", name, period);
    }

}
