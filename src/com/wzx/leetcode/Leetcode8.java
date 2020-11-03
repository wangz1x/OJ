package com.wzx.leetcode;

public class Leetcode8 {
    public static void main(String[] args) {
        System.out.println(myAtoi("       9223372036854775808"));
    }


    public static int myAtoi(String s) {
        s = s.trim();
        if (s.length() == 0) {
            return 0;
        }
        char begin = s.charAt(0);
        boolean positive;
        long res = 0L;
        if (begin == '+') {
            positive = true;
        }
        else if (begin == '-') {
            positive = false;
        }
        else if (begin <= 57 && begin >= 48) {
            positive = true;
            res += begin-48;
        }
        else {
            return 0;
        }

        int i = 1;
        while (i < s.length() && s.charAt(i) <= 57 && s.charAt(i) >= 48) {
            if (res > Integer.MAX_VALUE)
                break;
            res = res*10 + s.charAt(i) - 48;
            i ++;
        }

        return positive ? (res < 0x7fffffff ? (int)res : 0x7fffffff) : (res > 0x7fffffff ? 0x80000000 : -1*(int)res);
    }
}
