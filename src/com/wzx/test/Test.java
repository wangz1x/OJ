package com.wzx.test;

import java.util.*;

public class Test {
    public static void main(String[] args) {
//        List<String> lists = new ArrayList<String>() {{
//            add("千与千寻");
//            add("白夜行");
//            add("编程珠玑");
//            add("编程之美");
//        }};
//
//        List<String> strings = lists.subList(0, 1);
//        strings.add("Effective Java");
//
//        lists.add("haha");
//
//        strings = null;
//        System.out.println(lists);
//        System.out.println(strings);
//        minNumber(new String[]{"30", "3", "5", "34", "9"});
//        int[][] arr = new int[][]{{6, 2}, {4, 2}};
//        Arrays.sort(arr, (e1, e2) -> e2[1] - e1[1]);
//        System.out.println(Arrays.deepToString(arr));
//        System.out.println(kmp("abcabcabcabcdab", "abcabcdab"));
//        String s = "string";
//        int a = s.charAt(0);
//        System.out.println((char)a);
//        double d = 12324.12521321;
//        String format = String.format("%.4f", d);
//        System.out.println(format);
//        System.out.printf("%.2f", d);
//        System.out.println();
//        System.out.format("%.1f", d);
//        System.out.println();
//        System.out.println(s.matches("abdg.*"));
        String s1 = "12345";
        String s2 = "567432";
        String re = multiply(s1, s2);
        System.out.println(re);
    }

    public static String multiply(String s1, String s2) {
        StringBuilder sb1 = new StringBuilder(s1);
        StringBuilder sb2 = new StringBuilder(s2);
        sb1.reverse();
        sb2.reverse();
        int[] a = new int[sb1.length() + sb2.length()];
        for (int i = 0; i < sb1.length(); i++) {
            for (int j = 0; j < sb2.length(); j++) {
                a[i + j] += (sb1.charAt(i) - '0') * (sb2.charAt(j) - '0');
            }
        }
        for (int i = 0; i < a.length - 1; i++) {
            a[i + 1] += a[i] / 10;
            a[i] %= 10;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < a.length - 1; i++) {
            sb.append(a[i]);
        }
        if (a[a.length - 1] != 0) {
            sb.append(a[a.length - 1]);
        }
        return sb.reverse().toString();
    }

    public void minNumber(String[] nums) {
        // 就纯粹的排序吗
        // 1. 从高位开始排, 高位越小的，放越前边
        // 2. 如果某个数为另外一个数的前缀，在接着比较 大数的后部分和该数 大小
        Arrays.sort(nums, this::compareTwo);
        System.out.println(Arrays.toString(nums));
//        return "";
    }


    public int compareTwo(String strx, String stry) {
        int idx = 0;
        while (idx < strx.length() && idx < stry.length()) {
            char cx = strx.charAt(idx);
            char cy = stry.charAt(idx);
            if (cx < cy) {
                return -1;
            } else if (cx > cy) {
                return 1;
            } else {
                idx++;
            }
        }

        if (idx < strx.length()) {   // y 是x的前缀
            // y 从0到idx, x 从 idx 到后边
            return compareTwo(strx.substring(idx), stry);
        } else if (idx < stry.length()) {   // x 是 y 的前缀
            return compareTwo(strx, stry.substring(idx));
        }
        return 0;
    }

    /**
     * find pattern in str, and return the first char index of pattern in the str
     * @param str source string
     * @param pattern substring to be found in str
     * @return first index
     */
    public static int kmp(String str, String pattern) {
        int[] next = next(pattern);
        int str_pointer = 0, pat_pointer = 0;

        while (str_pointer < str.length() && pat_pointer < pattern.length()) {
            while (pat_pointer != -1 && str.charAt(str_pointer) != pattern.charAt(pat_pointer)) {
                pat_pointer=next[pat_pointer];
            }
            str_pointer++;
            pat_pointer++;
        }

        return pat_pointer == pattern.length() ? str_pointer-pat_pointer : -1;
    }

    /**
     * calculate the "next" position to compare when the current position is not match
     *
     * @param str string
     * @return next array
     */
    public static int[] next(String str) {
        int[] next = new int[str.length()];
        next[0] = -1;

        int last = 0, idx = 1;

        while (idx < str.length()) {
            next[idx] = last;
            // calculate next for the next char
            while (last > -1 && str.charAt(last) != str.charAt(idx)) {
                last = next[last];
            }
            last++;
            idx++;
        }

        return next;
    }
}
