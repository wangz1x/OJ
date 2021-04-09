package com.wzx.leetcode;

public class Leetcode877 {
    public static void main(String[] args) {
        System.out.println(stoneGame(new int[]{3,2,10,4}));
    }

    public static boolean stoneGame(int[] piles) {
        // return true;

        // dp[i][j][0]/dp[i][j][1] 分别表示在i到j这一段，先后手分别能取得的最多石头
        int[][][] dp = new int[piles.length][piles.length][2];

        // initialize
        for (int i = 0; i < piles.length; i++) {
            dp[i][i][0] = piles[i];
        }

        // 0-0, 1-1, 2-2, 3-3, 4-4
        // 0-1, 1-2, 2-3, 3-4
        // 0-2, 1-3, 2-4
        // 0-3, 1-4
        // 0-4
        for (int i = 1; i < piles.length; i++) {   // 间隔，从1开始，到
            for (int j = 0; j < piles.length-i; j++) {          // 起始位置
                // j~j+i区间，先手取，可以取j，剩j+1~j+i || 或者取j+i, 剩 j~j+i-1
                if (piles[j]+dp[j+1][j+i][1] > piles[j+i]+dp[j][j+i-1][1]) {
                    dp[j][j+i][0] = piles[j]+dp[j+1][j+i][1];
                    dp[j][j+i][1] = dp[j+1][j+i][0];               // 只能取剩余区间的先手
                } else {
                    dp[j][j+i][0] = piles[j+i]+dp[j][j+i-1][1];
                    dp[j][j+i][1] = dp[j][j+i-1][0];               // 只能取剩余区间的先手
                }
            }
        }
        return dp[0][piles.length-1][0] > dp[0][piles.length-1][1];     // 先手取得数量是否大于后手数量
    }
}
