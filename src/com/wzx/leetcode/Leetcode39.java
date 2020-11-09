package com.wzx.leetcode;

import java.util.*;

public class Leetcode39 {

    static List<List<Integer>> res = new ArrayList<>();;

    public static void main(String[] args) {
        int[] candidates = {2,3,4};
//        System.out.println(combinationSum(candidates, 100));
        System.out.println(combinationSumDfs(candidates, 10));

    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);

        List<List<Integer>> res = new ArrayList<>();

        if (candidates.length == 0 || candidates[0] > target) return res;

        Deque<Integer> stack = new LinkedList<>();

        int sum = 0;

        int cur = candidates.length - 1;
        int pre = cur;

        while (pre >= 0) {
            if (cur < 0) {
                if (!stack.isEmpty()) {
                    cur = stack.pop() - 1;
                    sum -= candidates[cur + 1];
                }
                if (sum == 0) pre = cur;
            } else if (sum + candidates[cur] == target) {
                stack.push(cur);
                List<Integer> temp = new ArrayList<>();
                for (Integer integer : stack) {
                    temp.add(candidates[integer]);
                }
                res.add(temp);
                stack.pop();
                cur--;
            } else if (sum + candidates[cur] < target) {
                stack.push(cur);
                sum += candidates[cur];
            } else if (sum + candidates[cur] > target) {
                // sum -= candidates[stack.pop()];
                cur--;
            }
        }
        return res;
    }

    public static List<List<Integer>> combinationSumDfs(int[] candidates, int target) {

        List<Integer> temp = new ArrayList<>();

        Arrays.sort(candidates);

        dfs(candidates, target, temp, 0);

        return res;
    }

    public static void dfs(int[] candidates, int target, List<Integer> temp, int index) {

        if (target == 0) {
            res.add(new ArrayList<>(temp));
            return;
        }

        for (int i = index; i < candidates.length; i ++) {
            if (candidates[i] <= target) {
                temp.add(candidates[i]);
                dfs(candidates, target-candidates[i], temp, i);
                temp.remove(temp.size()-1);
            }
            else {
                break;
            }
        }
    }
}
