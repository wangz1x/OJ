package com.wzx.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode40 {
    public static void main(String[] args) {
        int[] cans = {10,1,2,7,6,1,5};
        System.out.println(combinationSum2(cans, 8));
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();

        dfs(candidates, target, res, temp, 0);

        return res;
    }

    public static void dfs(int[] candidates, int target, List<List<Integer>> res, List<Integer> temp, int index) {
        if (target == 0) {
            res.add(new ArrayList<>(temp));
            return;
        }

        for (int i = index; i < candidates.length; i ++) {
            if (i > index && candidates[i] == candidates[i-1]) continue;
            if (candidates[i] <= target) {
                temp.add(candidates[i]);
                dfs(candidates, target-candidates[i], res, temp, i+1);
                temp.remove(temp.size()-1);
            }
            else break;
        }
    }
}
