package com.wzx.leetcode;

import java.util.Arrays;

public class Leetcode5554 {
    public static void main(String[] args) {
        int[] arr = {91, 4, 64, 78, 44};
        int[][] pieces = {{4}, {64}, {91}, {78, 44}};
        System.out.println(canFormArray(arr, pieces));
    }

    public static boolean canFormArray(int[] arr, int[][] pieces) {
        // whether i-th is visited
        boolean[] visited = new boolean[pieces.length];
        int i = 0;
        int j = 0;
        int k = 0;
        for (i = 0; i < arr.length; ) {
            // find arr[i]
            for (j = 0; j < pieces.length; j++) {
                if (visited[j]) continue;
                if (pieces[j][0] == arr[i]) {
                    // visit all ele in pieces[j]
                    visited[j] = true;
                    for (k = 0; k < pieces[j].length; ) {
                        if (pieces[j][k] == arr[i]) {
                            k++;
                            i++;
                        } else {
                            return false;
                        }
                    }
                    break;
                }
            }
            if (j >= pieces.length) return false;
        }
        return true;
    }
}
