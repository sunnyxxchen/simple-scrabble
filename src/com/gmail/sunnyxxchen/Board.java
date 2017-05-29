package com.gmail.sunnyxxchen;

/**
 * Created by schen on 5/26/17.
 */
public class Board {
    private Character[][] board;

    /**
     * Initializes empty board. Rows and columns are 1-indexed.
     */
    Board() {
        board = new Character[15][15];
    }

    /**
     * Places a letter on the board. Throws an exception if a letter is already there or if the indices exceed board dimensions.
     * @param letter
     * @param row
     * @param col
     */
    void placeLetter(Character letter, int row, int col) {
        row -= 1;
        col -= 1;
        if (board[row][col] != null) {
            throw new TilePlacementException("There is already a tile at that position");
        } else if (row > 15 || row < 0) {
            throw new TilePlacementException(String.valueOf(row) + " is not a valid row.");
        } else if (col > 15 || col < 0) {
            throw new TilePlacementException(String.valueOf(col) + " is not a valid row.");
        }
        board[row][col] = letter;
    }
}
