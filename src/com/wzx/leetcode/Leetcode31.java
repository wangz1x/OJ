package com.wzx.leetcode;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Leetcode31 {

    public static void main(String[] args) {
        int[] nums = {1};
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void nextPermutation(int[] nums) {
        Deque<Integer> stack = new LinkedList<>();
        int index = nums.length - 1;

        while (stack.isEmpty() || (index >= 0 && stack.peek() <= nums[index])) stack.push(nums[index--]);

        if (index < 0) {
            index = nums.length-1;
            while(!stack.isEmpty()) {
                nums[index--] = stack.pop();
            }
        }

        int start = index+1;

        while(!stack.isEmpty() && stack.peekLast() <= nums[index]) nums[start++] = stack.pollLast();

        if (!stack.isEmpty()) {
            nums[start++] = nums[index];
            nums[index] = stack.pollLast();
        }

        while(!stack.isEmpty()) nums[start++] = stack.pollLast();
    }
}
