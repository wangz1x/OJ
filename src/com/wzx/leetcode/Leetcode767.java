package com.wzx.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Leetcode767 {
    public static void main(String[] args) {
        String s = "aaaaaaabcd";
        System.out.println(reorganizeString(s));
    }

    public static String reorganizeString(String S) {
        int len = S.length();

        int[] counts = new int[26];

        int max = 0;

        for (int i = 0; i < len; i++) {
            counts[S.charAt(i) - 'a']++;
        }

        Queue<Comp> queue = new PriorityQueue<>((o1, o2) -> o2.count - o1.count);
        for (int i = 0; i < 26; i++) {
            if (counts[i] != 0) {
                max = Math.max(max, counts[i]);
                queue.add(new Comp(counts[i], (char) (i + 'a')));
            }
        }
        if (max - 1 > len - max) return "";

        // make string
        Comp cache1 = null;
        Comp cache2 = null;
        StringBuilder sb = new StringBuilder(len);
        while (!queue.isEmpty()) {
            cache1 = queue.poll();
            sb.append(cache1.c);
            cache1.count --;
            if (!queue.isEmpty()) {
                cache2 = queue.poll();
                sb.append(cache2.c);
                cache2.count--;
            }
            if (cache1.count != 0) queue.add(cache1);
            if (cache2 != null && cache2.count != 0) queue.add(cache2);
            cache1 = null;
            cache2 = null;
        }
        return sb.toString();
    }
}

class Comp {
    int count;
    char c;

    public Comp(int count, char c) {
        this.count = count;
        this.c = c;
    }
}
