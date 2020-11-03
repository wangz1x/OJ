package com.wzx.leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class Leetcode32 {
    public static void main(String[] args) {
        System.out.println(valid(""));    //
    }

    public static int longestValidParentheses(String s) {
        int[] dp = new int[s.length()];

        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                dp[i] = 0;
            } else if (i > 0) {
                if (i - dp[i - 1] - 1 >= 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + 2;
                    if (i - dp[i - 1] - 2 >= 0) {
                        dp[i] += dp[i - dp[i - 1] - 2];
                    }
                } else {
                    dp[i] = 0;
                }
            } else dp[i] = 0;
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public static int longestValidParentheses_stack(String s) {
        Deque<Integer> stack = new LinkedList<>();
        stack.push(-1);

        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                if (!stack.isEmpty()) {
                    stack.pop();
                    if (stack.isEmpty()) {
                        stack.push(i);
                    } else {
                        max = Math.max(i - stack.peek(), max);
                    }
                }
            }
        }
        return max;
    }

    public static int valid(String s) {
        int max = 0;

        int leftCount = 0;
        int rightCount = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') leftCount++;
            else if (s.charAt(i) == ')') rightCount++;

            if (leftCount == rightCount) max = Math.max(max, 2 * leftCount);
            else if (leftCount < rightCount) rightCount = leftCount = 0;
        }
        rightCount = leftCount = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') leftCount++;
            else if (s.charAt(i) == ')') rightCount++;

            if (leftCount == rightCount) max = Math.max(max, 2 * leftCount);
            else if (leftCount > rightCount) rightCount = leftCount = 0;
        }

        return max;
    }
}
