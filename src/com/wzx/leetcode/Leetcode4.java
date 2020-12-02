package com.wzx.leetcode;

import java.util.Arrays;

public class Leetcode4 {
    public static void main(String[] args) {
        int[] nums1 = {1, 5};
        int[] nums2 = {2,3,4,6};
        System.out.println(findMedianSortedArrays_2(nums1, nums2));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }

        int start = 0;
        int end = nums1.length;
        int midLength = (nums1.length + nums2.length + 1) >> 1;
        int maxLeft;
        int minRight;
        while (start <= end) {
            int i = (start + end) >> 1;
            int j = midLength - i;

            if (i < nums1.length && nums2[j - 1] > nums1[i])
                start = i + 1;
            else if (i > 0 && nums2[j] < nums1[i - 1])
                end = i - 1;
            else {
                if (i == 0)
                    maxLeft = nums2[j - 1];
                else if (j == 0)
                    maxLeft = nums1[i - 1];
                else
                    maxLeft = Math.max(nums2[j - 1], nums1[i - 1]);

                if (((nums1.length + nums2.length) & 1) == 1)
                    return maxLeft;

                if (i == nums1.length)
                    minRight = nums2[j];
                else if (j == nums2.length)
                    minRight = nums1[i];
                else
                    minRight = Math.min(nums1[i], nums2[j]);
                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }

    public static double findMedianSortedArrays_2(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }

        int n = nums1.length;
        int m = nums2.length;

        int halfLen = (n + m + 1) >> 1;

        int left = 0;
        int right = n;

        while (left <= right) {
            int mid_i = (left + right) >> 1;
            int mid_j = halfLen - mid_i;

            if (mid_i > 0 && nums1[mid_i - 1] > nums2[mid_j]) right = mid_i - 1;
            else if (mid_i < n && nums2[mid_j - 1] > nums1[mid_i]) left = mid_i + 1;
            else {
                int maxLeft, minRight;
                if (mid_i == 0) maxLeft = nums2[mid_j - 1];
                else if (mid_j == 0) maxLeft = nums1[mid_i - 1];
                else maxLeft = Math.max(nums1[mid_i - 1], nums2[mid_j - 1]);
                if (((m + n) & 1) == 1) return maxLeft;

                if (mid_i == n) minRight = nums2[mid_j];
                else if (mid_j == m) minRight = nums1[mid_i];
                else minRight = Math.min(nums1[mid_i], nums2[mid_j]);
                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }
}
