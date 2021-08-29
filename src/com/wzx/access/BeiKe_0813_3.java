package com.wzx.access;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BeiKe_0813_3 {

    public static void main(String[] args) {
        int[] a = {0, 0, 0, 0, 0};
        System.out.println(section(a, 0));
    }

    public static long section(int[] a, int t) {
        // write code here
        List<int[]> intervel = new ArrayList<>();

        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if ((a[i] ^ a[j]) == t) {
                    intervel.add(new int[]{i, j});
                }
            }
        }
        intervel.sort((o1, o2) -> {
            if (o1[1] == o2[1]) {
                return o1[0] - o2[0];
            }
            return o1[1] - o2[1];
        });

        int left = 0, right = -1;
        long res = 0L;
        for (int[] inter : intervel) {
            if (left <= inter[0]) {
                right = inter[1] - 1;
                res += calculate(left, right);
                left = inter[0] + 1;
            }
        }
        res += calculate(left, a.length - 1);
        return res;
    }

    public static long calculate(int left, int right) {
        // 从left到right有多少个区间
        long len = right - left + 1L;
        return (1 + len - 1) * (len - 1) / 2;
    }
}
