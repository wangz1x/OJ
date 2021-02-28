package com.wzx.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Leetcode239 {
    public static void main(String[] args) {
        Leetcode239 l = new Leetcode239();
        int[] arr = {4, -2};
        System.out.println(Arrays.toString(l.maxSlidingWindow(arr, 2)));
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        long modCount=0;

        if (k == 1) return nums;

        k = Math.min(k, nums.length);

        int[] ret = new int[nums.length - k + 1];
        int idx = 0;

        PriorityQueue<Integer> queue = new PriorityQueue<>((e1, e2) -> e2 - e1);
        for (int i = 0; i < k; i++) {
            queue.add(nums[i]);
            modCount++;
        }

        ret[idx++] = queue.peek();
        queue.remove(nums[0]);
        modCount++;
        for (int i = k; i < nums.length; i ++) {
            queue.add(nums[i]);
            ret[idx++] = queue.peek();
            queue.remove(nums[i-k+1]);
            modCount+=2;
        }
        System.out.println("modCount: " + modCount);
        return ret;
    }
}
