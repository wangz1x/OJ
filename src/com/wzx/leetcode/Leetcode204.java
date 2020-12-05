package com.wzx.leetcode;

import java.util.Arrays;

public class Leetcode204 {

    public static void main(String[] args) {
        long a = 3000000*3000000;
        System.out.println(a);
        System.out.println(countPrimes(10));
    }

    public static int countPrimes(int n) {

        byte[] flags = new byte[n+1];
        byte a = 1;
        Arrays.fill(flags, a);
        flags[0] = 0;
        flags[1] = 0;
        int ret = 0;

        for (int i = 2; i< n+1; i ++) {
            if (flags[i] != 0) {
                ret++;
                int j = i+i;
                while (j < n+1) {
                    flags[j] = 0;
                    j += i;
                }
            }
        }
        return ret;
    }
}
