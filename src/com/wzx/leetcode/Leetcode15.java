package com.wzx.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode15 {
    public static void main(String[] args) {
        int[] arr = {-2, 0, 1, 1, 2
        };
//        Arrays.sort(arr);
//        System.out.println(Arrays.toString(arr));
        System.out.println(threeSum(arr));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 3) return res;

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            for (int start = i + 1, end = nums.length - 1; start < end; ) {
                if (nums[start] + nums[end] == -nums[i]) {
                    res.add(Arrays.asList(nums[i], nums[start], nums[end]));
                    do {
                        start++;
                    }
                    while (start < end && nums[start] == nums[start - 1]);
                    do {
                        end--;
                    }
                    while (start < end && nums[end] == nums[end + 1]);
                } else if (nums[start] + nums[end] > -nums[i]) {
                    do {
                        end--;
                    }
                    while (start < end && nums[end] == nums[end + 1]);
                } else {
                    do {
                        start++;
                    }
                    while (start < end && nums[start] == nums[start - 1]);
                }
            }
        }
        return res;
    }
}
