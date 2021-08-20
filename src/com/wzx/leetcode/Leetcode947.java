package com.wzx.leetcode;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Leetcode947 {

    public static void main(String[] args) {
//        [[0,0],[0,2],[1,1],[2,0],[2,2],[2,2],[2,2],[12,2],[2,12],[21,21],[21,2],[5,2],[4,2],[2,5],[2,7],[2,1]]
        int[][] s = {{1,0}, {0,0}, {0,1}, {2,1}, {1,2}, {2,2}};
        Leetcode947 l = new Leetcode947();
        System.out.println(l.removeStones(s));
    }

    public int removeStones(int[][] stones) {
        int[] parent = new int[10];
        int ret = 0;

        for (int i = 0; i < parent.length; i ++) {
            parent[i] = i;
        }

        for (int[] stone : stones) {
            if (find(parent, stone[0]) != find(parent, stone[1])) {
                union(parent, stone[0], stone[1]);
            }
        }

        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int j : parent) {
            hashMap.put(j, hashMap.getOrDefault(j, 0) + 1);
        }

        Collection<Integer> values = hashMap.values();
        for (int value : values) {
            if (value > 1) ret += value-1;
        }

        return ret;
    }

    public int find(int[] parent, int idx) {
        int ret = idx;
        if (parent[idx] != idx) {
            ret = find(parent, parent[idx]);
        }
        return ret;
    }

    public void union(int[] parent, int idx1, int idx2) {
        parent[find(parent, idx1)] = find(parent, idx2);
    }
}
