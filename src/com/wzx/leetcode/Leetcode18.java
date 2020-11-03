package com.wzx.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode18 {
    public static void main(String[] args) {
        int[] nums = {-3,-2,-1,0,0,1,2,3};
        System.out.println(fourSum(nums, 0));
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 4) return res;

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i]==nums[i-1] ) continue;
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i+1  && nums[j] == nums[j-1]) continue;
                int start = j + 1;
                int end = nums.length - 1;
                while (start < end) {
                    if (nums[i] + nums[j] + nums[start] + nums[end] == target) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[start], nums[end]));
                        start++;
                        end--;
                        while (start < end && nums[start - 1] == nums[start]) start++;
                        while (start < end && nums[end + 1] == nums[end]) end--;
                    } else if (nums[i] + nums[j] + nums[start] + nums[end] < target) {
                        start++;
                        while (start < end && nums[start - 1] == nums[start]) start++;
                    } else {
                        end--;
                        while (start < end && nums[end + 1] == nums[end]) end--;
                    }
                }

            }
        }
        return res;
    }
}
