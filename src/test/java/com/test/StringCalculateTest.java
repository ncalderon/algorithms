package com.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StringCalculateTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void stringCalculate() {
        assertEquals("15", StringCalculate.StringCalculate("6*(4/2)+3*1"));
        assertEquals("1600", StringCalculate.StringCalculate("100*2**4"));
        assertEquals("4", StringCalculate.StringCalculate("(4/2)(3-1)"));
        assertEquals("14", StringCalculate.StringCalculate("7-4-1+8(3)/2"));
    }
}

