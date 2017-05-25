package com.gmail.sunnyxxchen;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Created by schen on 5/25/17.
 */

public class WordMatcherTest {
    @Test
    public void trieConstructionTest() {
        WordMatcher matcher = new WordMatcher();
        assertEquals(351075, matcher.size());
    }
}
