package com.wzx.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Leetcode76 {
    public static void main(String[] args) {


        String s = "aaaaaaaaaaaabbbbbcdd";
        String t = "abcdd";
        System.out.println(minWindow(s, t));
        System.out.println((int)'A');
        System.out.println((int)'z');
    }

    public static String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
        }

        int lent = t.length();

        // choose count char from s
        int count = 0;

        // windows left
        int left = 0;
        // windows right
        int right = 0;
        // min windows
        int minLen = s.length();
        int minStart = 0;
        boolean find = false;

        Map<Character, Integer> s_map = new HashMap<>();

        while (right < s.length()) {
            char c = s.charAt(right);

            if (map.containsKey(c)) {
                s_map.put(c, s_map.getOrDefault(c, 0) + 1);
                if (s_map.get(c) <= map.get(c))
                    count++;

                if (count == lent) {
                    while (!map.containsKey(s.charAt(left)) || s_map.get(s.charAt(left)) > map.get(s.charAt(left))) {
                        if (map.containsKey(s.charAt(left))) {
                            s_map.put(s.charAt(left), s_map.get(s.charAt(left))-1);
                        }
                        left++;
                    }
                    if (right-left+1 <= minLen) {
                        find  = true;
                        minLen = right-left+1;
                        minStart = left;
                    }
                }
            }
            right++;
        }
        return find ? s.substring(minStart, minStart + minLen) : "";
    }
}
