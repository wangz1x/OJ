package com.wzx.access;

import java.util.Deque;
import java.util.LinkedList;

public class Main8 {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        String str = scanner.next();
        System.out.println(reverseParentheses("a(bcdefghijkl(mno)p)q"));
    }

    public static String reverseParentheses(String s) {
        char[] cs = s.toCharArray();

        Deque<Character> stack1 = new LinkedList<>();
        Deque<Character> stack2 = new LinkedList<>();

        StringBuilder sb = new StringBuilder();

        for (char c : cs) {
            if (c != ')') stack1.push(c);
            else {
                while (!stack1.isEmpty() && stack1.peek() != '(') {
                    stack2.offer(stack1.pop());
                }
                stack1.pop();   // 去掉'('
                while (!stack2.isEmpty()) {
                    stack1.push(stack2.poll());
                }
            }
        }
        //      stack :             push  3  2 1
        //      queue :              offer  3   2  1  poll
        while (!stack1.isEmpty()) {
            sb.append(stack1.pollLast());
        }
        return sb.toString();
    }
}
