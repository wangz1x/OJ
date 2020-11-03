package com.wzx.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode22 {
    public static void main(String[] args) {
//        System.out.println(generateParenthesis(3));
        List<String> res = new ArrayList<>();
        dfs(res, 0, 0,3 , "");
        System.out.println(res);
    }

    public static List<String> generateParenthesis(int n) {
        ArrayList<String>[] cache = new ArrayList[n + 1];
        cache[0] = new ArrayList<>();
        cache[0].add("");
        List<String> res = generate(n, cache);
        return res;
    }

    public static List<String> generate(int i, ArrayList[] cache) {
        if (cache[i] != null) return cache[i];

        cache[i] = new ArrayList();
        for (int j = 0; j < i; j++) {
            for (String s1 : generate(j, cache)) {
                for (String s2 : generate(i - 1 - j, cache)) {
                    cache[i].add("(" + s1 + ")" + s2);
                }
            }
        }
        return cache[i];
    }

    public static void dfs(List<String> res, int left, int right, int n, String s) {
        if (s.length() == 2*n) {
            res.add(s);
            return;
        }

        if (left < n) {
            dfs(res, left+1, right, n, s+"(");
        }
        if (right < left) {
            dfs(res, left, right+1, n, s+")");
        }
    }
}
