package com.wzx.leetcode;

public class Leetcode5600 {
    public static void main(String[] args) {
        int[] arr = {2,3};
        System.out.println(kthSmallestPath(arr, 3));
    }

    public static String kthSmallestPath(int[] destination, int k) {
        StringBuilder sb = new StringBuilder(destination[0] + destination[1]);

        int[][] choose = new int[destination[0] + 1][destination[1] + 1];

        for (int i = 0; i < destination[1] + 1; i++) {
            choose[destination[0]][i] = 1;
        }
        for (int i = 0; i < destination[0] + 1; i++) {
            choose[i][destination[1]] = 1;
        }

        for (int i = destination[0] - 1; i >= 0; i--) {
            for (int j = destination[1] - 1; j >= 0; j--) {
                choose[i][j] = choose[i + 1][j] + choose[i][j + 1];
            }
        }

        int i = 0, j = 0;
        while (choose[i][j] != 1) {
            if (choose[i][j+1] >= k) {
                sb.append("H");
                j += 1;
            }
            else {
                sb.append("V");
                k -= choose[i][j+1];
                i += 1;
            }
        }
        while (i++ < destination[0]) sb.append("V");
        while (j++ < destination[1]) sb.append("H");
        return sb.toString();
    }
}
