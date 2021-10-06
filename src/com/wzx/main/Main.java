package com.wzx.main;

import java.util.Scanner;

public class Main {

    static int res = 0;
    // count 记录已经遍历过的地盘，大于 n*m 时就说明所有的地盘都遍历过了

    static int[][] arrows = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();             // 土地长 高度？
        int m = scanner.nextInt();             // 土地宽

        int[][] flags = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                flags[i][j] = scanner.nextInt();
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (dfs(flags, i, j, flags[i][j])) {
                    res++;
                }
            }
        }


        System.out.println(res);
    }

    /**
     * @param flags 地盘标志
     * @param x     当前位置的x坐标
     * @param y     当前位置的y坐标
     */
    public static boolean dfs(int[][] flags, int x, int y, int val) {         // 深度优先遍历
        int n = flags.length, m = flags[0].length;
        if (flags[x][y] == -1 || flags[x][y] != val) {
            return false;
        }
        flags[x][y] = -1;
        for (int[] arrow : arrows) {
            if (x + arrow[0] >= 0 && x + arrow[0] < n && y + arrow[1] >= 0 && y + arrow[1] < m) {
                dfs(flags, x+arrow[0], y+arrow[1], val);
            }
        }
        return true;
    }
}



