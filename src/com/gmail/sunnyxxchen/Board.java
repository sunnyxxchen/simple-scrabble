package com.gmail.sunnyxxchen;

import java.util.ArrayList;
import java.util.List;

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
            throw new TilePlacementException(String.valueOf(col) + " is not a valid column.");
        }
        board[row][col] = letter;
    }

    /**
     * @return
     * Returns all sequences in the board
     */
    List<Sequence> seqFinder() {
        List<Sequence> list = new ArrayList<>();
        list.addAll(horizSeqFinder());
        list.addAll(vertSeqFinder());
        return list;
    }

    private List<Sequence> horizSeqFinder() {
        List<Sequence> list = new ArrayList<>();
        for (int row = 0; row < 15; row++) {
            int index = 0;
            while (index < 15) {
                Character c = board[row][index];
                if (c == null) {
                    index += 1;
                } else {
                    Sequence word = new Sequence(row, index, String.valueOf(c), true);
                    index += 1;
                    while (index < 15 && board[row][index] != null) {
                        word.append(board[row][index]);
                        index += 1;
                    }
                    list.add(word);
                }
            }
        }
        return list;
    }

    private List<Sequence> vertSeqFinder() {
        List<Sequence> list = new ArrayList<>();
        for (int col = 0; col < 15; col++) {
            int index = 0;
            while (index < 15) {
                Character c = board[index][col];
                if (c == null) {
                    index += 1;
                } else {
                    Sequence word = new Sequence(index, col, String.valueOf(c), true);
                    index += 1;
                    while (index < 15 && board[index][col] != null) {
                        word.append(board[index][col]);
                        index += 1;
                    }
                    list.add(word);
                }
            }
        }
        return list;
    }

    void printBoard() {
        System.out.print("   ");
        for (int header = 1; header <= 15; header++) {
            if (header <= 9) {
                System.out.print(" ");
            }
            System.out.print(header);
            System.out.print("|");
        }
        System.out.println();
        for (int row = 0; row < 15; row++) {
            if (row + 1 <= 9) {
                System.out.print(" ");
            }
            System.out.print(row + 1);
            System.out.print("|");
            for (int col = 0; col < 15; col++) {
                Character c = board[row][col];
                if (c != null) {
                    System.out.print(" ");
                    System.out.print(c);
                } else {
                    System.out.print("  ");
                }
                System.out.print("|");
            }
            System.out.println();
        }
    }
}
