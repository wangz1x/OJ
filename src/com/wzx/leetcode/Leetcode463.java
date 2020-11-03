package com.wzx.leetcode;

public class Leetcode463 {
    public static void main(String[] args) {
        int[][] grid = {{1,1}};
        System.out.println(islandPerimeter(grid));
    }

    public static int islandPerimeter(int[][] grid) {
        int count1 = 0;
        int countConnect = 0;
        for (int i = 0; i < grid.length; i ++) {
            for (int j = 0; j < grid[0].length; j ++) {
                if (grid[i][j] == 1) {
                    count1 ++;

                    if (i+1 < grid.length && grid[i+1][j] == 1) countConnect ++;
                    if (j+1 < grid[0].length && grid[i][j+1] == 1) countConnect ++;
                }
            }
        }
        return 4*count1 - 2*countConnect;
    }
}
