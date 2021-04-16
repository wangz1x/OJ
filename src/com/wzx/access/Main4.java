package com.wzx.access;

import java.util.Arrays;
import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] A2 = {{0, 0, 0, 1}, {0, 0, 1, 1}, {0, 1, 0, 1}, {1, 1, 1, 1}};

        int n = scanner.nextInt();

        for (int i = 2; i < n; i++) {
            int len = A2.length * 2;
            int[][] A = new int[len][len];

            for (int k = 0; k < A2.length; k++) {
                for (int j = A2.length; j < len; j++) {
                    A[k][j] = A2[k][j-A2.length];
                }
            }

            for (int k = A2.length; k < len; k++) {
                for (int j = 0; j < A2.length; j++) {
                    A[k][j] = A2[k-A2.length][j];
                }
            }

            for (int k = A2.length; k < len; k++) {
                for (int j = A2.length; j < len; j++) {
                    A[k][j] = A2[k-A2.length][j-A2.length];
                }
            }
            A2 = A;
        }
        for (int i = 0; i < A2.length; i++) {
            System.out.println(Arrays.toString(A2[i]));
        }
    }
}
