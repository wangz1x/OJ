package com.wzx.access;

import java.util.Arrays;
import java.util.Scanner;

public class Pdd_0725_1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[][] arr = new int[N][2];
        for (int i = 0; i < N; i++) {
            arr[i][0] = in.nextInt();
            arr[i][1] = in.nextInt();
        }

        Arrays.sort(arr, (ele1, ele2)-> ele1[0] == ele2[0] ? ele2[1]-ele1[1] : ele1[0]-ele2[0]);

        boolean flag = false;
        for (int i = 1; i < N; i++) {
            if (arr[i-1][1] >= arr[i][1]) {
                flag = true;
                System.out.println("true");
                break;
            }
        }
        if (!flag) {
            System.out.println("false");
        }
    }
}
