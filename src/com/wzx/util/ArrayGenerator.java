package com.wzx.util;

import java.util.Arrays;

public class ArrayGenerator {

    public static void main(String[] args) {
        int[] arr = generateArray(90000, 100000, false, false);
//        System.out.println(Arrays.toString(arr));
        for (int a : arr) {
            System.out.print(a + " ");
        }
    }


    public static void generateTwo() {
        int[] ints = generateArray(999, 1000, false, false);   // 10*10
        System.out.print("[");
        for (int i = 0; i < ints.length; i++) {
            if (i%10 == 0) {
                System.out.print("[");
            }
            System.out.print(ints[i]);
            if (i%10 == 9) {
                System.out.print("],");
            } else {
                System.out.print(",");
            }
        }
        System.out.print("]");
    }

    public static int[] generateArray(int length, int max, boolean unique, boolean isNeg) {
        boolean[] occurred = new boolean[max];
        int[] arr = new int[length];

        for (int i = 0; i < length; i ++) {
            int flag = isNeg ? Math.random() > 0.5 ? 1 : -1 : 1;
            int temp = flag * (int) (Math.round(Math.random() * max) & 0x7fffffff);
            if (unique)  {
                if (!occurred[temp]) {
                    arr[i] = temp;
                    occurred[temp] = true;
                } else {
                    // 无效
                    i--;
                }
            } else {
                arr[i] = temp;
            }
        }
        return arr;
    }
}
