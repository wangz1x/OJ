package com.wzx.offer;

public class Offer44 {
    public static void main(String[] args) {
        System.out.println(findNthDigit(0x7fffffff));
    }
    public static int findNthDigit(int n) {
        if (n < 10) return n;

        //对应数的位数  1,   2,   3,    4,     5,      6,       7,         8          null
        int[] gaps = {10, 180, 2700, 36000, 450000, 5400000, 63000000, 720000000, 2147483647};

        n = n+1;

        int res = 0;

        for (int i = 0; i < gaps.length; i++) {
            if (n > gaps[i]) {
                n -= gaps[i];
            } else {
                // 数字的位数
                int bits = i+1;

                // 第几个数字
                int num = n/bits + (int)Math.pow(10, i);

                int remainder = n%bits;

                if (remainder == 0) {
                    res = (num-1)%10;          // 前一个数字的最后一位
                } else {
                    // num的第remainder位, 从高位数
                    remainder = bits - remainder+1;
                    while (remainder > 0) {
                        res = num % 10;
                        num /= 10;
                        remainder--;
                    }
                }
                break;
            }
        }
        return res;
    }
}
