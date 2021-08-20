package com.wzx.access;

import java.util.Scanner;

public class MeiTuan_0808_2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String str = in.nextLine();

        char[] cs = str.toCharArray();

        StringBuilder sb = new StringBuilder();

        char pre = '/';

        for (char c : cs) {
            // 跳过所有的空格
            if (c == ' ') {
                continue;
            }

            if (c != pre) {
                sb.append(c);
                pre = c;
            }
        }
        System.out.println(sb.toString());
    }
}
