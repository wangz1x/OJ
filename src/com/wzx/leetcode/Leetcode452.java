package com.wzx.leetcode;

import java.util.Arrays;

public class Leetcode452 {
    public static void main(String[] args) {
        int[][] arr = {{9,12}, {1,10},{4,11},{8,12},{3,9},{6,9},{6,7}};
        System.out.println(findMinArrowShots(arr));

    }

    public static int findMinArrowShots(int[][] points) {
        if (points.length == 0 || points[0].length == 0) return 0;
        if (points.length == 1) return 1;

        Arrays.sort(points, (o1, o2) -> o1[0] == o2[0] ? o1[1] < o2[1] ? -1 : 1 : o1[0] < o2[0] ? -1 : 1);

        int ret = 1;
        int end = points[0][1];

        for (int i = 0 ; i < points.length; ) {
            if (points[i][0] <= end) {
                end = Math.min(end, points[i][1]);
                i++;
            }
            else {
                ret++;
                end = points[i][1];
            }
        }

        return ret;
    }
}
