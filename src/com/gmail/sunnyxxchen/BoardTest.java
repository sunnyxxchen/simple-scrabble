package com.gmail.sunnyxxchen;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Created by schen on 6/8/17.
 */
public class BoardTest {

    @Test
    public void test() {
        Board b = new Board();
        b.placeLetter('a', 5, 5);
        b.placeLetter('p', 5, 6);
        b.placeLetter('p', 5, 7);
        b.placeLetter('l', 5, 8);
        b.placeLetter('e', 5, 9);
        b.placeLetter('e', 6, 6);
        b.placeLetter('n', 7, 6);
        b.placeLetter('i', 8, 6);
        b.placeLetter('s', 9, 6);
        b.printBoard();

        System.out.println(b.seqFinder());
    }

}
