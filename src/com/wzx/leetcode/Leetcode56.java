package com.wzx.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Leetcode56 {
    public static void main(String[] args) {
        Leetcode56 l = new Leetcode56();
        int[][] inters = {{}};
        System.out.println(Arrays.deepToString(l.merge(inters)));
    }

    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0 || intervals[0].length == 0) return new int[][]{};
//        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
        int start = intervals[0][0];
        int end = intervals[0][1];
        List<int[]> li = new ArrayList<>();

        for (int[] interval : intervals) {
            if (interval[0]<= end) {
                end = Math.max(end, interval[1]);
            }
            else {
                li.add(new int[]{start, end});
                start = interval[0];
                end = interval[1];
            }
        }
        li.add(new int[]{start, end});
        int[][] ret = new int[li.size()][2];
        int i = 0;
        for (int[] l : li) {
            ret[i][0] = l[0];
            ret[i++][1] = l[1];
        }

        return ret;
    }
}
