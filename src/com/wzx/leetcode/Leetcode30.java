package com.wzx.leetcode;

import java.util.*;

public class Leetcode30 {
    public static void main(String[] args) {
        String s = "aababaacab";
        String[] words = {"aa","ab"};
        System.out.println(findSubstring(s, words));
    }

    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        int term = words[0].length();
        if (term * words.length > s.length()) return res;
        Map<String, Deque<Integer>> wordIndex = new HashMap<>();
        for (int i = 0; i < term; i++) {
            // word count
            Map<String, Integer> copyWords = new HashMap<>();
            for (String ws : words) {
                if (copyWords.containsKey(ws)) copyWords.put(ws, copyWords.get(ws) + 1);
                else copyWords.put(ws, 1);
            }
            int start = i;
            int wordCount = 0;
            for (int j = i; j <= s.length() - term; ) {
                String word = s.substring(j, j + term);
                if (copyWords.containsKey(word) && copyWords.get(word) > 0) {
                    // record word index
                    if (wordIndex.containsKey(word)) wordIndex.get(word).add(j);
                    else {
                        Deque<Integer> linked = new LinkedList<>();
                        linked.add(j);
                        wordIndex.put(word, linked);
                    }
                    copyWords.put(word, copyWords.get(word) - 1);
                    wordCount++;
                    j += term;
                } else if (copyWords.containsKey(word) && copyWords.get(word) == 0) {
                    int end = wordIndex.get(word).peek();
                    for (int k = start; k <= end; k += term) {
                        String w = s.substring(k, k + term);
                        if (copyWords.containsKey(w)) {
                            wordIndex.get(w).poll();
                            copyWords.put(w, copyWords.get(w) + 1);
                            wordCount--;
                        }
                    }
                    start = end + term;
                } else {
                    for (int k = start; k <= j-term; k += term) {
                        String w = s.substring(k, k + term);
                        if (copyWords.containsKey(w)) {
                            wordIndex.get(w).poll();
                            copyWords.put(w, copyWords.get(w) + 1);
                            wordCount--;
                        }
                    }
                    j += term;
                    start = j;
                }
                if (wordCount == words.length) {
                    res.add(start);
                }
            }
            // init
            for (int j = i; j <= s.length() - term; j += term) {
                String w = s.substring(j, j + term);
                if (wordIndex.containsKey(w)) {
                    wordIndex.remove(w);
                }
            }
        }
        return res;
    }
}
