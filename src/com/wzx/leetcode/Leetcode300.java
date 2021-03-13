package com.wzx.leetcode;

public class Leetcode300 {

    public static void main(String[] args) {
        System.out.println(lengthOfLIS(new int[]{4, 10, 4, 3, 8, 9}));
    }

    public static int lengthOfLIS(int[] nums) {
        if (nums.length <= 1) return nums.length;

        int[] cache = new int[nums.length + 1];
        // cache[0] = 0x80000000;
        // int idx = 0;

        cache[0] = nums[0];
        // idx is the top of stack
        int idx = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > cache[idx]) cache[++idx] = nums[i];
            else {
                int left = 0;
                int right = idx;
                int pos = -1;
                // find the maximal which less than num[i]
                while (left <= right) {
                    int mid = (left + right) >> 1;
                    if (cache[mid] < nums[i]) {
                        pos = mid;
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
                cache[pos + 1] = nums[i];
            }
        }
        return idx;
    }
}
