package com.wzx.leetcode;

public class Leetcode87 {
    public static void main(String[] args) {
        String s1 = "a";
        String s2 = "b";
        System.out.println(isScramble(s1, s2));
    }

    public static boolean isScramble(String s1, String s2) {
        if (s1.equals(s2)) return true;
        if (s1.length() == 1) return false;

        for (int i = 1; i < s1.length(); i++) {
            String temp1 = s1.substring(0, i);
            String temp2 = s1.substring(i);

            String temp3 = s2.substring(0, i);
            String temp4 = s2.substring(i);

            String temp5 = s2.substring(s2.length()-i);
            String temp6 = s2.substring(0, s2.length()-i);
            // if contains the same characters
            if (count(temp1, temp3) && count(temp2, temp4)) {
                if (isScramble(temp1, temp3) && isScramble(temp2, temp4)) return true;
            }

            if (count(temp1, temp5) && count(temp2, temp6)) {
                if (isScramble(temp1, temp5) && isScramble(temp2, temp6)) return true;
            }
        }
        return false;
    }

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
