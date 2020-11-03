package com.wzx.leetcode;

public class Leetcode28 {
    public static void main(String[] args) {
        String haystack = "aaaaaaaaaaaaaaaab";
        String needle = "aaab";
        System.out.println(strStr(haystack, needle));
    }

    public static int strStr(String haystack, String needle) {
        if (needle.equals("")) return 0;
        int[] next = calNext(needle);
        int hayIndex = 0;
        int needIndex = 0;
        int comp = 0;
        while (hayIndex < haystack.length() && needIndex < needle.length()) {
            comp ++;
            if (haystack.charAt(hayIndex) == needle.charAt(needIndex)) {
                hayIndex ++;
                needIndex ++;
            }
            else if (needIndex == 0){
                hayIndex ++;
            }
            else {
                needIndex = next[needIndex-1]+1;
            }
        }
        System.out.println("comp: " + comp);
        if (needIndex == needle.length()) return hayIndex - needle.length();
        return -1;
    }

    public static int[] calNext(String needle) {
        int[] next = new int[needle.length()];
        next[0] = -1;
        for (int i = 1; i < needle.length(); i ++) {
            int temp = next[i-1];
            while (temp != -1) {
                if (needle.charAt(i) == needle.charAt(temp+1)) {
                    next[i] = temp+1;
                    break;
                }
                else temp = next[temp];
            }
            if (temp == -1) {
                next[i] = needle.charAt(i) == needle.charAt(0) ? 0 : -1;
            }
        }


        return next;
    }
}
