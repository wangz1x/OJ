package com.wzx.access;

import java.util.Deque;
import java.util.LinkedList;

public class Huawei_0911_01 {
    public static void main(String[] args) {
        String case1 = "(abcd)";
        String case2 = "(u(love)i)";
        String case3 = "(i(u(wa)e)h)";
        String case4 = "a(bcdefghijkl(mno)p)q";
        System.out.println(deal(case1));
        System.out.println(deal(case2));
        System.out.println(deal(case3));
        System.out.println(deal(case4));
    }

    public static String deal (String str) {
        char[] chars = str.toCharArray();
        Deque<Character> stack = new LinkedList<>();
        Deque<Character> deque = new LinkedList<>();

        for (char c : chars) {
            if (c == '(') {
                stack.push(c);
            } else if (c != ')') {
                stack.push(c);
            } else {
                // 翻转直到遇到stack1中的左括号
                char cc;
                while (!stack.isEmpty() && (cc = stack.pop()) != '(') {
                    deque.offer(cc);
                }
                // 队列里其实就是翻转后的字符串
                while (!deque.isEmpty()) {
                    stack.push(deque.poll());
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
