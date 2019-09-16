package com.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LongestWordTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void solution() {
        String words = "fun&!! time";
        //assertEquals( "time", new LongestWord().solution(words));
        words = "I love dogs";
        //assertEquals("love", new LongestWord().solution(words));
        words = "this is some sort of sentence";
        assertEquals("sentence", new LongestWord().solution(words));
        words = "123456789 98765432";
        assertEquals("123456789", new LongestWord().solution(words));
        words = "a confusing /:sentence:/[ this is not!!!!!!!~";
        assertEquals("confusing", new LongestWord().solution(words));

    }
}
