package com.wzx.access;

import java.util.Arrays;
import java.util.Scanner;

public class Lenovo_0826_01 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String pattern = in.nextLine(), haystack = in.nextLine();
        int n = pattern.length();
        int[] next = new int[n];
        next[0] = -1;
        int pointer = 0, idx = 1;
        while (idx < n) {
            while (pointer > -1 && pattern.charAt(pointer) != pattern.charAt(idx)) {
                pointer = next[pointer];
            }
            pointer++;
            next[idx] = pointer;
            idx++;
        }
        next[0] = 0;
        System.out.println(Arrays.toString(next));

        Arrays.fill(next, 0);
        next[0] = -1;
        idx = 1;
        pointer = 0;
        while (idx < n) {
            next[idx] = pointer;
            while (pointer > -1 && pattern.charAt(pointer) != pattern.charAt(idx)) {
                pointer = next[pointer];
            }
            pointer++;
            idx++;
        }

        for (int i = 1; i < n; i++) {
            int temp = next[i];
            while (temp > -1 && pattern.charAt(i) == pattern.charAt(temp)) {
                temp = next[temp];
            }
            next[i] = temp;
        }
        int patternPointer = 0, haystackPointer = 0;
        while (patternPointer < n && haystackPointer < haystack.length()) {
            while (patternPointer != -1 && pattern.charAt(patternPointer) != haystack.charAt(haystackPointer)) {
                patternPointer = next[patternPointer];
            }
            if (patternPointer == -1) {
                System.out.println(0);
            } else {
                System.out.println(patternPointer);
            }
            patternPointer++;
            haystackPointer++;
        }

        if (patternPointer == n) {
            System.out.println("Found at: " + (haystackPointer - patternPointer));
        } else {
            System.out.println("Not Found");
        }
    }
}
