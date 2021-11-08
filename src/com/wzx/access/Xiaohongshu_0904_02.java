package com.wzx.access;

public class Xiaohongshu_0904_02 {

    public static void main(String[] args) {
        String text = "";
        System.out.println(partitionNumber(text));
    }

    public static int partitionNumber(String text) {
        int[] count = new int[26];
        char[] cs = text.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            count[cs[i]-'a']++;
        }
        return 1;
    }
}
