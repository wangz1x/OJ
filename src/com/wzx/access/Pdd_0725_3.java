package com.wzx.access;

import java.util.Scanner;

public class Pdd_0725_3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();

        for (int i = 0; i < T; i++) {
            int A = in.nextInt();
            int B = in.nextInt();
            int C = in.nextInt();
            int Q = in.nextInt();
            System.out.println(deal(A, B, C, Q));
        }
    }

    public static int deal(int A, int B, int C, int Q) {

        if (Q == A || B == 1 && C == 1) {
            return 1;
        }

        boolean[] exists = new boolean[Q+1];
        exists[A] = true;

        for (int i = A; i <= Q; i++) {
            if (exists[i]) {
                long next = i+B;
                if (next <= Q) {
                    exists[i+B] = true;
                }
                next = i*C;
                if (next <= Q) {
                    exists[i*C] = true;
                }
            }
        }
        if (exists[Q]) {
            return 1;
        }
        return 0;
    }
}
