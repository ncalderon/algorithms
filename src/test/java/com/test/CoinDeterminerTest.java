package com.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CoinDeterminerTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void coinDeterminer() {
        //assertEquals(2, new CoinDeterminer().coinDeterminer(22));
        //assertEquals(3, new CoinDeterminer().coinDeterminer(25));
        //assertEquals(22, new CoinDeterminer().coinDeterminer(242));
        assertEquals(2, new CoinDeterminer().coinDeterminer(6));
    }
}
