package com.wzx.access;

import java.util.Scanner;

public class Xiaomi_0901_02 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), k = 3, pos = 0;
        for (int i = 2; i <= n; i++) {
            pos = (pos+k)%i;
        }
        System.out.println(pos+1);
    }
}
