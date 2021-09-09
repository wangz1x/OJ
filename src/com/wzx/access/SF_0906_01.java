package com.wzx.access;

import java.util.Scanner;
public class SF_0906_01 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        System.out.println(deal(arr));
    }

    public static int deal(int[] arr) {
        int res = 0;
        for (int ele : arr) {
            boolean flag = true;
            if (ele > 10 && ele % 10 == ele / 10 % 10) {
                int last = ele % 10;
                ele /= 10;
                while (ele > 0) {
                    if (ele % 10 > last) {
                        flag = false;
                        break;
                    } else {
                        last = ele % 10;
                        ele /= 10;
                    }
                }
                if (flag) res++;
            }
        }
        return res;
    }
}
