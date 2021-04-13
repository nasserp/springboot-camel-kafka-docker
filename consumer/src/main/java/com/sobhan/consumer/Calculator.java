package com.sobhan.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;


@Component
public class Calculator{

    private static int sum;

    @KafkaListener(topics = "my_topic",groupId = "my_group_id")
    public synchronized void getMessage(String message){
        if(message==null){
            System.out.println("sum:" +sum);
            sum=0;
            return;
        }
        sum=sum+Integer.parseInt(message);

    }
}