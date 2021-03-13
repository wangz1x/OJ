package com.wzx.leetcode;

public class Leetcode331 {
    public static void main(String[] args) {
        System.out.println(isValidSerialization("9,9,91,#,#,9,#,49,#,#,#"));
    }

    public static boolean isValidSerialization(String preorder) {
        int nullCount = 0;

        boolean res = true;
        int n = preorder.length();

        for (int i = n - 1; i >= 0; i--) {
            char c = preorder.charAt(i);
            if (c == '#') {
                nullCount++;
            } else if (Character.isDigit(c)) {
                while (i >= 0 && Character.isDigit(c)) {
                    c = preorder.charAt(i--);
                }
                i++;
                if (nullCount < 2) {
                    res = false;
                    break;
                }
                nullCount--;
            }
        }
        if (nullCount != 1) res = false;
        return res;
    }
}
