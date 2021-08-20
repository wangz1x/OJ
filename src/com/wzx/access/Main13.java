package com.wzx.access;

import java.util.Scanner;

public class Main13 {
    static int max = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int m, n, K, x, y;
        m = scanner.nextInt();
        n = scanner.nextInt();
        K = scanner.nextInt();
        x = scanner.nextInt();
        y = scanner.nextInt();

        int[][] maps = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                maps[i][j] = scanner.nextInt();
            }
        }
        // 回到起点，则向上走的和向下走的，向左走的和向右走的，次数一样，
        max = maps[x-1][y-1];
        maps[x-1][y-1] = 0;
        dfs(maps, x - 1, y - 1, K, 0, 0, max);
        System.out.println(max);
    }

    public static void dfs(int[][] maps, int x, int y, int K, int left, int up, int values) {
        if (left == 0 && up == 0) {   // 回到原点
            max = Math.max(max, values);
        }
        if (Math.abs(left) + Math.abs(up) <= K) {          // 还能回去
            int temp = maps[x][y];
            maps[x][y] = 0;        // 拿掉宝藏
            // 向左
            if (y - 1 >= 0 && maps[x][y - 1] != -1) {
                dfs(maps, x, y - 1, K - 1, left + 1, up, values + temp);
            }
            // 向右
            if (y + 1 < maps[0].length && maps[x][y + 1] != -1) {
                dfs(maps, x, y + 1, K - 1, left - 1, up, values + temp);
            }
            // 向上
            if (x - 1 >= 0 && maps[x - 1][y] != -1) {
                dfs(maps, x - 1, y, K - 1, left, up + 1, values + temp);
            }
            // 向下
            if (x + 1 < maps.length && maps[x + 1][y] != -1) {
                dfs(maps, x + 1, y, K - 1, left, up - 1, values + temp);
            }
            maps[x][y] = temp;    // 恢复
        }
    }
}
