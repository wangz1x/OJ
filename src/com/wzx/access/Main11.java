package com.wzx.access;

import java.util.Scanner;

public class Main11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] worriers = new int[n];

        int worrier;
        // 当前指针
        int idx = -1;

        for (int i = 0; i < n; i++) {
            worrier = scanner.nextInt();
            while (idx > -1 && worrier > worriers[idx]) {
                idx--;
            }
            worriers[++idx] = worrier;
        }

        System.out.println(idx+1);
        for (int i = 0; i < idx; i++) {
            System.out.print(worriers[i] + " ");
        }
        System.out.println(worriers[idx]);
    }
}
