package com.wzx.offer;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        int horizontal = 0, vertical = 0;    // 分别记录横 和 竖
        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();     // 没用?
            for (int i = 0; i < n; i++) {
                int t = scanner.nextInt();
                int val = scanner.nextInt();
                if (t == 1) {
                    horizontal++;
                } else if (t == 0) {
                    if (val <= 180 && !set.contains(val+180)) {
                        vertical++;
                        set.add(val);
                    } else if (val > 180 && !set.contains(val-180)) {
                        vertical++;
                        set.add(val);
                    }
                }
            }
        }
        int res = 1;
        if (horizontal > 0) {
            res = 2*horizontal;
        }
        if (vertical > 0) {
            res = res*(vertical+1);
        }
        System.out.println(res);
    }

    public void main1() {
        Set<Integer> set = new HashSet<>();
        int horizontal = 0, vertical = 0;    // 分别记录横 和 竖
        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();     // 没用?
            for (int i = 0; i < n; i++) {
                int t = scanner.nextInt();
                int val = scanner.nextInt();
                if (t == 1) {
                    horizontal++;
                } else if (t == 0) {
                    if (val <= 180 && !set.contains(val+180)) {
                        vertical++;
                        set.add(val);
                    } else if (val > 180 && !set.contains(val-180)) {
                        vertical++;
                        set.add(val);
                    }
                }
            }
        }
        int res = 1;
        if (horizontal > 0) {
            res = 2*horizontal;
        }
        if (vertical > 0) {
            res = res*(vertical+1);
        }
        System.out.println(res);
    }
}
