package com.wzx.access;

import java.util.Scanner;

public class Xiaomi_0901_01 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        String[] split = line.split(",");
        int m = Integer.parseInt(split[0].split("=")[1]);
        int n = Integer.parseInt(split[1].split("=")[1]);

        String[] ms = in.nextLine().split(",");
        String[] ns = in.nextLine().split(",");

        int[] res = new int[ms.length+ns.length];
        int idx = res.length-1;

        while (m > 0 && n > 0) {
            int ele1 = Integer.parseInt(ms[m-1]);
            int ele2 = Integer.parseInt(ns[n-1]);
            if (ele1 < ele2) {
                res[idx--] = ele2;
                n--;
            } else {
                res[idx--] = ele1;
                m--;
            }
        }
        while (m > 0) {
            res[idx--] = Integer.parseInt(ms[m-1]);
            m--;
        }
        while (n > 0) {
            res[idx--] = Integer.parseInt(ns[n-1]);
            n--;
        }
        for (int re : res) {
            System.out.print(re + " ");
        }
    }
}
