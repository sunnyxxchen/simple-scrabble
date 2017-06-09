package com.gmail.sunnyxxchen;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by schen on 6/8/17.
 */
public class Player {
    private List<Character> tiles;
    private int score;

    public Player() {
        tiles = new LinkedList<>();
        score = 0;
    }

    void addTile(Character c) {
        if (tiles.size() >= 7) {
            throw new RuntimeException("Too many tiles");
        }
        tiles.add(c);
    }

    void removeTile(Character c) {
        boolean success = tiles.remove(c);
        if (!success) {
            throw new RuntimeException(c + " is not a tile in this player's deck");
        }
    }

    void addScore(int score) {
        this.score += score;
    }

    int getScore() {
        return score;
    }

    List<Character> getTiles() {
        List<Character> copied = new LinkedList<>();
        copied.addAll(tiles);
        return copied;
    }

}
