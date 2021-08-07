package com.wzx.access;

import java.util.Scanner;

public class Honor_0807_1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N, L;

        while (true) {
            N = in.nextInt();
            L = in.nextInt();

            if (N == 0 && L == 0) {
                break;
            }
            long res = 0;
            long unit = N;
            if (N == 0 || L == 0) {
                System.out.println(0);
            } else {
                for (int i = 1; i <= L; i++) {
                    res += unit;
                    res %= 1000000007;
                    unit = ((unit%1000000007) * (N%1000000007)) % 1000000007;
                }
                System.out.println(res);
            }
        }
    }

//    public static int power(int base, int m) {
//        long res = 1;
//        long unit = base;
//
//        while (m != 0) {
//            if ((m & 1) == 1) {
//                res = ((res%1000000007) * (unit%1000000007)) % 1000000007;
//            }
//            unit = ((unit%1000000007) * (unit%1000000007)) % 1000000007;
//            m >>= 1;
//        }
//        return (int) (res % 1000000007);
//    }
}
