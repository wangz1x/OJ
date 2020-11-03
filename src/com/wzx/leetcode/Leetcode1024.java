package com.wzx.leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class Leetcode1024 {
    public static void main(String[] args) {
        int[][] arr = {{0,1},{6,8},{0,2},{5,6},{0,4},{0,3},{6,7},{1,3},{4,7},{1,4},{2,5},{2,6},{3,4},{4,5},{5,7},{6,9}};
        System.out.println(videoStitching(arr, 9));

    }

    public static int videoStitching(int[][] clips, int T) {
        Comparator<int[]> comparator = (o1, o2) -> o1[0] == o2[0] ? o1[1]-o2[1] : o1[0]-o2[0];
        Arrays.sort(clips, comparator);
        System.out.println(Arrays.deepToString(clips));
        if (clips[0][0] != 0) {
            return -1;
        }

        int count = 0;
        int cover = 0;
        int temp = 0;
        for (int[] clip : clips) {
            if (clip[0] <= cover) {
                if (clip[1] > temp) {
                    temp = clip[1];
                }
            } else {
                cover = temp;
                count++;
                if (clip[0] <= cover) {
                    temp = clip[1];
                }
            }
            if (cover >= T) {
                return count;
            }
        }
        return temp>=T ? count+1: -1;
    }

//    public static int videoStitching(int[][] clips, int T) {
//        Comparator<int[]> comparator = (o1, o2) -> o1[0] == o2[0] ? o1[1]-o2[1] : o1[0]-o2[0];
//        Arrays.sort(clips, comparator);
//        System.out.println(Arrays.deepToString(clips));
//        if (clips[0][0] != 0) {
//            return -1;
//        }
//
//        int count = 1;
//        int[] cover = {0, 0};
//        for (int i=0 ; i < clips.length; i ++) {
//            if (i == clips.length-1 || clips[i][0] != clips[i+1][0]) {
//                if (clips[i][0] <= cover[0] && clips[i][1] >= cover[1]) {
//                    cover[0] = clips[i][0];
//                    cover[1] = clips[i][1];
//                    count = 1;
//                }
//                else if (clips[i][0] > cover[1]) {
//                    return -1;
//                }
//                else if (clips[i][1] > cover[1]) {
//                    count ++;
//                    cover[1] = clips[i][1];
//                }
//            }
//            if (cover[1] >= T) {
//                return count;
//            }
//        }
//        return -1;
//    }


}
