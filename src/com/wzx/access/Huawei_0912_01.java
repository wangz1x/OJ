package com.wzx.access;

public class Huawei_0912_01 {
    public static void main(String[] args) {
        String str1 = "984321748389";
        String str2 = "1234567890";
        System.out.println(multiply(str1, str2));
    }

    public static String multiply(String str1, String str2) {
        int len1 = str1.length(), len2 = str2.length();
        char[] str1c = str1.toCharArray();
        char[] str2c = str2.toCharArray();

        // 乘积结果的最长位数
        int[] cs = new int[len1 + len2];

        // 0 1
        // a b
        // d e

        for (int i = len2 - 1; i >= 0; i--) {
            int ele2 = str2c[i] - '0';

            for (int j = len1 - 1; j >= 0; j--) {
                int ele1 = str1c[j] - '0';
                // 乘积
                int product = ele1 * ele2;
                // 乘积的个位应该放在结果的第几位
                int pos = i + j + 1;
                // 当前乘积 的 个位，       与十位
                int lower = product % 10, upper = product / 10;
                cs[pos] += lower;
                upper += cs[pos] / 10;
                cs[pos] %= 10;
                // 循环进位
                for (int k = pos; k > 0 && upper > 0; k--) {
                    cs[k - 1] += upper;
                    upper = cs[k - 1] / 10;
                    cs[k - 1] %= 10;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        if (cs[0] != 0) sb.append(cs[0]);
        for (int i = 1; i < cs.length; i++) {
            sb.append(cs[i]);
        }
        return sb.toString();
    }
}
