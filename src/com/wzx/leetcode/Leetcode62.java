package com.wzx.leetcode;

public class Leetcode62 {
    public static void main(String[] args) {
        long a = 1;
        for (int i = 1; i < 70; i ++)
            System.out.println(a=a*i);
    }

    public static int fac(int n, int m) {
        long up = 1;
        for (int i = m+n-2; i > m-1; i --) {
            up *= i;
        }

        long low = 1;
        for (int i=n-1; i > 0; i --) {
            low *= i;
        }

        return (int) (up/low);
    }
}
