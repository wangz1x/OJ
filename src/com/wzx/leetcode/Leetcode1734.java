package com.wzx.leetcode;

/**
 * @author wangzx
 * @email wangzx22@163.com
 * @date 2021/5/11 上午9:45
 */
public class Leetcode1734 {
    public static void main(String[] args) {
        for (int i = 1; i < 100001; i += 2) {
            int res = 1;
            for (int j = 2; j <= i; j++) {
                res ^= j;
            }
            System.out.println("1^...^" + i + " = " + res);
        }
    }
}
