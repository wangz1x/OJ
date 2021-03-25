package com.wzx.util;

import java.util.*;

public class ArrayGenerator {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(generateArray(100000, 10000, false)));
    }

    public static int[] generateArray(int length, int max, boolean unique) {
        boolean[] occurred = new boolean[max+1];
        int[] arr = new int[length];

        for (int i = 0; i < length; i ++) {
            int flag = Math.random() > 0.5 ? 1 : -1;
            int temp = flag * (int) (Math.round(Math.random() * max) & 0x7fffffff);
            if (unique)  {
                if (!occurred[temp]) {
                    arr[i] = temp;
                    occurred[temp] = true;
                }
            } else {
                arr[i] = temp;
            }
        }
        return arr;
    }
}
