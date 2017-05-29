package com.gmail.sunnyxxchen;

import static org.junit.Assert.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by schen on 5/25/17.
 */

public class WordMatcherTest {
    @Test
    public void trieConstructionTest() {
        WordMatcher matcher = new WordMatcher();
        assertEquals(351075, matcher.size());
    }

    @Test
    public void trieWordsContainingTest() {
        WordMatcher matcher = new WordMatcher();
        String seq = "jems";
        int count = 0;
        for (CharSequence match : matcher.wordsContaining(seq)) {
            System.out.println(match);
            count += 1;
        }
        assertEquals(count > 0, matcher.contains(seq));
        assertTrue(matcher.isAWord("apple"));
        assertFalse(matcher.isAWord("jems"));
    }

    @Test
    public void playablesTest() {
        WordMatcher matcher = new WordMatcher();
        String seq = "dam";
        List<Character> empty = new ArrayList<>();
        List<Character> cands = new ArrayList<>();
        cands.add('a');
        cands.add('e');
        cands.add('g');
        System.out.println(matcher.playableWords(seq, empty));
        System.out.println(matcher.playableWords(seq, cands));
        cands.add('*');
        System.out.println(matcher.playableWords(seq, cands));
    }
}
