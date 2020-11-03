package com.wzx.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Leetcode20 {
    public static void main(String[] args) {
        System.out.println(isValid("[()]{}"));
    }

    public static boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i ++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.addLast(c);
            }
            else {
                if (stack.isEmpty()) return false;
                char top = stack.pollLast();
                if (!((top == '(' && c == ')') || (top == '[' && c == ']') || (top == '{' && c == '}'))) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
