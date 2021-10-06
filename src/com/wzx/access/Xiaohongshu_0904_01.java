package com.wzx.access;

import java.util.Arrays;
import java.util.Scanner;

public class Xiaohongshu_0904_01 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[][] scores = new int[N][N];

        for (int i = 0; i < N * N; i++) {
            scores[i / N][i % N] = in.nextInt();
        }

        int max = 0x80000000;
        int[] count = new int[N];
        // 从第i行开始
        for (int i = 0; i < N; i++) {
            // init count
            int end = i, sum;
            Arrays.fill(count, 0);
            while (end < N) {
                for (int j = 0; j < N; j++) {
                    count[j] += scores[end][j];
                }
                // 计算count的最大连续子数组和
                sum = 0;
                for (int j = 0; j < N; j++) {
                    sum += count[j];
                    if (sum > max) {
                        max = sum;
                    }
                    if (sum < 0) {
                        sum = 0;
                    }
                }
                end++;
            }
        }
        System.out.println(max);
    }
}
