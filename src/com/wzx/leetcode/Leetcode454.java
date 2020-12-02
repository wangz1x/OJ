package com.wzx.leetcode;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Leetcode454 {
    public static void main(String[] args) {
        int[] A={1,2,1,2};
        int[] B={-2,-1,1,2};
        int[] C={1,2,-1,2};
        int[] D={0,1,2,2};
        System.out.println(fourSumCount(A, B, C, D));
    }

    public static int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> treeMap1 = new TreeMap<>();
        Map<Integer, Integer> treeMap2 = new TreeMap<>();

        for (int value : A) {
            for (int k : B) {
                treeMap1.put(value + k, treeMap1.getOrDefault(value + k, 0) + 1);
            }
        }

        for (int k : C) {
            for (int i : D) {
                treeMap2.put(k + i, treeMap2.getOrDefault(k + i, 0) + 1);
            }
        }

        int ret = 0;
        Set<Integer> integers = treeMap1.keySet();
        Set<Integer> integers1 = treeMap2.keySet();

        for (Integer integer : integers) {
            if (integers1.contains(integer)) ret += treeMap1.get(integer)*treeMap2.get(integer);
        }
        return ret;
    }
}
