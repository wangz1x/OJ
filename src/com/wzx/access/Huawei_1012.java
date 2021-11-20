package com.wzx.access;

public class Huawei_1012 {
    public static void main(String[] args) {
        String str = "101";
        System.out.println(deal(str));
    }

    public static int deal(String str) {
        int res = 0;
        char[] cs = str.toCharArray();
        for (int i = 0; i < cs.length; ) {
            if (cs[i] == '1') {
                res++;
                i += 3;
            } else {
                i++;
            }
        }
        return res;
    }
}
