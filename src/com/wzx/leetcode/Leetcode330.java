package com.wzx.leetcode;

import java.util.HashSet;
import java.util.Set;

public class Leetcode330 {
    public static void main(String[] args) {
        Leetcode330 l = new Leetcode330();
        System.out.println(l.minPatches(new int[]{1,3}, 1234567890));
    }

    public int minPatches(int[] nums, int n) {
        Set<Integer> cache1 = new HashSet<>();
        Set<Integer> cache2 = new HashSet<>();

        for (int num: nums) {
            cache2.add(num);
            for (int ele : cache1) {
                cache2.add(ele);
                cache2.add(num+ele);
            }
            cache1 = cache2;
            cache2 = new HashSet<>();
        }
        int ret = 0;

        for (int i = 1; i <= n; i ++) {
            if (!cache1.contains(i)) {
                ret ++;
                for (int ele : cache1) {
                    cache2.add(ele);
                    cache2.add(i+ele);
                }
                cache1 = cache2;
                cache2 = new HashSet<>();
            }
        }
        return ret;
    }
}
