package com.wzx.access;

import java.util.Arrays;
import java.util.Scanner;

public class Main6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        Arrays.sort(arr);

        long res = 0L;
        int count = 0;
        int cur = arr[0];

        for (int i = 0; i < n; i++) {
            if (arr[i] == cur) {
                count++;
                res += arr[i];
            } else if (res >= arr[i]) {
                cur = arr[i];
                count++;
                res += arr[i];
            } else {
                cur = arr[i];
                res += arr[i];
                count = 1;
            }
        }
        System.out.println(count);
    }
}
