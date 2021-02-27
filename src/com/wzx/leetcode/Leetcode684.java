package com.wzx.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Leetcode684 {
    public static void main(String[] args) {

    }

    public int[] findRedundantConnection(int[][] edges) {
        int[][] operator = Arrays.copyOf(edges, edges.length);
        Arrays.sort(operator, (ele1, ele2) -> ele2[1] == ele1[1] ? ele2[0] - ele1[0] : ele1[1] - ele2[1]);

        int begin = operator[0][0];
        int end = operator[0][1];
        // save node in the ring
        Set<Integer> hashSet = new HashSet<>();
        hashSet.add(begin);
        hashSet.add(end);
        for (int i = 1; i < operator.length; i++) {
            if (operator[i][0] == end) {
                end = operator[i][1];
                hashSet.add(end);
            }
            else if (operator[i][0] == begin && operator[i][1] == end) break;
            else {
                hashSet.clear();
                begin = operator[i][0];
                end = operator[i][1];
                hashSet.add(begin);
                hashSet.add(end);
            }
        }

        for (int i = edges.length-1; i >= 0; i--) {
            if (hashSet.contains(edges[i][0]) && hashSet.contains(edges[i][1])) {
                return edges[i];
            }
        }
        return edges[0];
    }
}
