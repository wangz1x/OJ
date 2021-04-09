package com.wzx.leetcode;

import java.util.Arrays;

public class Leetcode54 {
    public static void main(String[] args) {
        int[][] ma = new int[][] {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}};
        System.out.println(Arrays.toString(spiralOrder(ma)));
    }

    public static int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0) return new int[]{};

        int x = 0, y = 0;
        int rowl = 0, rowr = matrix[0].length-1, colu = 0, cold = matrix.length-1;

        int[] res = new int[matrix.length * matrix[0].length];
        int idx = 0;

        while (x >= colu && x <= cold && y >= rowl && y <= rowr ) {
            // row ->
            while (y <= rowr) {
                res[idx++] = matrix[x][y++];
            }
            colu++;
            x++;
            y--;

            // col |
            //     V
            while (x <= cold) {
                res[idx++] = matrix[x++][y];
            }
            rowr--;
            x--;
            y--;

            // row <-
            while (y >= rowl) {
                res[idx++] = matrix[x][y--];
            }
            cold--;
            y++;
            x--;

            // col ^
            //     |
            while (x >= colu) {
                res[idx++] = matrix[x--][y];
            }
            rowl++;
            x++;
            y++;
        }
        return res;
    }
}
