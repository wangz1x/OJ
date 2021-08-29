package com.wzx.access;

import java.util.Scanner;

public class Webank_0827_02 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();

        if (n == 1) {
            System.out.println(1);
            System.out.println(1);
        }
        if (n == 2) { // 只有两个操作
            int a1, b1;
            String one = in.nextLine();
            String two = in.nextLine();
            a1 = deal(one, 1);
            b1 = deal(two, 1);
            System.out.println(a1 + " " + b1);
            System.out.println(a1 + " " + b1);
        }
        if (n == 3) {
            int a1, a2, b1, b2, b3, b4;
            String one1 = in.nextLine();
            String one2 = in.nextLine();
            String two1 = in.nextLine();
            String two2 = in.nextLine();
            String two3 = in.nextLine();
            a1 = deal(one1, 1);
            a2 = deal(one2, 1);

            b1 = deal(two1, a1);
            b2 = deal(two2, a1);
            b3 = deal(two2, a2);
            b4 = deal(two3, a2);
            System.out.println(b1 + " " + Math.max(b2, b3) + " " + b4);
            System.out.println(b1 + " " + Math.min(b2, b3) + " " + b4);
        }
    }

    // 对a做str的操作
    public static int deal (String str, int a) {
        // 要么是n， 要么是s
        if (str.length() == 1) {
            if (str.charAt(0) == 's') {
                if (a > 0) {
                    return (int)Math.ceil(Math.sqrt(a));
                } else {
                    return -1*(int)Math.ceil(Math.sqrt(-a));
                }
            } else {
                return a*-1;
            }
        } else {
            String[] split = str.split("\\s");
            if (split[0].charAt(0) == '+') {
                return a+Integer.parseInt(split[1]);
            } else if (split[0].charAt(0) == '-') {
                return a-Integer.parseInt(split[1]);
            } else {
                if (a>0){
                    return (int)Math.ceil(1.0*a/Integer.parseInt(split[1]));
                } else {
                    return (int)Math.floor(1.0*a/Integer.parseInt(split[1]));
                }
            }
        }
    }
}
