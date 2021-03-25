package com.wzx.leetcode;

public class Leetcode72 {

    public static void main(String[] args) {
        System.out.println(minDistance("horse", "ros"));
    }

    public static int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m+1][n+1];

        // word1的前i个字符转换成word2的前j个字符需要的最少操作数
        for (int i = 0; i < m; i++) {
            dp[i][0] = i;     // 有一个删一个
        }

        for (int i = 0; i < n; i++) {
            dp[0][i] = i;     // 缺一个补一个
        }

        for (int i = 1; i < m; i++) {
            char w1c = word1.charAt(i);
            for (int j = 1; j < n; j++) {
                char w2c = word2.charAt(j);

                if (w1c == w2c) {             // 如果两者相等
                    dp[i][j] = dp[i-1][j-1];
                } else {                      // 两者不等
                    // 可以替换，可以删除，可以增加
                    dp[i][j] = Math.min(Math.min(dp[i-1][j-1], dp[i-1][j]), dp[i][j-1]) + 1;
                }
            }
        }
        return dp[m][n];
    }
}
