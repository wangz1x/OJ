package com.wzx.leetcode;

import java.util.*;

public class Leetcode84 {
    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 6, 2, 3};
        System.out.println(largestRectangleArea(arr));
    }

    public static int largestRectangleArea(int[] heights) {
        Deque<Integer> stack = new LinkedList<>();
        int max = 0;

        for (int i = 0; i <= heights.length; i++) {
            if (stack.isEmpty() || i < heights.length && heights[stack.peekLast()] <= heights[i]) stack.add(i);
            else {
                while (!stack.isEmpty() && (i >= heights.length || heights[stack.peekLast()] > heights[i])) {
                    int heightIdx = stack.pollLast();
                    int len;
                    if (stack.isEmpty()) len = i;
                    else len = i - heightIdx;
                    max = Math.max(max, heights[heightIdx] * len);
                }
                stack.add(i);
            }
        }
        return max;
    }
}
