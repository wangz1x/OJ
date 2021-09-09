package com.wzx.access;

import java.util.Scanner;

public class Huawei_0825_01 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] matrix = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = in.nextInt();
            }
        }
        int max = deal(matrix, n);
        System.out.println(max);
    }

    public static int deal (int[][] matrix, int n) {

        int[] dp = new int[n];
        int sum, max = 0x80000000;

        // 假设从第i行开始
        for (int i = 0; i < n; i++) {
            // 初始化每列的和
            for (int j = 0; j < n; j++) {
                dp[j] = 0;
            }
            // 以第i行为上边界组成的矩阵
            for (int j = i; j < n; j++) {
                sum = 0;
                for (int k = 0; k < n; k++) {
                    dp[k] += matrix[j][k];
                    if (sum > 0) {
                        sum += dp[k];
                    } else {
                        sum = dp[k];
                    }
                    max = Math.max(sum, max);
                }
            }
        }
        return max;
    }
}
