package com.wzx.access;

import java.util.Arrays;
import java.util.Scanner;

public class Xiaohongshu_0904_04 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt(), K = in.nextInt();
        if (N > 5000) {
            return;
        }
        int[][] distances = new int[N][N];
        // 初始化路径
        for (int i = 0; i < N; i++) {
            Arrays.fill(distances[i], -1);
        }
        for (int i = 0; i < N - 1; i++) {
            int a = in.nextInt(), b = in.nextInt(), c = in.nextInt();
            distances[a - 1][b - 1] = c;
            distances[b - 1][a - 1] = c;
        }

        int res = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (distances[i][j] != -1 && distances[i][j] <= K) {
                    res++;
                }
            }
        }
        System.out.println(res);
    }
}
