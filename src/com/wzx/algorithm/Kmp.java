package com.wzx.algorithm;

import java.util.Arrays;

/**
 * 实现KMP算法
 */
interface Int {
    default void say() {
        System.out.println("haha");
    }
}

public class Kmp implements Int{


    public static void main(String[] args) {
        System.out.println(t());
        System.out.println(10/3*3%5);
    }

    public static int t() {
        Integer num = 0;
        try {
            num = null;
            return num;
        } catch (Exception e) {
            return 1;
        } finally {
            return 2;
        }
    }

    public static int[] calculateNext(String pattern) {
        int[] next = new int[pattern.length()];
        next[0] = -1;
        int tempIndex = 1;
        int compareIndex = next[0];
        while (tempIndex < pattern.length()) {
            if (pattern.charAt(tempIndex) == pattern.charAt(compareIndex + 1)) {
                next[tempIndex] = compareIndex + 1;
                compareIndex = next[tempIndex];
                tempIndex++;
            } else if (compareIndex != -1) {
                compareIndex = next[compareIndex];
            } else {
                next[tempIndex] = -1;
                compareIndex = -1;
                tempIndex++;
            }
        }
        System.out.println("next: " + Arrays.toString(next));
        return next;
    }

    public static int match(String source, String pattern) {
        int s_point = 0;
        int p_point = 0;
        int[] next = calculateNext(pattern);
        int compareTime = 0;
        while (s_point < source.length() && p_point < next.length) {
            compareTime++;
            if (source.charAt(s_point) == pattern.charAt(p_point)) {
                s_point++;
                p_point++;
            } else if (p_point == 0) {
                s_point++;
            } else {
                p_point = next[p_point - 1] + 1;
            }
        }
        System.out.println("match compareTime: "+ compareTime);
        if (p_point >= next.length) {
            return s_point-pattern.length();
        }
        return -1;
    }

    public static int[] otherNext(String pattern) {
        int[] next = new int[pattern.length()];
        next[0] = -1;
        int comparePointer = 0;
        for (int i = 1; i < pattern.length(); i++) {
            next[i] = comparePointer;
            while (comparePointer > 0 && pattern.charAt(i) != pattern.charAt(comparePointer)) {
                comparePointer = next[comparePointer];
            }
            if (pattern.charAt(comparePointer) == pattern.charAt(i)) // 这个判断可以去掉, 因为
                comparePointer++; // 如果还是不一样，
        }

//        for (int i = 1; i < pattern.length(); i ++) {
//            int temp = next[i];
//            while (temp >= 0 && pattern.charAt(i) == pattern.charAt(temp)) {
//                temp = next[temp];
//            }
//            next[i] = temp;
//        }
        System.out.println("otherNext: " + Arrays.toString(next));
        return next;
    }

    public static int otherMatch(String s, String p) {
        int[] next = otherNext(p);
        int s_point = 0;
        int p_point = 0;
        int compareTime = 0;
        while (s_point < s.length() && p_point < p.length()) {
            compareTime ++;
            if (s.charAt(s_point) == p.charAt(p_point)) {
                s_point++;
                p_point++;
            } else if (next[p_point] != -1) {
                p_point = next[p_point];
            } else {
                p_point = 0;
                s_point ++;
            }
        }
        System.out.println("otherMatch compareTime: " + compareTime);
        if (p_point == p.length()) {
            return s_point - p.length();
        }
        return -1;
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
