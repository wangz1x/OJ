package com.wzx.access;

import java.util.Scanner;

public class Main101 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int h = scanner.nextInt();

        int[] heights = new int[n];

        for (int i = 0; i < n; i++) {
            heights[i] = scanner.nextInt();
        }

        int count = 0, start = 0;
        for (int i = 0; i < n; i++) {
            if (heights[i] <= h) {
                count++;
                if (count == m) {
                    break;
                }
            } else {
                count = 0;
                start = i+1;
            }
        }
        if (start == n) {
            start = -1;
        }
        System.out.println(start+1);
    }
}
