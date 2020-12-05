package com.wzx.leetcode;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Leetcode321 {

    public static void main(String[] args) {
        int[] nums1 = {7, 6, 1, 9, 3, 2, 3, 1, 1};
        int[] nums2 = {4, 0, 9, 9, 0, 5, 5, 4, 7};
        System.out.println(Arrays.toString(maxNumber(nums1, nums2, 9)));
    }

    public static int[] maxNumber(int[] nums1, int[] nums2, int k) {

        if (nums1.length + nums2.length <= k) return combine(nums1, nums2);

        int[] cache1 = keep(nums1, k);
        int[] cache2 = keep(nums2, k);

        int[] ret = new int[k];
        for (int i = 0; i <= k; i++) {
            // keep i deque1, and k-i deque2, remove extra
            if (cache1.length >= i && cache2.length >= k - i) {
                int[] temp = combine(keep(cache1, i), keep(cache2, k - i));
                ret = maxArr(ret, temp);
            }
        }
        return ret;
    }

    public static boolean biggerArr(int[] arr1, int start1, int[] arr2, int start2) {
        while (start1 < arr1.length && start2 < arr2.length) {
            if (arr1[start1] < arr2[start2]) return false;
            if (arr1[start1] > arr2[start2]) return true;
            start1++;
            start2++;
        }
        return start1 < arr1.length;
    }

    public static int[] maxArr(int[] arr1, int[] arr2) {
        return biggerArr(arr1, 0, arr2, 0) ? arr1 : arr2;
    }

    public static int[] keep(int[] nums1, int save) {
        int idx1 = 0, idxs1 = 0;
        int rem1 = nums1.length - save;
        int[] cache1 = new int[Math.min(save, nums1.length)];
        if (save != 0) {
            while (idx1 < cache1.length + 1 && idxs1 < nums1.length) {
                if ((rem1 <= 0 && idx1 < cache1.length) || idx1 == 0) {
                    cache1[idx1++] = nums1[idxs1++];
                } else if (idx1 < cache1.length && idx1 > 0 && cache1[idx1 - 1] >= nums1[idxs1])
                    cache1[idx1++] = nums1[idxs1++];
                else if (idx1 == cache1.length && cache1[idx1 - 1] >= nums1[idxs1]) {
                    idxs1++;
                    rem1--;
                }
                else {
                    while (rem1 > 0 && idx1 > 0 && cache1[idx1 - 1] < nums1[idxs1]) {
                        rem1--;
                        idx1--;
                    }
                }
            }
        }
        return cache1;
    }

    public static int[] combine(int[] nums1, int[] nums2) {
        int[] ret = new int[nums1.length + nums2.length];
        int idx1 = 0, idx2 = 0, idx = 0;
        while (idx1 < nums1.length && idx2 < nums2.length) {
            if (nums1[idx1] > nums2[idx2]) ret[idx++] = nums1[idx1++];
            else if (nums1[idx1] < nums2[idx2]) ret[idx++] = nums2[idx2++];
                // equals
            else {
                if (biggerArr(nums1, idx1, nums2, idx2)) ret[idx++] = nums1[idx1++];
                else ret[idx++] = nums2[idx2++];
            }
        }
        while (idx1 < nums1.length) ret[idx++] = nums1[idx1++];
        while (idx2 < nums2.length) ret[idx++] = nums2[idx2++];
        return ret;
    }
}
