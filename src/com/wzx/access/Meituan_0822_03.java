package com.wzx.access;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author wangzx
 * email wangzx22@163.com
 * date 2021/8/22 上午10:27
 */
public class Meituan_0822_03 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String test = in.nextLine();
        System.out.println(deal(test));
    }

    public static int deal(String s) {

        int res = 1, mod = 1000000007;

        char[] sc = s.toCharArray();
        Deque<String> stack = new LinkedList<>();

        for (char c : sc) {
            if (c == '(') {
                // 左括号无脑入栈
                stack.push(String.valueOf(c));
            } else {
                // 右括号
                if (stack.peek().equals(")")) {
                    stack.pop();
                    stack.push("2");
                } else {
                    int tmp = 1;
                    // 把栈顶的数字全部取出来相乘, 在加1, 在入栈
                    while (!stack.isEmpty() && !stack.peek().equals("(")) {
                        tmp = ((tmp % mod) * (Integer.parseInt(stack.pop()) % mod)) % mod;
                    }
                    if (!stack.isEmpty()) {
                        stack.pop();    // ( 拿出来
                        stack.push(String.valueOf(tmp+1));
                    }
                }
            }
        }
        while (!stack.isEmpty()) {
            res = ((res % mod) * (Integer.parseInt(stack.pop()) % mod)) % mod;
        }
        return res;
    }
}
