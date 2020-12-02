package com.wzx.leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class Leetcode1370 {
    public static void main(String[] args) {

    }

    public String sortString(String s) {
        int[] counts = new int[26];

        for (int i = 0; i < s.length(); i ++) {
            counts[s.charAt(i)-'a']++;
        }

        Deque<Character> inc = new LinkedList<>();
        Deque<Character> dec = new LinkedList<>();

        for (int i = 0; i < 26; i ++) {
            if (counts[i] != 0) inc.addLast((char) (i+'a'));
        }

        StringBuilder sb = new StringBuilder(s.length());

        while (sb.length() < s.length()) {
            // inc
            while (!inc.isEmpty()) {
                char c = inc.pollFirst();
                if (counts[c-'a'] != 0) {
                    sb.append(c);
                    dec.addFirst(c);
                    counts[c-'a']--;
                }
            }
            // dec
            while (!dec.isEmpty()) {
                char c = dec.pollFirst();
                if (counts[c-'a']!=0) {
                    sb.append(c);
                    inc.addLast(c);
                    counts[c-'a']--;
                }
            }
        }
        return sb.toString();
    }
}
