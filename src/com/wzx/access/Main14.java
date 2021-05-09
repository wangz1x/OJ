package com.wzx.access;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Main14 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String N = scanner.next();
        int x = scanner.nextInt();

        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < N.length(); i++) {
            char c = N.charAt(i);
            while (!stack.isEmpty() && stack.peek() > c && x > 0) {
                stack.pop();
                x--;
            }
            stack.push(c);
        }
        while (x > 0 && !stack.isEmpty()) {
            stack.pop();
            x--;
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            char cur = stack.pollLast();
            if (sb.length() == 0 && cur == '0') {
                continue;
            }
            sb.append(cur);
        }
        System.out.println(sb.toString());
    }

}
