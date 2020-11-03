package com.wzx.algorithm;

import java.util.Arrays;

public class Kmp {

    public static void main(String[] args) {
        String p = "ababa";
        String s = "ababcdababa";
        System.out.println(match(s, p));
        System.out.println(otherMatch(s, p));
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
            if (pattern.charAt(comparePointer) == pattern.charAt(i)) comparePointer++;
        }
        for (int i = 1; i < pattern.length(); i ++) {
            int temp = next[i];
            while (temp >= 0 && pattern.charAt(i) == pattern.charAt(temp)) {
                temp = next[temp];
            }
            next[i] = temp;
        }
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
}
