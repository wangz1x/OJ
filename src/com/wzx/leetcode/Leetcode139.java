package com.wzx.leetcode;

import java.util.Arrays;
import java.util.List;

public class Leetcode139 {

    public static void main(String[] args) {
//        String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
//        List<String> wordDict = Arrays.asList("a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa");
        String s = "pineapplepenapple";
        List<String> wordDict = Arrays.asList("apple", "pen", "applepen", "pine", "pineapple");

    }

    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0) return false;
        boolean[] dp = new boolean[s.length()];
        for (int i = 0; i < s.length(); i++) {
            for (String word : wordDict) {
                if (i - word.length() + 1 >= 0) {
                    dp[i] = word.equals(s.substring(i - word.length() + 1, i + 1));
                    // string before i-word.length()+1
                    if (i - word.length() >= 0) {
                        dp[i] = dp[i] && dp[i - word.length()];
                    }
                }
                if (dp[i]) break;
            }
        }
        return dp[s.length() - 1];
    }
}
