package com.wzx.leetcode;

import java.util.*;

public class Leetcode140 {
    public static void main(String[] args) {
//        String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
//        List<String> wordDict = Arrays.asList("a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa");
        List<String> wordDict = Arrays.asList("cat", "cats", "and", "sand", "dog");
        String s = "catsanddog";
        System.out.println(wordBreak(s, wordDict));
    }

    public static List<String> wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()];

        for (int i = 0; i < s.length(); i ++) {
            for (String word: wordDict) {
                if (i - word.length()+1 >= 0) {
                    dp[i] = word.equals(s.substring(i - word.length()+1, i+1));
                    // string before i-word.length()+1
                    if (i - word.length() >= 0) {
                        dp[i] = dp[i] && dp[i-word.length()];
                    }
                }
                if (dp[i]) break;
            }
        }

        Map<Integer, List<List<String>>> hashmap = new HashMap<>();
        for (int i = 0; i < s.length(); i ++) {
            for (String word : wordDict) {
                if (i-word.length()+1 >= 0 && word.equals(s.substring(i - word.length() + 1, i + 1))) {
                    List<List<String>> indexI;
                    if (hashmap.containsKey(i)) indexI = hashmap.get(i);
                    else indexI  = new LinkedList<>();
                    if (i-word.length()>=0 && hashmap.containsKey(i-word.length())) {
                        for (List<String> ls : hashmap.get(i-word.length())) {
                            List<String> temp = new LinkedList<>(ls);
                            temp.add(word);
                            indexI.add(temp);
                        }
                    }
                    else if (i-word.length() < 0) {
                        List<String> temp = new LinkedList<>();
                        temp.add(word);
                        indexI.add(temp);
                    }
                    hashmap.putIfAbsent(i, indexI);
                }
            }
        }

        List<String> ls = new ArrayList<>();
        if (hashmap.containsKey(s.length()-1)) {
            for (List<String> l : hashmap.get(s.length()-1)) {
                ls.add(String.join(" ", l));
            }
        }
        return ls;
    }
}
