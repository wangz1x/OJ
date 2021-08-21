package com.wzx.leetcode;

/**
 * @author wangzx
 * email wangzx22@163.com
 * date 2021/8/15 下午6:57
 */
public class Leetcode122 {

    public static void main(String[] args) {
        int[] a = {1,2,4,2,5,7,2,4,9,0};
        System.out.println(maxProfit(a));
    }

    public static int maxProfit(int[] prices) {
        int curMin = 0x7fffffff, profit = 0, curMax = 0;
        for (int price : prices) {
            if (price < curMin) {
                if (curMax > curMin) {
                    profit += curMax - curMin;
                    curMax = 0;
                }
                curMin = price;
            } else if (price > curMax) {
                curMax = price;
            } else {
                profit += curMax-curMin;
                curMin = price;
                curMax = 0;
            }
        }
        return profit;
    }
}
