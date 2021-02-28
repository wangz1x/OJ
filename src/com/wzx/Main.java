package com.wzx;

import java.util.*;

public class Main {
    public int a;
    public static int b;

    public static void main(String[] args) {
//        int[] arr1 = {1, 4, 5, 7, 34, 56, 90};
//        int[] arr2 = {8, 12, 45, 67, 89, 99, 110, 234};
//
//        System.out.println(Arrays.toString(formerK(arr1, arr2, 6)));
        List<String> list = new ArrayList<>();
        list.add("s1");
        list.add("s1");
        list.add("s1");
        list.add("s2");

        list.removeIf("s2"::equals);
        System.out.println(list);

        String s1 = "abc";
        System.out.println(s1.indexOf('b'));

        double x = 2.0/3;
        System.out.println(x);
        System.out.println(x*3);

        int[][] distance = new int[3][3];
        for (int[] dis : distance) {
            Arrays.fill(dis, -1);
        }
        System.out.println(Arrays.deepToString(distance));

    }
}
