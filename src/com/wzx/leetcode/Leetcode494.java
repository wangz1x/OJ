package com.wzx.leetcode;

public class Leetcode494 {
    static int choices = 0;

    public static void main(String[] args) {
        int[] nums = {1, 1, 1};
        System.out.println(findTargetSumWays2(nums, 2));
    }

    public static int findTargetSumWays(int[] nums, int S) {
        int min=0, max=0, count0=0;
        for (int num : nums) {
            min -= num;
            max += num;
            if (num == 0) {
                count0++;
            }
        }
        if (S < min || S > max) {
            return 0;
        }
        if (S == min || S == max) {
            return 1+(int)(Math.pow(2, count0)-1);
        }

        int[][] dp = new int[nums.length+1][max-min+1];
        dp[0][-min] = 1;

        for(int i = 1; i < nums.length+1; i++) {
            // min ~ max
            for (int j = min; j <= max; j++) {
                if (j-nums[i-1] >= min && j-nums[i-1] <= max && j+nums[i-1] >= min && j+nums[i-1] <= max) {
                    dp[i][j-min] = dp[i-1][j-nums[i-1]-min]+dp[i-1][j+nums[i-1]-min];
                }
            }
        }
        return dp[nums.length][S-min]+(int)(Math.pow(2, count0)-1);
    }

    public static int findTargetSumWays2(int[] nums, int S) {

        // 能否改成1维的
        int min=0, max=0, count0=0;
        for (int i = 0; i<nums.length; i++) {
            min -= nums[i];
            max += nums[i];
            if (nums[i] == 0) {
                count0++;
            }
        }

        // 无法凑出S
        if (S < min || S > max) return 0;

        // 刚好为S，看里边有多少个0, 每个0可选可不选
        if (S == min || S == max) return (int)(Math.pow(2, count0));

        // 从min到max一共有max-min+1个数
        // 前i个数和为j的方式  dp[i][j]
        int[] dp = new int[max-min+1];
        // 前0个数凑出0的方式只有1种
        dp[-min] = 1;

        // 遍历所有的数字
        for(int i = 1; i < nums.length+1; i++) {
            // 遍历和的可能
            for (int j = min; j <= max; j++) {
                // 其实当前遍历的是 nums[i-1]个数字
                // 前i-1个数字凑成j-nums[i-1]，再加上第i个数字可以凑出j
                if (j-nums[i-1] >= min && j-nums[i-1] <= max) {
                    dp[j-min] += dp[j-nums[i-1]-min];
                }
                // 前i-1个数字凑成j+nums[i-1], 在减去第i个数字凑成j
                if (j+nums[i-1] >= min && j+nums[i-1] <= max) {
                    dp[j-min] += dp[j+nums[i-1]-min];
                }
            }
        }

        // 因为dp[i][0]表示前i个数和为min的方式数
        // 则前i个数和为S的方式数应该是 dp[i][S-min];
        return dp[S-min];
    }
}
