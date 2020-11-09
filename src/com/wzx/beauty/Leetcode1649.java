package com.wzx.beauty;

public class Leetcode1649 {
    public static void main(String[] args) {
        Leetcode1649 l = new Leetcode1649();
        System.out.println(l.createSortedArray(new int[]{1,3,3,3,2,4,2,1,2}));
    }

    public int createSortedArray(int[] instructions) {

        int[] count = new int[500001];

        int min = 0x7fffffff;
        int max = 0x80000000;
        int ret = 0;
        for (int i = 0; i < instructions.length; i ++) {
            min = Math.min(min, instructions[i]);
            max = Math.max(max, instructions[i]);

            count[instructions[i]] ++;
            // first part
            int left = 0;
            for (int j = min; j < instructions[i]; j ++) {
                left += count[j];
            }

            // second part
            int right = 0;
            for (int j = instructions[i]+1; j <= max; j ++) {
                right += count[j];
            }
            ret += Math.min(left, right);
        }
        return ret;
    }
}
