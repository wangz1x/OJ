package com.wzx.access;

import java.util.Scanner;
public class Baidu_0907_01 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();

        char[] cs = line.toCharArray();
        char last = '*';
        int count = 0;
        for (char c : cs) {
            if (last == '*' && (c == 'E' || c == 'e')) {
                last = 'e';
            } else if (last == 'e' && (c == 'A' || c == 'a')) {
                last = 'a';
            } else if (last == 'a' && (c == 'S' || c == 's')) {
                last = 's';
            } else if (last == 's' && (c == 'Y' || c == 'y')) {
                count++;
                last = '*';
            }
        }
        System.out.println(count);
    }
}
