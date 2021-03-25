package com.wzx.leetcode;

import java.util.Arrays;

public class Leetcode354 {
    public static void main(String[] args) {
        int[][] arr = {{1, 3}, {3, 5}, {6, 7}, {6, 8}, {8, 4}, {9, 5}};
        Arrays.sort(arr, (ele1, ele2) -> ele1[0] == ele2[0] ? ele1[1] - ele2[1] : ele1[0] - ele2[0]);
        System.out.println(maxEnvelopes(arr));
    }

    public static int maxEnvelopes(int[][] envelopes) {
        if (envelopes.length <= 1) return envelopes.length;

        Arrays.sort(envelopes, (ele1, ele2) -> ele1[0] == ele2[0] ? ele1[1]-ele2[1] : ele1[0]-ele2[0]);

        // dp 思路
        // 确保能被 x,y 包含的信封，全都出现在 x,y 之前；但是不保证出现在前边的一定能装
        // dp[i] 表示从0到i 能嵌套的信封的最大值

        int n = envelopes.length;
        int[] dp = new int[n+1];

        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i<n+1; i++) {
            int x = envelopes[i-1][0];
            int y = envelopes[i-1][1];
            int max = 0;
            for (int j = 1; j < i; j++) {
                if (envelopes[j-1][0] < x && envelopes[j-1][1] < y) {  // 看是否能装
                    max = Math.max(max, dp[j]);
                }
            }
            dp[i] = max+1;
        }
        return dp[n];
    }
}
