package com.wzx.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode90 {
    public static void main(String[] args) {
        int[] nums = {1,2,2};
        System.out.println(subsetsWithDup(nums));
    }

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();

        Arrays.sort(nums);

        int preLen = 1;

        ret.add(new ArrayList<>());

        for (int j = 0; j < nums.length; j ++) {
            int start = 0;
            if (j > 0 && nums[j] == nums[j-1]) {
                start = ret.size() - preLen;
            }
            else {
                preLen = ret.size();
            }

            int end = ret.size();
            for (int i = start; i < end; i ++) {
                List<Integer> temp = new ArrayList<>(ret.get(i));
                temp.add(nums[j]);
                ret.add(temp);
            }
        }
        return ret;
    }
}
