package com.wzx.offer;


import java.util.Arrays;

public class Offer50 {
    public static void main(String[] args) {
        System.out.println(firstUniqChar("abaccdeff"));
    }

    public static char firstUniqChar(String s) {
        char res = ' ';
        int[] appear = new int[26];
        Arrays.fill(appear, -1);
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i)-'a';
            if (appear[c] == -1) {        // 第一次出现
                appear[c] = i;            // 记录为出现的位置
            } else {                      // 出现多次
                appear[c] = 50001;           // 表示一下
            }
        }

        int min = 50001;
        int x = min;
        for (int i = 0; i < 26; i++) {
            if (appear[i] > -1 && appear[i] < min) {        // 说明只出现过一次, 并且还更接近起始位置
                min = appear[i];
                x = i;
            }
        }
        return x < 26 ? (char)(97+x)  : ' ';
    }


}
