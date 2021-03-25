package com.wzx.leetcode;

public class Leetcode518 {

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        System.out.println(change(10, coins));
    }

    public static int change(int amount, int[] coins) {
        // dfs(amount, coins, 0);
        // return sum;

        // dp 凑出i块的方式
        int[] dp = new int[amount + 1];
        for (int coin : coins) {     // 遍历各种硬币
            dp[coin]++;                 //
            for (int k = 0; k <= amount - coin; k++) {
                dp[k + coin] += dp[k];
            }
        }
        return dp[amount];
    }
}
