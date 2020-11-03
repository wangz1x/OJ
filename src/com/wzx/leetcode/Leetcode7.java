package com.wzx.leetcode;

public class Leetcode7 {
    public static void main(String[] args) {
        System.out.println(reverse(1234567890));
    }

    public static int reverse(int x) {
        if (x == 0x80000000) return 0;
        // 2^31 = 2,147,483,648
        int deal = x;
        if (x < 0) {
            deal = -1*x;
        }

        int res = 0;
        int remainder = 0;
        while (deal != 0) {
            remainder = deal % 10;
            deal /= 10;
            if (res < 214748364 || (res == 214748364 && remainder < 8))
                res = res*10+remainder;
            else
                return 0;
        }
        return x>0 ? res : -1*res;
    }
}
