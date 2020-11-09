package com.wzx.leetcode;

import java.util.*;

public class Leetcode42 {
    public static void main(String[] args) {
        int[] heights = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(heights));
    }

    public static int trap(int[] height) {
        // save index
        Deque<Integer> stack = new LinkedList<>();
        int res = 0;

        for (int i = 0; i < height.length; i ++) {
            if (stack.isEmpty()) stack.push(i);
            else if (height[i] <= height[stack.peek()]){
                stack.push(i);
            }
            // else if (height[i] == stack.peek()) {
            //     stack.pop();
            //     stack.push(i);
            // }
            else {
                while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                    int curIndex = stack.pop();
                    if (!stack.isEmpty())
                        res += (Math.min(height[stack.peek()], height[i])-height[curIndex]) * (i - stack.peek()-1);
                }
                stack.push(i);
            }
        }
        return res;
    }
}
