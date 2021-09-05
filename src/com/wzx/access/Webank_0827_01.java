package com.wzx.access;

import java.time.LocalDate;
import java.util.Scanner;

public class Webank_0827_01 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt(), b = in.nextInt();
        int res = 0;
        for (int i = a; i <= b; i++) {
            for (int j = 1; j <= 12; j++) {
                LocalDate date = LocalDate.of(i, j, 1);
                if ("MONDAY".equals(date.getDayOfWeek().toString())) {
                    res++;
                }
            }
        }
        System.out.println(res);
    }
}
