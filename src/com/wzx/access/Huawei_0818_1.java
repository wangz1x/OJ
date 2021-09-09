package com.wzx.access;

/**
 * 动态规划
 * money n
 * p1, n1, l1
 * p2, n2, l2
 */
public class Huawei_0818_1 {
    public static void main(String[] args) {

        // 状态如何转移
        // 先确定状态数
        // 前i个物品， 一共有n1+n2+n3+...+nn个商品
        int[][] items = {{5, 2, 10}, {2, 4, 3}, {1, 5, 2}, {10, 3, 15},};
        System.out.println(deal(23, 4, items));
        System.out.println(deal1(23, 4, items));

        int[][] items1 = {{5, 10}, {5, 10}, {2, 3}, {2, 3}, {2, 3}, {2, 3}, {1, 2}, {1, 2}, {1, 2}, {1, 2}, {1, 2}, {10, 15}, {10, 15}, {10, 15}};
        System.out.println(deal2(23, 14, items1));
    }

    public static int deal(int money, int n, int[][] items) {
        // 统计一共多少个东西
        int itemSum = 0;
        for (int[] item : items) {
            itemSum += item[1];
        }

        // 前i个商品，只用j能获得的最大欢喜值
        int[][] dp = new int[itemSum + 1][money + 1];

        // 判断当前价格能否购买当前物品，如果可以，两种选择，不可以，一种选择
        // 遍历每种商品
        itemSum = 0;
        for (int i = 0; i < n; i++) {
            // 遍历每种商品的个数
            for (int j = 1; j < items[i][1] + 1; j++) {
                // 当前物品处于总的物品的第几个
                itemSum++;
                // 遍历可用金额
                for (int k = 0; k < money + 1; k++) {
                    if (k >= items[i][0]) {
                        dp[itemSum][k] = Math.max(dp[itemSum - 1][k], dp[itemSum - 1][k - items[i][0]] + items[i][2]);
                    } else {
                        dp[itemSum][k] = dp[itemSum - 1][k];
                    }
                }
            }
        }
        return dp[itemSum][money];
    }

    public static int deal2(int money, int n, int[][] items) {
        // 统计一共多少个东西
        // 前i个商品，只用j能获得的最大欢喜值
        int[][] dp = new int[n + 1][money + 1];

        // 判断当前价格能否购买当前物品，如果可以，两种选择，不可以，一种选择
        // 遍历每种商品
        for (int i = 1; i < n + 1; i++) {
            // 遍历可用金额
            for (int j = 0; j < money + 1; j++) {
                if (j >= items[i-1][0]) {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-items[i-1][0]]+items[i-1][1]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][money];
    }

    public static int deal1(int money, int n, int[][] items) {
        // 直接按钱数dp
        // 花费i可获得的最大喜爱值
        int[][] dp = new int[n+1][money + 1];

        for (int i = 0; i < n; i++){
            for (int j = 0; j <= money; j++){
                for (int k = 0; k <= items[i][1] && k * items[i][0] <= j; k++){
                    dp[i+1][j] = Math.max(dp[i+1][j], dp[i][j-k * items[i][0]] + k * items[i][2]);
                }
            }
        }
        // 遍历花费
//        for (int k = 0; k < money + 1; k++) {
//            // 遍历每种商品
//            for (int i = 0; i < n; i++) {
//                // 遍历商品的个数
//                for (int j = 1; j < items[i][1] + 1; j++) {
//                    if (k >= j * items[i][0]) {
//                        dp[k] = Math.max(dp[k], dp[k - j * items[i][0]] + j * items[i][2]);
//                    }
//                }
//            }
//        }
        return dp[n][money];
    }
}
