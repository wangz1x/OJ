package com.wzx.access;

import java.util.Scanner;

public class Main16 {

    static int[][] moved = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] grids = new int[5][5];
        boolean[] visited = new boolean[999999];

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                grids[i][j] = scanner.nextInt();
            }
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                visit(i, j, 5, 0, visited, grids);
            }
        }

        int res = 0;
        for (boolean bool : visited) {
            if (bool) res++;
        }
        System.out.println(res);
    }

    public static void visit(int x, int y, int step, int num, boolean[] visited, int[][] grids) {
        num = num*10 + grids[x][y];

        if (step == 0) { // 已经走6步了
            visited[num] = true;
            return;
        }

        // 走到坐标为x,y的点
        for (int[] move : moved) {
            if (x+move[0] >= 0 && x+move[0] < 5 && y+move[1] >= 0 && y+move[1] < 5) { // 可以走这个方向
                visit(x+move[0], y+move[1], step-1, num, visited, grids);
            }
        }
    }
}
