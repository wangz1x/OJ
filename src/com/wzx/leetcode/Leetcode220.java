package com.wzx.leetcode;

import java.util.NavigableSet;
import java.util.TreeSet;

public class Leetcode220 {
    public static void main(String[] args) {

    }

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums.length == 0) return false;
        long min;

        NavigableSet<Long> tree = new TreeSet<>();
        tree.add((long)nums[0]);

        // 0, 1, 2, ..., k-1, k
        for (int i = 1; i < k; i++) {     // 初始化窗口
            if (tree.contains((long)nums[i])) return true;
            min = tree.ceiling((long)nums[i]-t);           // 只要窗口中存在       nums[i]-t ~ nums[i]+t    范围内的元素即可
            if (min <= (long)nums[i]+t) return true;
            tree.add((long)nums[i]);
        }


        for (int i = k; i < nums.length; i++) {
            if (tree.contains((long)nums[i])) return true;
            min = tree.ceiling((long)nums[i]-t);
            if (min <= (long)nums[i]+t) return true;
            tree.add((long)nums[i]);
            tree.remove((long)nums[i-k]);
        }

        return false;
    }
}
