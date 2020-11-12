package com.wzx.leetcode;

import java.util.*;

public class Leetcode514 {
    public static void main(String[] args) {

        String ring = "pqwcx";
        String key = "cpqwx";

        Leetcode514 l = new Leetcode514();
        System.out.println(l.findRotateSteps(ring, key));
    }

    public int findRotateSteps(String ring, String key) {
        int MAX = 99999;
        Map<Character, List<Integer>> map = new HashMap<>();

        // preprocess
        for (int i = 0; i < ring.length(); i++) {
            char c = ring.charAt(i);
            if (map.containsKey(c)) map.get(c).add(i);
            else {
                List<Integer> ls = new ArrayList<>();
                ls.add(i);
                map.put(c, ls);
            }
        }

        int[] dp = new int[ring.length()];
        Arrays.fill(dp, MAX);

        for (int po : map.get(key.charAt(0))) {
            dp[po] = Math.min(Math.abs(po), ring.length() - Math.abs(po)) + 1;
        }
        for (int i = 1; i < key.length(); i++) {
            // current char
            char c = key.charAt(i);
            for (int j = 0; j < ring.length(); j++) {
                // j can be transfer to
                // only update j
                if (ring.charAt(j) == c) {
                    // potential position
                    int minTemp = MAX;
                    for (int start : map.get(key.charAt(i - 1))) {
                        minTemp = Math.min(minTemp, dp[start] + Math.min(Math.abs(j - start), ring.length() - Math.abs(j - start)) + 1);
//                        dp[j] = Math.min(dp[start] + Math.min(Math.abs(start - j), Math.abs(ring.length() - start + j)) + 1, MAX);
                    }
                    dp[j] = minTemp;
                }
            }
        }
        int min = MAX;
        for (int d : map.get(key.charAt(key.length() - 1))) {
            if (dp[d] < min) min = dp[d];
        }
        return min;
    }
}
