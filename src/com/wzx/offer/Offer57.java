package com.wzx.offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Offer57 {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(findContinuousSequence(9)));
    }

    public static int[][] findContinuousSequence(int target) {
        int maxNumber = (int)Math.sqrt(target*2);
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = maxNumber; i >= 2; i--) {
            // maxNumber 个 x, 1~maxNumber
            // x+0, x+1, x+2, x+3, x+4
            int count = ((i-1)*i) >> 1;
            int first = (target-count)/i;
            if (first > 0 && first*i + count == target) {  // 可以
                List<Integer> list = new ArrayList<>();
                for (int j = 0; j < i; j++) {
                    list.add(first+j);
                }
                lists.add(list);
            }
        }
        int[][] res = new int[lists.size()][];
        int idx = 0;
        for (List<Integer> list : lists) {
            res[idx++] = list.stream().mapToInt(e -> e).toArray();
        }
        return res;
    }
}
