package com.wzx.access;

import java.util.Arrays;
import java.util.Scanner;
public class Unknown_0912_01 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine(); // [ [1,2], [2,3], [5,6] ]
        String substring = line.substring(2, line.length() - 2); // [1,2], [2,3], [5,6]
        System.out.println(substring);
        String[] split = substring.split(", "); // [[1,2], [2,3], [5,6]]
        System.out.println(Arrays.toString(split));
        for (String ele : split) {
            System.out.println(ele.substring(1, ele.length()-1)); // 1,2
        }
    }

    public static void deal () {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] diff = new int[20000001];
        for (int i = 0; i < n; i++) {
            // first ~ first+second
            int first = in.nextInt(), second = in.nextInt();
            diff[first] += 1;
            diff[first+second+1] -= 1;
        }

        int cur = 0, max = 0;
        for (int i = 0; i <= 20000000; i++) {
            cur+=diff[i];
            max = Math.max(max, cur);
        }
        System.out.println(max);
    }
}
