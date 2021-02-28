package com.wzx.leetcode;

public class Leetcode746 {
    public static void main(String[] args) {
        int[] arr = {10, 15, 20};
        System.out.println(minCostClimbingStairs(arr));
    }

    // start from -1, and take no cost
    public static int minCostClimbingStairs(int[] cost) {
        //  cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
        if (cost.length == 1) return cost[0];
        if (cost.length == 2) return Math.min(cost[0], cost[1]);

        int prePre = cost[0];
        int pre = cost[1];
        int cur = 0;

        for (int i = 2; i < cost.length; i++) {
            cur = Math.min(prePre, pre) + cost[i];
            prePre = pre;
            pre = cur;
        }
        return Math.min(prePre, pre);
    }
}
