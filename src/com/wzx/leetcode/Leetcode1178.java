package com.wzx.leetcode;

import java.util.*;

public class Leetcode1178 {


    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        Map<Integer, Integer> cache = new HashMap<>();
        List<Integer> res = new ArrayList<>(puzzles.length);
        int[] words2int = new int[words.length];

        for (int i = 0; i < words.length; i++) {
            words2int[i] = string2Int(words[i], 0);
            cache.put(words2int[i], cache.getOrDefault(words2int[i], 0)+1);
        }

        for (int i = 0; i < puzzles.length; i++) {
            int count = 0;
            int first = 1 << (puzzles[i].charAt(0)-'a');

            int mask = string2Int(puzzles[i], 1);
            int subset = mask;

            do {
                int key = subset | first;
                if (cache.containsKey(key)) {
                    count += cache.get(key);
                }
                subset = (subset - 1) & mask;
            }
            while (subset != mask);
            res.add(count);
        }
        return res;
    }

    public int string2Int(String word, int start) {
        int res = 0;
        char[] chars = word.toCharArray();
        for (int i = start; i < chars.length; i++) {
            res |= 1 << (chars[i] - 'a');
        }
        return res;
    }

    public static void main(String[] args) {
        String[] words = {"aaaa","asas","able","ability","actt","actor","access"};
        String[] puzzles = {"aboveyz","abrodyz","abslute","absoryz","actresz","gaswxyz"};
        Leetcode1178 l = new Leetcode1178();
        List<Integer> numOfValidWords = l.findNumOfValidWords(words, puzzles);
        System.out.println(numOfValidWords);

    }
}
