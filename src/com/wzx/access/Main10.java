package com.wzx.access;

import java.util.Scanner;

public class Main10 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        // 前三个是男
        int[] A = new int[6];
        // 后三个是女
        int[] B = new int[6];
        //
        int win = 0;
        //
        int count = 0;

        for (int i = 0; i < T; i++) {
            for (int j = 0; j < 6; j++) {
                A[j] = scanner.nextInt();
            }
            for (int j = 0; j < 6; j++) {
                B[j] = scanner.nextInt();
            }
            // 暴力吧
            // 男双有3种方案，女双也是3种方案
            // 遍历混双中，男女
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {

                    for (int l = 0; l < 3; l++) {
                        for (int m = 0; m < 3; m++) {

                            if (A[j]+A[3+k] < B[l]+B[3+m]) count++;
                            if (A[0]+A[1]+A[2]-A[j] < B[0]+B[1]+B[2]-B[l]) count++;
                            if (A[3]+A[4]+A[5]-A[3+k] < B[3]+B[4]+B[5]-B[m+3]) count++;
                            if (count > 1) win++;
                            count = 0;
                        }
                    }
                }
            }
            System.out.println(win);
            win = 0;
        }
    }
}
