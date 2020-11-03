package com.wzx.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Leetcode12 {
    public static void main(String[] args) {
        System.out.println(intToRoman(3999));
    }

    public static String intToRoman(int num) {
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] roman = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder sb = new StringBuilder();
        for (int i=0; i < nums.length; i ++) {
            while (num >= nums[i]) {
                sb.append(roman[i]);
                num -= nums[i];
            }
        }
        return sb.toString();
    }
}
