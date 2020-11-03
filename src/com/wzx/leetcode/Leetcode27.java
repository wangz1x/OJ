package com.wzx.leetcode;

import java.util.Arrays;

public class Leetcode27 {
    public static void main(String[] args) {
        int[] nums = {};
        int len = removeElement(nums, 3);
        System.out.println(len);
        System.out.println(Arrays.toString(nums));
    }

    public static int removeElement(int[] nums, int val) {
        int start = 0;
        int end = nums.length-1;
        while (start <= end) {
            while (start <= end && nums[start] != val) start ++;

            while (start <= end && nums[end] == val) end --;

            if (start < end && start < nums.length && end >= 0) {
                nums[start] = nums[end];
                nums[end] = val;
                start ++;
                end --;
            }
        }
        return end+1;
    }
}
