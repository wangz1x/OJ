package com.wzx.offer;

public class Offer43 {
    public static void main(String[] args) {
//        System.out.println(countDigitOne(532));
        System.out.println(0x7fffffff);
    }

    public static int countDigitOne(int n) {
        int cur = n;
        long unit = 10;
        long sum = 0;

        while (cur != 0) {
            long pre = n / unit;

            long reminder = n % unit;         // 当前位

            sum += (pre * (unit / 10) ) + (reminder < (unit / 10) ? 0 : Math.min(unit / 10, reminder - (unit / 10 - 1)));

            cur /= 10;

            unit *= 10;
        }

        return (int) sum;
    }
}
