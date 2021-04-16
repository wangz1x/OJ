package com.wzx.leetcode;

public class Leetcode1278 {

    public static void main(String[] args) {
        System.out.println(palindromePartition("leetcode", 3));
    }

    public static int palindromePartition(String s, int k) {
        int n = s.length();
        char[] sc = s.toCharArray();
        int[][] memo = new int[n][n];

        // init
        for (int i = 0; i < n; i++) {
            memo[i][i] = 0;
        }

        int end;
        for (int i = 2; i <= n; i++) {        // 长度分别为i子串，变为回文串的最小修改次数
            for (int j = 0; j <= n - i; j++) { // 分别从j起始，长度为i的子串
                end = i + j - 1;
                memo[j][end] = memo[j + 1][end - 1];
                if (sc[j] != sc[end]) {
                    memo[j][end] += 1;
                }
            }
        }

        int[][] dp = new int[n][k + 1];
        int chunk, min;

        for (int i = 0; i < n; i++) {            // 0~i
            chunk = Math.min(i + 1, k);            // 当前长度最多可分的段数

            dp[i][1] = memo[0][i];               // 只分1段
            for (int j = 2; j <= chunk; j++) {      // 分别分成1，2, ... chunk 段
                min = n;
                // 分成1段时, 只能 0~i
                // 分成2段时, 可以 0~0,1~i || 0~1,2~i || 0~2,3~i || ... || 0~i-1,i~i
                // 分成3段时, 可以 0~1,2~i || 0~2,3~i || 0~3,4~i || ... || 0~i-1,i~i
                //              j-1段,1段
                for (int m = j - 1; m <= i; m++) {   //
                    min = Math.min(min, memo[m][i] + dp[m - 1][j - 1]);
                }
                dp[i][j] = min;
            }
        }
        return dp[n - 1][k];
    }
}
