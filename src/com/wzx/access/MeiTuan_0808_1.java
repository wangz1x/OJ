package com.wzx.access;

import java.util.Scanner;

public class MeiTuan_0808_1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int T = in.nextInt();

        for (int i = 0; i < T; i++) {
            int n = in.nextInt();
            int k = in.nextInt();

            // 统计 1~n 出现的次数
            int[] counts = new int[n+1];

            // 输入n个数字
            for (int j = 0; j < n; j++) {
                counts[in.nextInt()]++;
            }


            // 有k个严格小于x，那么从 1~x-1 的计数总数正好等于k
            int sum = 0;
            boolean ok = false;
            for (int j = 0; j < n; j++) {
                sum += counts[j];
                if (sum == k) {
                    ok = true;
                    System.out.println("YES");
                    System.out.println(j+1);
                    break;
                }
            }
            if (!ok) {
                System.out.println("NO");
            }
        }
    }
}
