package com.wzx.leetcode;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Leetcode5614 {
    public static void main(String[] args) {
        int[] arr = {2,4,3,3,5,4,9,6};
        System.out.println(Arrays.toString(mostCompetitive(arr, 5)));
    }

    public static int[] mostCompetitive(int[] nums, int k) {
        // stack
        int remove = nums.length - k;
        Deque<Integer> stack = new LinkedList<>();

        for (int num : nums) {
            if (stack.isEmpty() || stack.peekLast() <= num) stack.addLast(num);
            else {
                while (remove > 0 && !stack.isEmpty() && stack.peekLast() > num) {
                    remove--;
                    stack.pollLast();
                }
                stack.addLast(num);
            }
        }
        int len = Math.min(k, nums.length);
        int[] ret = new int[len];
        for (int i = 0; i < len; i ++) {
            ret[i] = stack.pollFirst();
        }
        return ret;
    }
}
