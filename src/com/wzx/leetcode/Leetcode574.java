package com.wzx.leetcode;

import java.util.HashSet;
import java.util.Set;

public class Leetcode574 {
    public static void main(String[] args) {
        System.out.print("[");
        for (int i = 0; i < 10; i ++) {
            System.out.print("[");
            for (int j = 0; j < 9; j ++) {
                System.out.print(Math.round(Math.random()) + ",");
            }
            System.out.print(Math.round(Math.random()) + "],");
        }
        System.out.print("]");
//        System.out.println(Math.round(0.1));
//        System.out.println(Math.round(0.6));
    }

    public int findCircleNum(int[][] isConnected) {

        UnionFound unionFound = new UnionFound(isConnected.length);
        for (int i = 0; i < isConnected.length; i++) {
            for (int j = 0; j < isConnected[0].length; j++) {
                if (isConnected[i][j] == 1) {
                    unionFound.union(i, j);
                }
            }
        }

        return unionFound.count();
    }

    private class UnionFound {
        int[] parent;
        int[] count;

        public UnionFound(int n) {
            parent = new int[n];
            count = new int[n];

            for (int i = 0; i < n; i ++) {
                parent[i] = i;
                count[i] = 0;
            }
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if (rootX == rootY) return;
            if (count[rootX] > count[rootY]) {
                parent[rootY] = rootX;
                count[rootX]++;
            } else {
                parent[rootX] = rootY;
                count[rootY]++;
            }
        }


        public int find (int x) {
            if (x != parent[x]) {
                count[parent[x]]--;
                parent[x] = find(parent[x]);
                count[parent[x]]++;
            }
            return parent[x];
        }

        public int count() {
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < parent.length; i ++) {
                set.add(find(i));
            }
            return set.size();
        }
    }

}
