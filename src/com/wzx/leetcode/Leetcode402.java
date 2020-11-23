package com.wzx.leetcode;

import java.util.*;

public class Leetcode402 {
    public static void main(String[] args) {
        System.out.println(m2("112", 1));
    }

    public static String removeKdigits(String num, int k) {
        if (k >= num.length()) return "0";

        if (k == 0) return num;

        // pre-process
        char[][] dp = new char[num.length()][(int) (Math.log(num.length()) / Math.log(2)) + 1];

        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = num.charAt(i);
        }

        for (int j = 1; j < dp[0].length; j++) {
            for (int i = 0; i + (1 << (j - 1)) < dp.length; i++) {
                dp[i][j] = (char) Math.min(dp[i][j - 1], dp[i + (1 << (j - 1))][j - 1]);
            }
        }

        // query
        int newLen = num.length() - k;
        StringBuilder sb = new StringBuilder(newLen);

        int idx = 0;
        int start = 0;

        while (idx < newLen) {
            // cur length = idx
            int end = (num.length() - 1) - (newLen - idx - 1);
            // query range = [start, end]
            int len = (int) (Math.log(end - start + 1) / Math.log(2));
            char min = (char) Math.min(dp[start][len], dp[end-(1<<len)+1][len]);
            sb.append(min);
            start = num.indexOf(min, start)+1;
            idx++;
        }
        while (sb.length() > 0 && sb.charAt(0) == '0') sb.deleteCharAt(0);

        return sb.length() == 0 ? "0" : sb.toString();
    }

    public static String m2 (String num, int k) {
        if (k >= num.length()) return "0";

        if (k == 0) return num;

        int newLen = num.length() - k;

        Deque<Character> deque = new LinkedList<>();

        int idx = 0;
        while (k > 0 && idx < num.length()) {
            char c = num.charAt(idx++);
            if (deque.isEmpty()) deque.add(c);
            else if (deque.peekLast() <= c) {
                deque.add(c);
            }
            else {
                while (k > 0 && !deque.isEmpty() && deque.peekLast() > c) {
                    deque.pollLast();
                    k --;
                }
                deque.add(c);
            }
        }
        while (idx < num.length()) {
            deque.add(num.charAt(idx++));
        }
        while (k > 0) {
            deque.pollLast();
            k --;
        }

        StringBuilder sb = new StringBuilder(newLen);

        while (!deque.isEmpty() && deque.peekFirst() == '0') {
            deque.pollFirst();
        }

        while (!deque.isEmpty()) {
            sb.append(deque.pollFirst());
        }

        return sb.length() == 0 ? "0" : sb.toString();
    }
}
