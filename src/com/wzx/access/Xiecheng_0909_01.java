package com.wzx.access;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Xiecheng_0909_01 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        // 用栈
        Deque<String> stack = new LinkedList<>();

        // 循环处理每个命令
        for (int i = 0; i < n; i++) {
            String line = in.nextLine();
            if ("pwd".equals(line)) {
                StringBuilder sb = new StringBuilder();
                if (!stack.isEmpty()) {
                    for (String ele : stack) {
                        sb.append("\\").append(ele);
                    }
                    System.out.println(sb.toString());
                } else {
                    System.out.println("\\");
                }
            } else {
                String[] commands = line.split("\\s");
                if ("..".equals(commands[1])) {
                    stack.pollLast();
                } else {
                    stack.offerLast(commands[1]);
                }
            }
        }
    }


}
