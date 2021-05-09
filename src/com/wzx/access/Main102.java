package com.wzx.access;

import java.util.Scanner;

public class Main102 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();
        int x, a, b, n;

        for (int i = 0; i < t; i++) {
            x = scanner.nextInt();
            a = scanner.nextInt();
            b = scanner.nextInt();
            n = scanner.nextInt();
            System.out.println(maxP(x,a,b,n));
        }
    }

    public static int maxP(int x, int a, int b, int n) {
        int max = 0;

        for (int j = 1; j < n; j++) {
            int temp = (2*x+2*b*(n-j)-a*j+a)*j/2;
            if (temp > max) {
                max = temp;
            }
        }
        return max;


    }

    public static int max(int x, int a, int b, int n) {
        double j = (2*x+2*n*b+a)/(2*(2*b+a)*1.0);
        int j_less = (int) j;
        int j_more = j_less+1;
        return Math.max( (2*x+2*b*(n-j_less)-a*j_less+a)*j_less/2,  (2*x+2*b*(n-j_more)-a*j_more+a)*j_more/2);
    }
}
