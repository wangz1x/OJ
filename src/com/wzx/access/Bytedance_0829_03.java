package com.wzx.access;

import java.util.Scanner;
public class Bytedance_0829_03 {
    static int[][] moves = {{-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {0, -1}, {1, -1}, {1, 0}, {1, 1}};

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] map = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = in.nextInt();
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // 只考虑0的情况
                if (map[i][j] == 0) {
                    // 要判断8个方向?
                    int[] count = new int[8];
                    for (int k = 0; k < 8; k++) {
                        int[] move = moves[k];
                        int temp_x = i, temp_y = j;
                        while (temp_x + move[0] >= 0 && temp_x + move[0] < n && temp_y + move[1] >= 0 && temp_y + move[1] < n && map[temp_x + move[0]][temp_y + move[1]] == 1) {
                            count[k]++;
                            temp_x += move[0];
                            temp_y += move[1];
                        }
                    }
                    // 判断
                    for (int k = 0; k < 8; k++) {
                        // 要么一个方向大于4个, 要么两个相对的方向和大于4
                        if (count[k] >= 4 || count[k] + count[7 - k] >= 4) {
                            System.out.println((i + 1) + " " + (j + 1));
                            break;
                        }
                    }
                }
            }
        }
    }
}
