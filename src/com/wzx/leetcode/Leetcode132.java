package com.wzx.leetcode;

import java.util.*;

public class Leetcode132 {

    public static void main(String[] args) {
        System.out.println(minCut("aab"));
    }

    public static int minCut(String s) {
        // 从 key 出发，能到达的位置记为 value， 即 <key, value> 为palindrome
        Map<Integer, List<Integer>> map = new HashMap<>();
        int n = s.length();

        // 记忆化搜索
        boolean[][] isPalindrome = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(isPalindrome[i], true);
        }

        for (int i = n - 1; i >= 0; --i) {
            for (int j = i + 1; j < n; ++j) {
                isPalindrome[i][j] = (s.charAt(i) == s.charAt(j)) && isPalindrome[i + 1][j - 1];

            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (isPalindrome[i][j]) {
                    if (map.containsKey(i)) map.get(i).add(j);
                    else {
                        List<Integer> list = new ArrayList<>();
                        list.add(j);
                        map.put(i, list);
                    }
                }
            }
        }


        Set<Integer> arrive1 = new HashSet<>();
        Set<Integer> arrive2 = new HashSet<>();
        arrive1.add(0);

        int step = 0;
        boolean end = false;

        // 还没到达终点 n
        while (!arrive1.isEmpty()) {

            // 从当前所处位置的集合，开始往后走
            for (int cur : arrive1) {

                if (map.get(cur) != null) {
                    // 遍历从cur能到达的点, next+1为下一步开始的点
                    for (int next : map.get(cur)) {
                        if (next == n - 1) {
                            end = true;
                            break;
                        }
                        // 只留下当前没走过的点
                        if (!arrive1.contains(next + 1)) {
                            arrive2.add(next + 1);
                        }
                    }
                    if (end) break;
                }
            }
            if (end) break;
            arrive1 = arrive2;
            arrive2 = new HashSet<>();
            step++;
        }
        return step;
    }
}
