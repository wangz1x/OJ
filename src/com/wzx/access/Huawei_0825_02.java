package com.wzx.access;

import java.util.Scanner;

public class Huawei_0825_02 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), m = in.nextInt();
        int[][] map = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = in.nextInt();
            }
        }
        // 最少要走的路
        int min = m+n-2;
        if (map[0][0] == 0 || map[n-1][m-1] < min) {
            System.out.println(-1);
        }
        System.out.println(min);
    }

    public static void dfs () {

    }
}
