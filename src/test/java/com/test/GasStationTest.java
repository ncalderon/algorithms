package com.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GasStationTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void gasStation() {
        assertEquals("1", GasStation.GasStation(new String[] {"4","3:1","2:2","1:2","0:1"}));
        assertEquals("impossible", GasStation.GasStation(new String[] {"4","1:1","2:2","1:2","0:1"}));
        assertEquals("4", GasStation.GasStation(new String[] {"4","0:1","2:2","1:2","3:1"}));
        assertEquals("3", GasStation.GasStation(new String[] {"5","3:3","1:2","2:2","3:2","4:3"}));
    }
}
