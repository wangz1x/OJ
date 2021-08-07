package com.wzx.leetcode;

/**
 * @author wangzx
 * @email wangzx22@163.com
 * @date 2021/6/9 下午5:22
 */
public class Leetcode879 {

    public static void main(String[] args) {
        int[] group = {2,3,5};
        int[] profit = {6,7,8};
        System.out.println(profitableSchemes(10, 5, group, profit));
    }

    /**
     * 任务可以重复做的话
     * @param n
     * @param minProfit
     * @param group
     * @param profit
     * @return
     */
    public static int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        // 哪些是状态?
        // 人数? 盈利?
        //
        int[][][] dp = new int[group.length+1][n+1][minProfit+1];
        dp[0][0][0] = 1;
        // 遍历每个任务
        for (int i = 1; i < group.length+1; i++) {
            // 人数
            for (int j = 0; j < n+1; j++) {
                for (int k = 0; k < minProfit+1; k++) {
                    // 第i个任务没法做
                    dp[i][j][k] = dp[i-1][j][k];
                    // 第i个任务能获得profit[i]的利润
                    // 至少获取k
                    // 那么x+profit[i] >= k
                    // x >= k-profit[i]
                    if (j >= group[i-1]) {
                        dp[i][j][k] += dp[i][j-group[i-1]][Math.max(0, k-profit[i-1])];
                    }
                    dp[i][j][k] %= 1000000007;
                }
            }
        }
        int count = 0;
        for (int i = 0; i < n+1; i++) {
            count += dp[group.length][i][minProfit];
            count %= 1000000007;
        }
        return count;
    }
}
