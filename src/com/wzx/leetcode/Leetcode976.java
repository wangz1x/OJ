package com.wzx.leetcode;

import java.util.Arrays;

public class Leetcode976 {
    public static void main(String[] args) {
        int[] arr = {3,6,2,3,3,2,3,4,100,34,32,67,43,2,7,4,3,5};
        System.out.println(largestPerimeter(arr));
    }

    public static int largestPerimeter(int[] A) {
        if (A.length == 0) return 0;
        Arrays.sort(A);
        System.out.println(Arrays.toString(A));

        int ans = 0;

        for (int i = A.length-3; i >= 0; i ++) {
            if (A[i]+A[i+1] > A[i+2]) {
                ans = A[i]+A[i+1]+A[i+2];
                break;
            }
        }
        return ans;
    }
}
