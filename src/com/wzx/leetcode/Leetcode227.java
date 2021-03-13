package com.wzx.leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class Leetcode227 {

    public static void main(String[] args) {
        System.out.println(calculate("3+2*23/23+5 / 2"));
    }

    public static int calculate(String s) {
        Deque<Long> num_stack = new LinkedList<>();
        Deque<Character> op_stack = new LinkedList<>();

        int n = s.length();

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '-' || c == '+' || c == '*' || c == '/') {
                op_stack.push(c);
            } else if (c != ' ') {
                long cur = 0;
                while (i < n && Character.isDigit((c = s.charAt(i)))) {
                    cur = cur * 10 + c - '0';
                    i++;
                }
                i--;
                num_stack.push(cur);
                if (!op_stack.isEmpty() && (op_stack.peek() == '*' || op_stack.peek() == '/')) {
                    long second = num_stack.pop();
                    long first = num_stack.pop();
                    num_stack.push(cal(first, second, op_stack.pop()));
                }
            }
        }

        while (!op_stack.isEmpty()) {
            long first = num_stack.pollLast();
            long second = num_stack.pollLast();
            num_stack.offerLast(cal(first, second, op_stack.pollLast()));
        }
        return num_stack.peek().intValue();
    }

    public static long cal(long x, long y, char op) {
        if (op == '*') return x * y;
        if (op == '/') return y == 0 ? -1 : x / y;
        if (op == '+') return x + y;
        if (op == '-') return x - y;
        return -1;
    }
}
