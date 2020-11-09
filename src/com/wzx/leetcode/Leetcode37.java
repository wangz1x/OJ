package com.wzx.leetcode;

import java.util.Arrays;

public class Leetcode37 {
    public static void main(String[] args) {
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};

        solveSudoku(board);
    }

    public static void solveSudoku(char[][] board) {
        int[] row = new int[9];
        int[] column = new int[9];
        int[] box = new int[9];

        // collection clue
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int pos = 1 << (board[i][j] - '1');
                    // row[i]&pos like "100110101 & 10000"
                    // if ((row[i]&pos) == pos || (column[j]&pos) == pos || (box[i/3*3+j/3]&pos) == pos) return false;
                    row[i] |= pos;
                    column[j] |= pos;
                    box[i / 3 * 3 + j / 3] |= pos;
                }
            }
        }
        System.out.println(dfs(board, row, column, box, 0, 0));
    }

    public static boolean dfs(char[][] board, int[] row, int[] column, int[] box, int rowStart, int columnStart) {
        // finish
        if (rowStart == 9) {
            System.out.println(Arrays.deepToString(board));
            return true;
        }

        if (board[rowStart][columnStart] == '.') {
            // try 1-9
            for (int k = 0; k < 9; k++) {
                int pos = 1 << k;
                // can fill i
                if (!((row[rowStart] & pos) == pos || (column[columnStart] & pos) == pos || (box[rowStart / 3 * 3 + columnStart / 3] & pos) == pos)) {
                    row[rowStart] |= pos;
                    column[columnStart] |= pos;
                    box[rowStart / 3 * 3 + columnStart / 3] |= pos;
                    board[rowStart][columnStart] = (char) ('1' + k);

                    if (dfs(board, row, column, box, rowStart + (columnStart + 1) / 9, (columnStart + 1) % 9))
                        return true;

                    // back
                    row[rowStart] ^= pos;
                    column[columnStart] ^= pos;
                    box[rowStart / 3 * 3 + columnStart / 3] ^= pos;
//                    board[rowStart][columnStart] = '.';
                }
            }
            // 1-9 all fail.
            return false;
        } else
            // skip [i,j]
            return dfs(board, row, column, box, rowStart + (columnStart + 1) / 9, (columnStart + 1) % 9);
    }
}
