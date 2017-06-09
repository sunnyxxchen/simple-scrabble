package com.gmail.sunnyxxchen;

/**
 * Created by schen on 6/8/17.
 */
public class Position {
    private int row;
    private int col;

    public Position(int row, int col) {
        this.row = row;
        this.col = col;
        if (row < 1 || row > 15 || col < 1 || col > 15) {
            throw new RuntimeException("position invalid");
        }
    }

    public int row() {
        return row;
    }

    public int col() {
        return col;
    }

    public boolean equals(Object o) {
        if (!(o.getClass() == this.getClass())) {
            return false;
        }
        Position pos = (Position) o;
        return (pos.row() == row && pos.col() == col);
    }

    public int hashCode() {
        return row * 15 + col;
    }
}
