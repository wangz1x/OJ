package com.wzx.leetcode;

import java.util.Arrays;

public class Leetcode17$05 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findLongestSubarray(new String[]{"42", "10", "O", "t", "y", "p", "g", "B", "96", "H", "5", "v", "P", "52", "25", "96", "b", "L", "Y", "z", "d", "52", "3", "v", "71", "J", "A", "0", "v", "51", "E", "k", "H", "96", "21", "W", "59", "I", "V", "s", "59", "w", "X", "33", "29", "H", "32", "51", "f", "i", "58", "56", "66", "90", "F", "10", "93", "53", "85", "28", "78", "d", "67", "81", "T", "K", "S", "l", "L", "Z", "j", "5", "R", "b", "44", "R", "h", "B", "30", "63", "z", "75", "60", "m", "61", "a", "5", "S", "Z", "D", "2", "A", "W", "k", "84", "44", "96", "96", "y", "M"})));
    }

    public static String[] findLongestSubarray(String[] array) {
        int charCount = 0;
        int numsCount = 0;

        boolean[] isNum = new boolean[array.length];

        for (int i = 0; i < array.length; i++) {
            if (array[i].matches("[0-9]+")) {
                isNum[i] = true;
                numsCount++;
            } else {
                charCount++;
            }
        }

        if (numsCount == 0 || charCount == 0) return new String[0];

        int visitNum = 0;
        int visitChar = 0;

        int begin = 0;
        int left = 0;
        int maxLen = 0;

        // 只要当前多的那一项，多的部分没有超过少的剩余的部分，就继续往右走
        // 否则左边界就要往右移
        for (int i = 0; i < array.length; i++) {
            if (isNum[i]) {
                visitNum++;
            } else {
                visitChar++;
            }

            if (visitNum == visitChar && 2 * visitNum > maxLen) {
                left = begin;
                maxLen = visitNum * 2;
            }

            while (visitChar - visitNum > numsCount - visitNum) {
                if (isNum[begin++]) {
                    visitNum--;
                    numsCount--;
                } else {
                    visitChar--;
                    charCount--;
                }
            }

            while (visitNum - visitChar > charCount - visitChar) {
                if (isNum[begin++]) {
                    visitNum--;
                    numsCount--;
                } else {
                    visitChar--;
                    charCount--;
                }
            }
        }

        String[] res = new String[maxLen];
        for (int i = left; i < left + maxLen; i++) {
            res[i - left] = array[i];
        }
        return res;
    }
}
