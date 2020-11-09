package com.wzx.leetcode;

import java.util.Arrays;

public class Leetcode36 {
    public static void main(String[] args) {
        char[][] board = {
                {'8', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        System.out.println(isValidSudoku(board));
    }

    public static boolean isValidSudoku(char[][] board) {
        int[] row = new int[9];
        int[] column = new int[9];
        int[] box = new int[9];

        for (int i = 0; i < 9; i ++) {
            for (int j = 0; j < 9; j ++) {
                if (board[i][j] != '.') {
                    int pos = 1<<(board[i][j]-'1');

                    if ((row[i]&pos) == pos || (column[j]&pos) == pos || (box[i/3*3+j/3]&pos) == pos) return false;
                    row[i] |= pos;
                    column[j] |= pos;
                    box[i/3*3+j/3] |= pos;
                }
            }
        }
        return true;
    }
}
