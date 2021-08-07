package com.wzx.leetcode;

/**
 * @author wangzx
 * @email wangzx22@163.com
 * @date 2021/6/4 下午4:47
 */
public class Leetcode525 {

    public static void main(String[] args) {
        int[] arr = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0};
        System.out.println(findMaxLength(arr));
    }

    public static int findMaxLength(int[] nums) {

        int[] dp = new int[nums.length];

        // 从1开始 dp[0] = 0
        for (int i = 1; i < nums.length; i++) {
            int case1 = 0, case2 = 0;
            // case1:
            if (nums[i]+nums[i-1] == 1) {
                case1 = 2;
                if (i-2 > 0) {
                    case1 += dp[i-2];
                }
            }

            // case2:
            if (dp[i-1] != 0) {
                int k = i-dp[i-1];     // i-1-k+1 = dp[i-1]
                if (k-1 >= 0 && nums[k-1]+nums[i] == 1) {
                    case2 = 2+dp[i-1];
                }
                if (k-2>=0) {
                    case2 += dp[k-2];
                }
            }
            dp[i] = Math.max(case1, case2);
        }
        int max = 0;
        for (int d : dp) {
            max = Math.max(max, d);
        }
        return max;
    }
}
