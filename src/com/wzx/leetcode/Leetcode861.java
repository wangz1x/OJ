package com.wzx.leetcode;

public class Leetcode861 {
    public static void main(String[] args) {
    }

    public int matrixScore(int[][] A) {
        if (A.length == 0 || A[0].length == 0) return 0;

        int m = A.length;
        int n = A[0].length;

        for (int i = 0; i < m; i++) {
            if (A[i][0] == 0) {
                for (int j = 0; j < n; j++) {
                    A[i][j] = 1 - A[i][j];
                }
            }
        }

        int ans = 0;
        for (int j = 0; j < n; j++) {
            int[] count = {0, 0};
            for (int[] ints : A) {
                count[ints[j]]++;
            }
            if (count[0] > count[1]) {
                for (int i = 0; i < m; i++) {
                    A[i][j] = 1 - A[i][j];
                }
                int temp = count[1];
                count[1] = count[0];
                count[0] = temp;
            }
            ans = ans*2 + count[1];
        }
        return ans;
    }
}
