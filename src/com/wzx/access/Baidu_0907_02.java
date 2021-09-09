package com.wzx.access;

import java.util.Scanner;
public class Baidu_0907_02 {

    static int[][] moves = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}};

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt(), n = in.nextInt();
        in.nextLine();
        char[][] map = new char[m][n];
        for (int i = 0; i < m; i++) {
            String line = in.nextLine();
            map[i] = line.toCharArray();
        }
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 'F') {
                    res++;
                    deal(map, i, j);
                }
            }
        }
        System.out.println(res);
    }

    public static void deal(char[][] map, int x, int y) {
        if (map[x][y] != 'F') return;
        // 标记当前女生被访问过
        map[x][y] = 'M';
        for (int[] move : moves) {
            if (x + move[0] >= 0 && x + move[0] < map.length && y + move[1] >= 0 && y + move[1] < map[0].length) {
                deal(map, x + move[0], y + move[1]);
            }
        }
    }
}
