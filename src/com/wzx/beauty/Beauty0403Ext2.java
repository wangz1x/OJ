package com.wzx.beauty;

import java.util.Arrays;

public class Beauty0403Ext2 {
    static int n = 5;
    static int[] caches = new int[2 * n];

    public static void main(String[] args) {
        Arrays.fill(caches, -1);
        caches[0] = caches[1] = caches[2] = 0;
        caches[3] = 1;
        System.out.println(split(n));
        System.out.println(Arrays.toString(caches));
    }

    public static int split(int n) {
        if (caches[n] != -1) {
            return caches[n];
        }

        int ans = 0;
        for (int i = 3; i < n; i++) {
            ans += split(i) * split(n - i + 2);
        }
        ans = ans * n / 2;
        caches[n] = ans;
        return ans;
    }
}
