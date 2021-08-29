package com.wzx.access;

import java.util.Scanner;

public class Net_0828_03 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt(), m = in.nextInt();

        int[] height = new int[n*m];
        for (int i = 0; i < n*m; i++) {
            height[i] = in.nextInt();
        }
        // q次查询
        int q = in.nextInt();

        for (int i = 0; i < q; i++) {
            int l = in.nextInt();
//            System.out.println(deal(height, l));
            System.out.printf("%.4f", deal(height, l));
            System.out.println();
        }
    }

    public static double deal (int[] height, int water) {
        // 最低高度，全是水
        double l = water*1.0/height.length;
        // 最高高度呢？
        int max = 0;
        for (int ele : height) {
            max = Math.max(max, ele);
        }
        double r = max;
        if (max*2.0/3*height.length < water) {
            r += l;
        }
        while (l <= r) {
            // 看高度为mid时，能否满足要求
            double mid = l+(r-l)/2;
            // 计算高度为mid时，能够容纳的水量
            double contain = 0;
            for (int ele : height) {
                // 如果当前高度大于山的高度
                if (mid > ele) {
                    contain += ele*2.0/3 + mid-ele;
                } else {
                    double r1 = (ele-mid)/ele;
                    contain += mid-(mid*(1+Math.pow(r1, 2)+1*r1)/3);
                }
            }

            if (Math.abs(contain-water) < 0.01) {
                return mid;
            } else if (contain < water) {
                l = mid+0.0001;
            } else {
                r = mid-0.0001;
            }
        }
        return (l+r)/2;
    }
}
