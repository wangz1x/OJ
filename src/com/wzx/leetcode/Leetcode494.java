package com.wzx.leetcode;

public class Leetcode494 {
    static int choices = 0;

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 0, 0};
        System.out.println(findTargetSumWays(nums, 3));
    }

    public static int findTargetSumWays(int[] nums, int S) {
        int min=0, max=0, count0=0;
        for (int i = 0; i<nums.length; i++) {
            min -= nums[i];
            max += nums[i];
            if (nums[i] == 0) {
                count0++;
            }
        }
        if (S < min || S > max) return 0;
        if (S == min || S == max) return 1+(int)(Math.pow(2, count0)-1);

        int[][] dp = new int[nums.length+1][max-min+1];
        dp[0][-min] = 1;

        for(int i = 1; i < nums.length+1; i++) {
            for (int j = min; j <= max; j++) {           // min ~ max
                if (j-nums[i-1] >= min && j-nums[i-1] <= max && j+nums[i-1] >= min && j+nums[i-1] <= max) {
                    dp[i][j-min] = dp[i-1][j-nums[i-1]-min]+dp[i-1][j+nums[i-1]-min];
                }
            }
        }
        return dp[nums.length][S-min]+(int)(Math.pow(2, count0)-1);
    }
}
