package com.wzx.leetcode;

import java.util.Arrays;

public class Leetcode354 {
    public static void main(String[] args) {
        int[][] arr = {{1, 2}, {5, 4}, {3, 2}, {3, 1}};
        Arrays.sort(arr, (ele1, ele2) -> ele1[0] == ele2[0] ? ele1[1] - ele2[1] : ele1[0] - ele2[0]);

        System.out.println(Arrays.deepToString(arr));
    }

    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (ele1, ele2) -> ele1[0] == ele2[0] ? ele1[1] - ele2[1] : ele1[0] - ele2[0]);
        int count = 0;
        for (int i = 1; i < envelopes.length; i++) {
        }
        return count;
    }
}
