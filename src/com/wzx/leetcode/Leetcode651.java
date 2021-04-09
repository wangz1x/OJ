package com.wzx.leetcode;

public class Leetcode651 {

    public static void main(String[] args) {
        System.out.println(maxA(10));
    }

    public static int maxA(int N) {
        int[] dp = new int[N + 1];
        dp[0] = 0;
        for (int i = 1; i <= N; i++) {
            // 按 A 键
            dp[i] = dp[i - 1] + 1;
            for (int j = 2; j < i; j++) {
                // 在j-2位置开始全选粘贴，后边全部复制，可以复制i-j+1次
                dp[i] = Math.max(dp[i], dp[j - 2] * (i - j + 1));
            }
        }
        // N 次按键之后最多有几个 A？
        return dp[N];
    }
}
