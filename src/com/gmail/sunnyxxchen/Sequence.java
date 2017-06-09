package com.gmail.sunnyxxchen;

/**
 * Created by schen on 6/8/17.
 * Sequence objects associate a character sequence with a position on the board.
 * The position corresponds to the position of the uppermost, leftmost tile in the sequence.
 * The position is zero-indexed, unlike the board.
 */
public class Sequence {
    private int row;
    private int col;
    private String sequence;
    private boolean isHoriz;

    public Sequence(int r, int c, String seq, boolean isHoriz) {
        row = r;
        col = c;
        sequence = seq;
        this.isHoriz = isHoriz;
    }

    void append(Character c) {
        sequence += c;
    }

    int getRow() {
        return row;
    }

    int getCol() {
        return col;
    }

    String getSeq() {
        return sequence;
    }

    boolean isHoriz() {
        return isHoriz;
    }

    public String toString() {
        return String.valueOf(getRow()) + " " + String.valueOf(getCol()) + " " + getSeq();
    }
}
