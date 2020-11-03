package com.wzx.leetcode;

import java.util.Arrays;

public class Leetcode5 {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("ddd"));
    }

    public static String longestPalindrome(String s) {
        int newLen = s.length() * 2 + 1;
        char[] sc = new char[newLen];

        for (int i = 0; i < newLen - 1; i = i + 2) {
            sc[i] = '#';
            sc[i + 1] = s.charAt(i >>> 1);
        }
        sc[newLen - 1] = '#';

        int[] mirrorLen = new int[newLen];
        Arrays.fill(mirrorLen, 0);
        int mid = 0;

        int maxMirror = -1;
        int maxIndex = -1;
        for (int i = 1; i < newLen; i++) {
            if (i < mid + mirrorLen[mid]) {
                if (mirrorLen[2 * mid - i] < mirrorLen[mid] - (i - mid)) {
                    mirrorLen[i] = mirrorLen[2 * mid - i];
                } else {
                    int temp = mirrorLen[mid] - (i - mid) + 1;
                    while (i + temp < newLen && i - temp >= 0 && sc[i + temp] == sc[i - temp]) {
                        temp++;
                    }
                    mirrorLen[i] = temp - 1;
                }
            } else {
                mid = i;
                int temp = 1;
                while (mid + temp < newLen && mid - temp >= 0 && sc[mid + temp] == sc[mid - temp]) {
                    temp++;
                }
                mirrorLen[i] = temp - 1;
            }

            if (mirrorLen[i] > maxMirror) {
                maxMirror = mirrorLen[i];
                maxIndex = i;
            }
        }

        StringBuilder sb = new StringBuilder(2 * maxMirror + 1);
        for (int i = maxIndex - maxMirror; i <= maxIndex + maxMirror; i++) {
            if (sc[i] != '#')
                sb.append(sc[i]);
        }
        System.out.println(sc);
        System.out.println(Arrays.toString(mirrorLen));
        return sb.toString();
    }
}
