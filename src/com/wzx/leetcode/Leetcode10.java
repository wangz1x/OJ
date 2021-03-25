package com.wzx.leetcode;

import java.util.Arrays;

public class Leetcode10 {
    public static void main(String[] args) {
        String p = "d*";
        String s = "abcd";
        System.out.println(isMatch(s, p));
    }

    public static boolean isMatch(String s, String p) {
        int s_len=s.length(), p_len=p.length();
        boolean[] dp = new boolean[p_len+1];
        dp[0] = true;
        for (int i = 1; i < p_len+1; i++) {
            if (p.charAt(i-1) == '*') {              // 只要不等于 *, 那么必然为false
                dp[i] = dp[i-2];
            }
        }
        for (int i = 1; i < s_len+1; i++) {
            char sc = s.charAt(i-1);

            boolean pre=dp[0], temp;
            dp[0] = false;
            for (int j = 1; j < p_len+1; j++) {
                temp = dp[j];
                char pc = p.charAt(j-1);
                if (pc == sc || pc == '.') {   // 最简单的情况
                    dp[j] = pre;
                } else if (pc == '*'){                  // 遇到*比较麻烦
                    char before = p.charAt(j-2);        // 获取*之前的字符
                    if (sc != before && before != '.') {
                        dp[j] = dp[j-2];          // 不考虑*带来的串
                    } else {
                        dp[j] = dp[j] || dp[j-2];          // 不考虑sc，因为sc可以被*包含，只用看前边能不能匹配就行
                    }
                } else {
                    dp[j] = false;
                }
                pre = temp;
            }
        }
        return dp[p_len];
    }

//    public static boolean isMatch(String s, String p) {
//        boolean[][] dp = new boolean[p.length()+1][s.length()+1];
//
//        dp[0][0] = true;
//        char pc;
//        char sc;
//        for (int i = 1; i < p.length()+1; i ++) {
//            pc = p.charAt(i-1);
//            if (pc == '*') {
//                dp[i][0] = dp[i-2][0];
//            }
//
//            for (int j = 1; j < s.length() + 1; j ++) {
//                sc = s.charAt(j-1);
//
//                if (pc == '*') {
//                    if (sc == p.charAt(i-2) || p.charAt(i-2) == '.')
//                        dp[i][j] = dp[i-1][j-1] || dp[i-1][j] || dp[i][j-1] || dp[i-2][j];
//                    else {
//                        dp[i][j] = dp[i-2][j];
//                    }
//                }
//                else if (pc == '.' || pc == sc) {
//                    dp[i][j] = dp[i-1][j-1];
//                }
//            }
//        }
////        System.out.println(Arrays.deepToString(dp));
//        return dp[p.length()][s.length()];
//    }
}
