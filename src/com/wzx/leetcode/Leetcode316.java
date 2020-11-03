package com.wzx.leetcode;

import java.lang.reflect.Array;
import java.util.*;

public class Leetcode316 {
    public static void main(String[] args) {
        System.out.println(removeDuplicateLetters("bbcaac")); //
    }

    public static String removeDuplicateLetters(String s) {
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        Deque<Character> queue = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            if (!queue.contains(s.charAt(i))) {
                while (!queue.isEmpty() && queue.peekLast() > s.charAt(i) && count[queue.peekLast() - 'a'] > 0) {
                    queue.pollLast();
                }
                queue.addLast(s.charAt(i));
            }
            count[s.charAt(i) - 'a']--;
        }
        StringBuilder sb = new StringBuilder();
        for (Character c : queue) {
            sb.append(c);
        }
        return sb.toString();
    }
}
