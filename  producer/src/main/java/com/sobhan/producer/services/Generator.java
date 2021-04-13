package com.sobhan.producer.services;

import org.springframework.stereotype.Service;


import java.util.Random;

@Service
public class Generator {

    private static final int MIN = 0;
    private static final int MAX = 100;

    public int getRandomNumberInRange() {
        return new Random().nextInt((MAX - MIN) + 1) + MIN;
    }

}


