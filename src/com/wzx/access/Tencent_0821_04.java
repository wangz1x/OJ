package com.wzx.access;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;
public class Tencent_0821_04 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), k = in.nextInt();
        String str = in.next();
        System.out.println(deal(str, n, k));
    }

    public static String deal(String str, int n, int k) {
        char[] cs = str.toCharArray();
        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            // 1. 栈不为空  2. 栈顶元素小于当前字符   3. 抛去栈顶后, 剩下的未遍历的字符长度依然能达到k
            while (!stack.isEmpty() && stack.peek() < cs[i] && (stack.size()-1+n-1-i+1)  >= k) {
                stack.pop();
            }
            stack.push(cs[i]);
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
