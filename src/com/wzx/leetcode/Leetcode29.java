package com.wzx.leetcode;

public class Leetcode29 {
    public static void main(String[] args) {
        System.out.println(divide(0x80000000, -2));
        System.out.println(0x80000000);
    }

    public static int divide(int dividend, int divisor) {
        if (divisor == 1) return dividend;
        if (divisor == -1) return dividend == 0x80000000 ? 0x7fffffff : -dividend;
        if (dividend == 0) return 0;

        int sign = -1;
        if ((dividend < 0 && divisor < 0) || (dividend > 0 && divisor > 0)) sign = 1;

        dividend = dividend < 0 ? dividend : -dividend;
        divisor = divisor < 0 ? divisor : -divisor;

        return sign == -1 ? -dfs(dividend, divisor) : dfs(dividend, divisor);
    }

    public static int dfs(int dividend, int divisor) {
        int count = 0;
        if (dividend <= divisor) {
            int tempDivisor = divisor;
            count = 1;
            while (tempDivisor >= 0xc0000000 && dividend <= tempDivisor+tempDivisor) {
                tempDivisor = tempDivisor+tempDivisor;
                count += count;
            }
            if (tempDivisor != dividend) {
                count += dfs(dividend-tempDivisor, divisor);
            }
        }
        return count;
    }
}
