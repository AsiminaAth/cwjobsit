package com.cwjobs.poc;

import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest {
    private Calculator calculator = new Calculator();

    @Test
    public void addReturnsCorrectSumOfTwoNumbers() throws Exception {
        assertEquals(5, calculator.add(2, 3));
    }

    @Test
    public void addReturnsCorrectSumOfAnotherTwoNumbers() throws Exception {
        assertEquals(6, calculator.add(2, 4));
    }
}