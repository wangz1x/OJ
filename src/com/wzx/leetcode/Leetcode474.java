package com.wzx.leetcode;

public class Leetcode474 {
    public static void main(String[] args) {
        String[] strs = new String[]{"10", "0001", "111001", "1", "0"};
        System.out.println(findMaxForm(strs, 5, 3));
    }

    public static int findMaxForm(String[] strs, int m, int n) {
        int[][] count = new int[strs.length][2];

        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            for (int j = 0; j < str.length(); j++) {
                count[i][str.charAt(j) - '0']++;
            }
        }

        // dp[j][k] : 前i个串中，由j个0，k个1 组成的最大子集
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i < strs.length; i++) {
            for (int j = m; j >= 0; j--) {
                for (int k = n; k >= 0; k--) {
                    // 先看第i个串能不能放下
                    if (count[i][0] <= j && count[i][1] <= k) {
                        // 再看要不要放第i个串
                        dp[j][k] = Math.max(dp[j][k], 1 + dp[j - count[i][0]][k - count[i][1]]);
                    }
                }
            }
        }
        return dp[m][n];
    }
}
