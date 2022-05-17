package com.wzx.access;

import java.util.Scanner;

public class Un_1009 {
    public static void main(String[] args) {
        int[] arr = {6,3,4,9,10,7,10,2,6};
        System.out.println(getPosition(9, 6, arr));
    }


    public static int getPosition (int m, int k, int[] number) {
        int sum = 0, idx = -1;
        for (int i = 0; i < number.length; i++) {
            sum += number[i];
            if (sum%m == k) {
                idx = i;
            }
        }
        return idx;
    }
}
