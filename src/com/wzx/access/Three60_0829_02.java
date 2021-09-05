package com.wzx.access;

import java.util.Scanner;

public class Three60_0829_02 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 输入数据
        int n = in.nextInt(), m = in.nextInt(), x = in.nextInt(), k = in.nextInt();
        // 数组
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        // 差分数组
        int[] diff = new int[n];
        diff[0] = arr[0];
        for (int i = 1; i < n; i++) {
            diff[i] = arr[i] - arr[i - 1];
        }

        // 看把buff放在哪里
        for (int i = 0; i < m; i++) {
            // 最小值
            int min = 0x7fffffff, idx = -1;
            for (int j = 0; j < n; j++) {
                // 说明 j小于j-1，那么这就可能是个瓶颈
                // 但如果有多个负的，又只有一个增益，不就应该优先对最查的进行增益吗
                if (arr[j] < min) {
                    min = arr[j];
                    idx = j;
                }
            }

        }

    }
}
