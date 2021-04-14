package com.sobhan.producer.services;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.util.ReflectionTestUtils;


import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;


class GeneratorTest {

    private Generator generator;

    @BeforeEach
    void setUp() {
        generator = new Generator();
    }

    @Test
    void testGetRandomNumberInRange() {
        int max = Integer.parseInt(Objects.requireNonNull(ReflectionTestUtils.getField(generator, "MAX")).toString());
        int min = Integer.parseInt(Objects.requireNonNull(ReflectionTestUtils.getField(generator, "MIN")).toString());
        int result = generator.getRandomNumberInRange();
        assertTrue(result < max && result > min);
    }

}