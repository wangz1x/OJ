package com.wzx.access;

import java.util.Scanner;

public class Main17 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int k = scanner.nextInt();

        int[] as = new int[n];
        for (int i = 0; i < n; i++) {
            as[i] = scanner.nextInt();
        }

        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            if (as[i] > k) {
                dp[i][i] = 1;
            } else {
                dp[i][i] = -1;
            }
        }

        int max = 0;
        for (int i = n-1; i >= 0; i--) {   // start
            for (int j = i+1; j < n; j++) {  // end
                dp[i][j] = dp[i][j-1] + dp[j][j];
                if (dp[i][j] > 0 && j-i+1 > max) {
                    max = j-i+1;
                }
            }
        }
        System.out.println(max);
    }
}
