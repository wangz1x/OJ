package com.wzx.leetcode;

import java.util.Arrays;

public class Leetcode85 {
    public static void main(String[] args) {
        char[][] matrix = {{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};
        Leetcode85 l = new Leetcode85();
        System.out.println(l.maximalRectangle(matrix));
    }

    public int maximalRectangle(char[][] matrix) {
        int rows = matrix.length;
        if (rows == 0) return 0;
        int cols = matrix[0].length;
        if (cols == 0) return 0;

        int max = 0;

        for (int i = 0; i < rows; i ++) {
            char[] curRow = new char[cols];
            Arrays.fill(curRow, '1');

            for (int j = i; j < rows; j ++) {
                curRow = and(curRow, matrix[j]);
                int heigth = j-i+1;
                int width = calWidth(curRow);
                max = Math.max(max, heigth*width);
            }
        }
        return max;
    }

    public char[] and(char[] char1, char[] char2) {
        for (int i = 0; i < char1.length; i++) {
            if (char1[i] == '0' || char2[i] == '0') {
                char1[i] = '0';
            }
        }
        return char1;
    }

    public int calWidth(char[] matrixRow) {
        int width = 0;
        int cont = 0;
        for (char c : matrixRow) {
            if (c == '1') cont ++;
            else {
                width = Math.max(width, cont);
                cont = 0;
            }
        }
        return Math.max(width, cont);
    }
}
