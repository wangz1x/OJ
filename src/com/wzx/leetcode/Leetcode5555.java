package com.wzx.leetcode;

public class Leetcode5555 {
    public static void main(String[] args) {
        System.out.println(countVowelStrings(33));
    }

    public static int countVowelStrings(int n) {
        if (n == 0) return 0;
        if (n == 1) return 5;
        int res = 0;
        int[] count = {1,1,1,1,1};
        for (int i = 1; i < n; i ++) {
            count[0] = count[0] + count[1] + count[2] + count[3] + count[4];
            count[1] = count[1] + count[2] + count[3] + count[4];
            count[2] = count[2] + count[3] + count[4];
            count[3] = count[3] + count[4];
            count[4] = count[4];
        }

        return count[0] + count[1] + count[2] + count[3] + count[4];
    }
}
