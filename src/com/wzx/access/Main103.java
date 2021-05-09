package com.wzx.access;

import java.util.Scanner;

public class Main103 {

    static int min = 0x7fffffff;

    static int[][] moves = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        boolean[][] visited = new boolean[n][m];
        char[][] grids = new char[n][m];

        for (int i = 0; i < n; i++) {
            String line = scanner.next();
            grids[i] = line.toCharArray();
        }

        visited[0][0] = true;
        dfs(0, 0, visited, false, 0, n, m, grids);

        if (min == 0x7fffffff) {
            min = -1;
        }
        System.out.println(min);
    }

    public static void dfs(int x, int y, boolean[][] visited, boolean hasFired, int sum, int n, int m, char[][] grids) {
        if (x == n-1 && y == m-1) {     // 竟然走到了!
            min = Math.min(min, sum);
            return;
        }

        for (int[] move : moves) {
            // 首先判断不能出界, 其次下一个点还没被访问过
            if (x+move[0] < n && x+move[0] >= 0 && y+move[1] < m && y+move[1] >= 0 && !visited[x+move[0]][y+move[1]]) {
                // 看是否障碍物以及自己还能不能开炮
                if (grids[x+move[0]][y+move[1]] == '.') {
                    visited[x+move[0]][y+move[1]] = true;
                    dfs(x+move[0], y+move[1], visited, hasFired, sum+1, n, m, grids);
                    visited[x+move[0]][y+move[1]] = false;
                } else if (!hasFired) {   // 还没开炮
                    visited[x+move[0]][y+move[1]] = true;
                    dfs(x+move[0], y+move[1], visited, true, sum+1, n, m, grids);
                    visited[x+move[0]][y+move[1]] = false;
                }
            }
        }
    }
}
