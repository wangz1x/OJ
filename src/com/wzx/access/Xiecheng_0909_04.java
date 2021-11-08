package com.wzx.access;
import java.util.Scanner;

public class Xiecheng_0909_04 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), m = in.nextInt();
        int[] things = new int[201];
        int[] cars = new int[m];

        for (int i = 0; i < n; i++) {
            things[in.nextInt()]++;
        }

        for (int i = 0; i < m; i++) {
            cars[i] = in.nextInt();
        }

        // 处理每个车
        for (int i = 0; i < m; i++) {
            if (things[cars[i]] != 0) {
                System.out.print(cars[i] + " ");
            } else {

            }
        }
    }
}
