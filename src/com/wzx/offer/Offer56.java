package com.wzx.offer;

public class Offer56 {
    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{3,4,3,3}));
    }

    public static int singleNumber(int[] nums) {
        int[] count = new int[32];     // 统计各个位上的1的个数

        for (int num : nums) {
            int idx = 0;
            while (num != 0) {
                if ( (num & 1) == 1 ) {     // 第idx位上为1
                    count[idx] += 1;
                }
                num >>= 1;
                idx++;
            }
        }

        int res = 0;
        for (int i = 0; i < 32; i++) {
            if (count[i]%3 == 1) {
                res += (1 << i);
            }
        }
        return res;
    }
}
