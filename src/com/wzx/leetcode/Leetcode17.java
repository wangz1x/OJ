package com.wzx.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode17 {
    static int[] length = {3,3,3,3,3,4,3,4};
    static String[][] letters = {
            {"a", "b", "c", ""},
            {"d", "e", "f", ""},
            {"g", "h", "i", ""},
            {"j", "k", "l", ""},
            {"m", "n", "o", ""},
            {"p", "q", "r", "s"},
            {"t", "u", "v", ""},
            {"w", "x", "y", "z"},
    };

    public static void main(String[] args) {
        System.out.println(letterCombinations(""));
        List<List<Integer>> res = new ArrayList<>();
        res.add(Arrays.asList(1,2,3));
    }

    public static List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.length() > 0)
            dfs(res, digits, 0, "");
        return res;
    }

    public static void dfs(List<String> res, String digits, int index, String temp) {
        if (index < digits.length()) {
            int number = digits.charAt(index)-50;
            for (int i = 0; i < length[number]; i ++) {
                String cur = temp + letters[number][i];
                dfs(res, digits, index+1, cur);
                // temp.substring(0, temp.length()-1);
            }
        }
        else {
            res.add(temp);
        }
    }
}
