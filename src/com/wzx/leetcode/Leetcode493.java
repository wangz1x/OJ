package com.wzx.leetcode;

public class Leetcode493 {

    public static void main(String[] args) {

    }

    public static int reversePairs(int[] nums) {
        return dfs(nums, 0, nums.length - 1);
    }

    public static int dfs(int[] nums, int left, int right) {
        if (left >= right) return 0;

        int mid = (left + right) >> 1;

        int lc = dfs(nums, left, mid);
        int rc = dfs(nums, mid + 1, right);

        int left_point = left;
        int right_high_point = mid + 1;
        int right_low_point = mid + 1;

        int cur_count = 0;
        while (left_point <= mid) {
            while (left_point <= mid && (long) nums[left_point] <= (long) (nums[right_low_point]) * 2) {
                left_point++;
            }
            while (left_point <= mid && right_high_point <= right && (long) nums[left_point] > (long) (nums[right_high_point]) * 2) {
                right_high_point++;
            }
            cur_count += right_high_point - right_low_point;
            left_point++;
        }

        // sort
        int[] temp = new int[right - left + 1];
        int l = left;
        int r = mid + 1;
        int idx = 0;

        while (l <= mid && r <= right) {
            if (nums[l] <= nums[r]) {
                temp[idx++] = nums[l++];
            } else {
                temp[idx++] = nums[r++];
            }
        }
        while (l <= mid) temp[idx++] = nums[l++];
        while (r <= right) temp[idx++] = nums[r++];
        for (int i = left; i <= right; i++) nums[i] = temp[i - left];

        return lc + rc + cur_count;
    }

}
