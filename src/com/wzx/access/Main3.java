package com.wzx.access;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * 从左上角, 到右上角, 要求经过路径和不超过t且最接近t
 */
public class Main3 {
    public static void main(String[] args) {
        int row, col, t;
        try(Scanner scanner = new Scanner(System.in)) {
            row = scanner.nextInt();
            col = scanner.nextInt();
            int[][] times = new int[row][col];
            t = scanner.nextInt();

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    times[i][j] = scanner.nextInt();
                }
            }

            Map<Integer, List<Integer>> map = new HashMap<>();  // key/col,  key%col, 到达该点用时

            for (int i = 1; i < row; i++) {
                times[i][0] += times[i-1][0];
            }

            for (int i = 1; i < col; i++) {
                times[0][i] += times[0][i-1];
            }

            // 从两端开始的话, 如何确定每一端的终点

        }
    }
}
