package com.wzx.leetcode;

public class Leetcode87 {
    public static void main(String[] args) {
        String s1 = "re";
        String s2 = "er";
        System.out.println(isScramble(s1, s2));
    }

    static int[][][] memo;

    public static boolean isScramble(String s1, String s2) {

        memo = new int[s1.length()][s2.length()][s1.length()+1];       // 最后一个表示匹配的长度，最长为s1.length(),

        return recurse(s1, s2, 0, 0, s1.length());
    }

    public static boolean recurse(String s1, String s2, int idx1, int idx2, int len) {
        if (memo[idx1][idx2][len] != 0) {    // 0表示还没访问过这种情况
            return memo[idx1][idx2][len] == 1;
        }

        if (s1.substring(idx1, idx1+len).equals(s2.substring(idx2, idx2+len))) {
            memo[idx1][idx2][len] = 1;
            return true;
        }

        int[] counts = new int[26];
        for (int i = idx1, j=idx2; i < idx1+len && j < idx2+len; i++, j++) {
            counts[s1.charAt(i)-'a']++;
            counts[s2.charAt(j)-'a']--;
        }
        for (int count : counts) {
            if (count != 0) {
                memo[idx1][idx2][len] = -1;         // false
                return false;
            }
        }

        for (int i = 1; i < len; i++) {             // 长度只有len,
            // if contains the same characters
            if (recurse(s1, s2, idx1, idx2, i) && recurse(s1, s2, idx1+i, idx2+i, len-i)) {
                memo[idx1][idx2][len] = 1;
                return true;
            }

            if (recurse(s1, s2, idx1, idx2+len-i, i) && recurse(s1, s2, idx1+i, idx2, len-i)) {
                memo[idx1][idx2][len] = 1;
                return true;
            }
        }
        memo[idx1][idx2][len] = -1;
        return false;
    }

//    public static boolean isScramble(String s1, String s2) {
//        if (s1.equals(s2)) return true;
//        if (s1.length() == 1) return false;
//
//        for (int i = 1; i < s1.length(); i++) {
//            String temp1 = s1.substring(0, i);
//            String temp2 = s1.substring(i);
//
//            String temp3 = s2.substring(0, i);
//            String temp4 = s2.substring(i);
//
//            String temp5 = s2.substring(s2.length()-i);
//            String temp6 = s2.substring(0, s2.length()-i);
//            // if contains the same characters
//            if (count(temp1, temp3) && count(temp2, temp4)) {
//                if (isScramble(temp1, temp3) && isScramble(temp2, temp4)) return true;
//            }
//
//            if (count(temp1, temp5) && count(temp2, temp6)) {
//                if (isScramble(temp1, temp5) && isScramble(temp2, temp6)) return true;
//            }
//        }
//        return false;
//    }

    public static boolean count(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        int[] counts = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            counts[s1.charAt(i)-'a']++;
            counts[s2.charAt(i)-'a']--;
        }
        for (int count : counts) {
            if (count != 0) return false;
        }
        return true;
    }

}
