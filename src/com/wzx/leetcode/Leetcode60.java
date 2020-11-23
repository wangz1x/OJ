package com.wzx.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode60 {
    public static void main(String[] args) {
        System.out.println(getPermutation(4, 4));
    }

    public static String getPermutation(int n, int k) {
        int[] cache = {0, 1, 1, 2, 6, 24, 120, 720, 5040, 45360};

        List<Integer> idxList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));

        StringBuilder sb = new StringBuilder(n);

        for (int i = n; i > 0 && k != 0; i--) {
            int idx = (k-1)/cache[i];
            sb.append(idxList.get(idx));
            idxList.remove(idx);
            k -= idx*cache[i];
        }
        return sb.toString();
    }
}
