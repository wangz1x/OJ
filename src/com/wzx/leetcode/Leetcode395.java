package com.wzx.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode395 {
    int maximum = 0;

    public int longestSubstring(String s, int k) {
        dfs(s, k);
        return maximum;
    }

    public void dfs(String s, int k) {
        int[] count = countChars(s);
        if (isVaild(count, k)) {
            List<Character> res = invaildChars(count, k);
            if (res.size() == 0) maximum = Math.max(maximum, s.length());
            else {
                for (Character c : res) {
                    s = s.replace(c, '#');
                }
                String[] reduces = s.split("#+");
                for (String reduce : reduces) {
                    dfs(reduce, k);
                }
            }
        }
    }

    public boolean isVaild(int[] count, int k) {
        for (int i = 0; i < 26; i++) {
            // at least one character is more than k
            if (count[i] > 0 && count[i] >= k) return true;
        }
        return false;
    }

    public List<Character> invaildChars(int[] count, int k) {

        List<Character> res = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            if (count[i] > 0 && count[i] < k)
                res.add((char) ('a' + i));
        }
        return res;
    }

    public int[] countChars(String s) {
        int[] count = new int[26];
        char[] schar = s.toCharArray();
        for (int i = 0; i < schar.length; i++) {
            count[schar[i] - 'a']++;
        }
        return count;
    }

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 9999; i++) {
            sb.append((char) ('a'+((int)(Math.random()*100))%26));
        }
        System.out.println(sb.toString());
    }
}
