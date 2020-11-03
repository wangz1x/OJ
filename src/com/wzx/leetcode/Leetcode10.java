package com.wzx.leetcode;

import java.util.Arrays;

public class Leetcode10 {
    public static void main(String[] args) {
        String p = "ab*ac*a";

        String s = "aaa";
        System.out.println(isMatch(s, p));
    }

    public static boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[p.length()+1][s.length()+1];

        dp[0][0] = true;
        char pc;
        char sc;
        for (int i = 1; i < p.length()+1; i ++) {
            pc = p.charAt(i-1);
            if (pc == '*') {
                dp[i][0] = dp[i-2][0];
            }

            for (int j = 1; j < s.length() + 1; j ++) {
                sc = s.charAt(j-1);

                if (pc == '*') {
                    if (sc == p.charAt(i-2) || p.charAt(i-2) == '.')
                        dp[i][j] = dp[i-1][j-1] || dp[i-1][j] || dp[i][j-1] || dp[i-2][j];
                    else {
                        dp[i][j] = dp[i-2][j];
                    }
                }
                else if (pc == '.' || pc == sc) {
                    dp[i][j] = dp[i-1][j-1];
                }
            }
        }
//        System.out.println(Arrays.deepToString(dp));
        return dp[p.length()][s.length()];
    }
}
