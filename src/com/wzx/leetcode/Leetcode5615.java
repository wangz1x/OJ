package com.wzx.leetcode;

public class Leetcode5615 {
    public static void main(String[] args) {
        int[] arr = {28,50,76,80,64,30,32,84,53,8};
        System.out.println(minMoves(arr, 84));
    }

    public static int minMoves(int[] nums, int limit) {
        int n = nums.length / 2;

        for (int i = 0; i < n; i ++) {
            if (nums[i] > nums[2*n-1-i]) {
                int temp = nums[i];
                nums[i] = nums[2*n-1-i];
                nums[2*n-i-1] = temp;
            }
        }

        int[] leftcount = new int[limit+1];
        int[] rightcount = new int[limit+1];

        for (int i = 0; i < n; i ++) {
            leftcount[nums[i]]++;
            rightcount[nums[2*n-1-i]]++;
        }

        for (int i = 1; i <= limit; i ++) {
            leftcount[i] += leftcount[i-1];
            rightcount[i] += rightcount[i-1];
        }

        int[] allcount = new int[2*limit+1];

        for (int i = 0; i < n; i ++) {
            allcount[nums[i]+nums[2*n-1-i]]++;
        }

        int ans = 2 * n;

        for (int stand = 2; stand <= 2*limit; stand++) {
            int temp = n - allcount[stand];

            if (stand <= limit) temp += n-leftcount[stand-1];
            else temp += rightcount[stand-limit-1];

            ans = Math.min(ans, temp);
        }
        return ans;
    }
}
