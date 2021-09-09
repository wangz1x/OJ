package com.wzx.access;

import java.util.Scanner;
public class Baidu_0907_03 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt(), b = in.nextInt(), x = in.nextInt(), y = in.nextInt();
        if (x > y) {
            int temp = x;
            x = y;
            y = temp;
        }
        int res = 0;
        while (a > 0 && b > 0) {
            if (a > b) {
                a -= y;
                b -= x;
            } else {
                a -= x;
                b -= y;
            }
            if (a >= 0 && b >= 0) res++;
        }
        System.out.println(res);
    }
}
