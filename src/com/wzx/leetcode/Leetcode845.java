package com.wzx.leetcode;

public class Leetcode845 {
    public static void main(String[] args) {
        int[] arr = {1,1,2,2,3,4,3,3,2,1,0,1,2,3,4,4};
        System.out.println(longestMountain(arr));
    }

    public static int longestMountain(int[] A) {
        if (A.length < 3) {
            return 0;
        }

        int maxLen = 0;
        int temp = 0;
        boolean start = false;
        boolean up = false;
        for (int i = 1; i < A.length; i ++) {
            if (start) {
                if (up && A[i-1]<A[i]) {
                    temp ++;
                }
                else if (A[i-1]>A[i]) {
                    up = false;
                    temp ++;
                    if (temp > maxLen) {
                        maxLen = temp;
                    }
                }
                else if (A[i-1]<=A[i]) {
                    start = false;
                    i = i-1;
                }
            }
            else {
                if (A[i-1]<A[i]) {
                    up = true;
                    start = true;
                    temp = 2;
                }
            }
        }
        return maxLen;
    }
}
