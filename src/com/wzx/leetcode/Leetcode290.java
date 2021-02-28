package com.wzx.leetcode;

import java.util.*;

public class Leetcode290 {
    public static void main(String[] args) {
        String pa = "aaaa";
        String s = "dog cat cat dog";
        System.out.println(wordPattern(pa, s));
    }

    public static boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if (words.length != pattern.length()) return false;

        Map<Character, List<Integer>> map1 = new HashMap<>();
        Map<String, List<Integer>> map2 = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            if (map1.containsKey(c)) map1.get(c).add(i);
            else map1.put(c, new ArrayList<>(Arrays.asList(i)));

            if (map2.containsKey(words[i])) map2.get(words[i]).add(i);
            else map2.put(words[i], new ArrayList<>(Arrays.asList(i)));
        }

        Set<Map.Entry<Character, List<Integer>>> entries = map1.entrySet();
        for (Map.Entry<Character, List<Integer>> entry : entries
        ) {
            String matchString = words[entry.getValue().get(0)];
            if (!entry.getValue().equals(map2.get(matchString))) return false;
        }
        return true;
    }
}
