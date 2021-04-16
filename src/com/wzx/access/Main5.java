package com.wzx.access;

import java.util.Scanner;

public class Main5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t, n, k;
        t = scanner.nextInt();

        for (int i = 0; i < t; i++) {
            n = scanner.nextInt();
            k = scanner.nextInt();
            System.out.println(swap(n, k));
        }
    }

    public static int swap(int n, int k) {
        int[] arr = new int[13];    // 一个整形数，最大11位吧
        int idx = 0;
        while (n != 0) {
            arr[idx] = n % 10;
            n /= 10;
            idx++;
        }
        boolean swap = false;
        for (int i = 0; i < k; i++) {
            for (int j = idx - 1; j > 0; j--) {
                if (arr[j] > arr[j - 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                    swap = true;
                    break;        // 一次只交换一次
                }
            }
            if (!swap) { // 全都排好序了
                break;
            }
            swap = false;
        }
        int res = 0, unit = 1;
        for (int i = 0; i < idx; i++) {
            res += arr[i] * unit;
            unit *= 10;
        }
        return res;
    }
}
