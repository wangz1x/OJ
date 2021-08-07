package com.wzx.leetcode;

/**
 * @author wangzx
 * @email wangzx22@163.com
 * @date 2021/5/30 上午9:47
 */
public class Leetcode1074 {

    public static void main(String[] args) {
        int[][] matrix = {{0, 1, 0}, {1, 1, 1}, {0, 1, 0}};
        System.out.println(numSubmatrixSumTarget(matrix, 0));
    }

    public static int numSubmatrixSumTarget(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int[][] preSum = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                preSum[i + 1][j + 1] = preSum[i][j + 1] + preSum[i + 1][j] - preSum[i][j] + matrix[i][j];
            }
        }

        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 以i,j为右下角的矩阵
                for (int k = j; k >= 0; k--) {
                    for (int l = i; l >= 0; l--) {
                        if (preSum[i + 1][j + 1] - preSum[i + 1][k] - preSum[l][j + 1] + preSum[l][k] == target) {
                            target++;
                        }
                    }
                }
            }
        }
        return target;
    }
}
