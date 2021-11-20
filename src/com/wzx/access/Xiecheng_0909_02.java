package com.wzx.access;

import java.util.Scanner;

public class Xiecheng_0909_02 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), k = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        // dp[i][j] 表示前j个元素分为i端，最小的平衡度
        int[] dp_last = new int[n + 1];
        int[] dp_cur = new int[n + 1];

        // 初始化，前n个元素分为1段，平衡度为最大值减最小值
        int min = arr[0], max = arr[0];

        for (int i = 1; i < n+1; i++) {
            min = Math.min(arr[i-1], min);
            max = Math.max(arr[i-1], max);
            dp_last[i] = max - min;
        }

        // 遍历段数
        for (int i = 2; i < k + 1; i++) {
            // 遍历元素长度
            for (int j = i + 1; j < n + 1; j++) {
                // 当前第j个元素，和第几个元素组成一段
                dp_cur[j] = 0x7fffffff;
                min = arr[j-1];
                max = arr[j-1];
                for (int m = j; m > 0; m--) {
                    // m~j 组成一段, 0~m-1是剩下的段
                    min = Math.min(arr[m-1], min);
                    max = Math.max(arr[m-1], max);
                    if (max-min >= dp_cur[j]) break;
                    dp_cur[j] = Math.min(Math.max(max - min, dp_last[m - 1]), dp_cur[j]);
                }
            }
            System.arraycopy(dp_cur, 0, dp_last, 0, n);
        }
        System.out.println(dp_cur[n]);
    }
}
