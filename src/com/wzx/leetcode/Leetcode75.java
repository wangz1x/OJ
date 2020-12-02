package com.wzx.leetcode;

import java.util.Arrays;

public class Leetcode75 {
    public static void main(String[] args) {
        int[] nums = {2,0,2,1,1,0,2,0,2,1,1,0,2,0,2,1,1,0,2,0,2,1,1,0,2,0,2,1,1,0,2,0,2,1,1,0,2,1,1,0,1,0,2,0,2,1,1,0};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void sortColors(int[] nums) {
        int point0 = 0;
        int point2 = nums.length-1;

        for (int idx = 0; idx<nums.length; ) {
            if (nums[idx] == 2 && idx <= point2) {
                int temp = nums[point2];
                nums[point2] = 2;
                nums[idx] = temp;
                while (point2 >= 0 && nums[point2] == 2) point2 --;
            }
            else if (nums[idx] == 0 && idx >= point0) {
                int temp = nums[point0];
                nums[point0] = 0;
                nums[idx] = temp;
                while (point0 < nums.length && nums[point0] == 0) point0 ++;
            }
            else
                idx ++;
        }
    }
}
