package com.sobhan.consumer.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.util.ReflectionTestUtils;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    private Calculator calculator;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        calculator=new Calculator();
        ReflectionTestUtils.setField(calculator, "sum", 10);
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    void calculateTest_nullInput() {
        calculator.calculate(null);
        assertEquals("The sum of the recent numbers is 10\n", outputStreamCaptor.toString());
    }
    @Test
    void calculateTest_notNullInput() {
        calculator.calculate("5");
        String sum = Objects.requireNonNull(ReflectionTestUtils.getField(calculator, "sum")).toString();
        assertEquals(sum,"15");
    }
}