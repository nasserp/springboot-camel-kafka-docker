package com.sobhan.consumer.services;

import org.springframework.stereotype.Service;


@Service
public class Calculator {

    private int sum;

    public void calculate(String message) {
        if (message == null) {
            System.out.println("The sum of the recent numbers is " + sum);
            sum = 0;
            return;
        }
        sum = sum + Integer.parseInt(message);
    }

}
