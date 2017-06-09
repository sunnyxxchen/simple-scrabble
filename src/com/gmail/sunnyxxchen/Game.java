package com.gmail.sunnyxxchen;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by schen on 6/8/17.
 */
public class Game {
    private Board board;
    private WordMatcher wm;
    private Player[] players; //players[0] is player 1, players[1] is player 2
    private Map<Position, String> scoring;
    private Map<Character, Integer> tileCount;
    private Map<Character, Integer> tileVal;

    public Game(boolean isWWF) {
        board = new Board();
        wm = new WordMatcher();
        players = new Player[2];
        if (isWWF) {
            scoring = new HashMap<>();
            tileCount = new HashMap<>();
            tileVal = new HashMap<>();
            // associate positions with scoring values
            scoring.put(new Position(1, 4), "tw");
            scoring.put(new Position(1, 7), "tl");
            scoring.put(new Position(1,  9), "tl");
            scoring.put(new Position(1, 12), "tw");
            scoring.put(new Position(2, 3), "dl");
            scoring.put(new Position(2, 6), "dw");
            scoring.put(new Position(2, 10), "dw");
            scoring.put(new Position(2, 13), "dl");
            scoring.put(new Position(3, 2), "dl");
            scoring.put(new Position(3, 5), "dl");
            scoring.put(new Position(3, 11), "dl");
            scoring.put(new Position(3, 14), "dl");
            scoring.put(new Position(4, 1), "tw");
            scoring.put(new Position(4, 4), "tl");
            scoring.put(new Position(4, 8), "dw");
            scoring.put(new Position(4, 12), "tl");
            scoring.put(new Position(4, 15), "tw");
            scoring.put(new Position(5, 3), "dl");
            scoring.put(new Position(5, 7), "dl");
            scoring.put(new Position(5, 9), "dl");
            scoring.put(new Position(5, 13), "dl");
            scoring.put(new Position(6, 2), "dw");
            scoring.put(new Position(6, 6), "tl");
            scoring.put(new Position(6, 10), "tl");
            scoring.put(new Position(6, 14), "dw");
            scoring.put(new Position(7, 1), "tl");
            scoring.put(new Position(7, 5), "dl");
            scoring.put(new Position(7, 11), "dl");
            scoring.put(new Position(7, 15), "tl");
            scoring.put(new Position(8, 4), "dw");
            scoring.put(new Position(8, 8), "dw");
            scoring.put(new Position(8, 12), "dw");
            scoring.put(new Position(9, 1), "tl");
            scoring.put(new Position(9, 5), "dl");
            scoring.put(new Position(9, 11), "dl");
            scoring.put(new Position(9, 15), "tl");
            scoring.put(new Position(10, 2), "dw");
            scoring.put(new Position(10, 6), "tl");
            scoring.put(new Position(10,  10), "tl");
            scoring.put(new Position(10, 14), "dw");
            scoring.put(new Position(11, 3), "dl");
            scoring.put(new Position(11, 7), "dl");
            scoring.put(new Position(11, 9), "dl");
            scoring.put(new Position(11, 14), "dl");
            scoring.put(new Position(12, 1), "tw");
            scoring.put(new Position(12, 4), "tl");
            scoring.put(new Position(12, 8), "dw");
            scoring.put(new Position(12, 12), "tl");
            scoring.put(new Position(12, 15), "tw");
            scoring.put(new Position(13, 2), "dl");
            scoring.put(new Position(13, 5), "dl");
            scoring.put(new Position(13, 11), "dl");
            scoring.put(new Position(13, 14), "dl");
            scoring.put(new Position(14, 3), "dl");
            scoring.put(new Position(14, 6), "dw");
            scoring.put(new Position(14, 10), "dw");
            scoring.put(new Position(14, 13), "dl");
            scoring.put(new Position(15, 4), "tw");
            scoring.put(new Position(15, 7), "tl");
            scoring.put(new Position(15, 9), "tl");
            scoring.put(new Position(15, 12), "tw");

            // start out with initial tile counts
            tileCount.put('k', 1);
            tileCount.put('x', 1);
            tileCount.put('j', 1);
            tileCount.put('q', 1);
            tileCount.put('z', 1);
            tileCount.put('*', 2);
            tileCount.put('y', 2);
            tileCount.put('b', 2);
            tileCount.put('c', 2);
            tileCount.put('f', 2);
            tileCount.put('m', 2);
            tileCount.put('p', 2);
            tileCount.put('w', 2);
            tileCount.put('v', 2);
            tileCount.put('g', 3);
            tileCount.put('l', 4);
            tileCount.put('u', 4);
            tileCount.put('h', 4);
            tileCount.put('s', 5);
            tileCount.put('d', 5);
            tileCount.put('n', 5);
            tileCount.put('r', 6);
            tileCount.put('t', 7);
            tileCount.put('i', 8);
            tileCount.put('o', 8);
            tileCount.put('a', 9);
            tileCount.put('e', 13);

            // associate tiles with point values;
            tileVal.put('*', 0);
            tileVal.put('s', 1);
            tileVal.put('r', 1);
            tileVal.put('t', 1);
            tileVal.put('i', 1);
            tileVal.put('o', 1);
            tileVal.put('a', 1);
            tileVal.put('e', 1);
            tileVal.put('l', 2);
            tileVal.put('u', 2);
            tileVal.put('d', 2);
            tileVal.put('n', 2);
            tileVal.put('y', 3);
            tileVal.put('g', 3);
            tileVal.put('h', 3);
            tileVal.put('b', 4);
            tileVal.put('c', 4);
            tileVal.put('f', 4);
            tileVal.put('m', 4);
            tileVal.put('p', 4);
            tileVal.put('w', 4);
            tileVal.put('k', 5);
            tileVal.put('v', 5);
            tileVal.put('x', 8);
            tileVal.put('j', 10);
            tileVal.put('q', 10);
            tileVal.put('z', 10);
        } else {
            throw new RuntimeException("scrabble rules not implemented yet");
        }
    }


}
