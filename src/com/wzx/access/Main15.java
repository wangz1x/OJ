package com.wzx.access;

import java.util.Scanner;

public class Main15 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int k = scanner.nextInt();

        int[] powers = new int[n];
        for (int i = 0; i < n; i++) {
            powers[i] = scanner.nextInt();
        }

        int[] agrees = new int[n];
        for (int i = 0; i < n; i++) {
            agrees[i] = scanner.nextInt();
        }

        // 预处理
        int[] preSum = new int[n];
        int[] suffixSum = new int[n];
        int temp = 0;
        for (int i = 1; i < n; i++) {
            // i 不结盟
            if (agrees[i-1] == 0) {
                preSum[i] = 0;
                temp = 0;
            } else {
                temp += powers[i-1];
                preSum[i] = temp;
            }
        }

        temp = 0;
        for (int i = n-2; i >= 0; i--) {
            if (agrees[i+1] == 0) {
                suffixSum[i] = 0;
                temp = 0;
            } else {
                temp += powers[i+1];
                suffixSum[i] = temp;
            }
        }

        int max = 0, res;
        int left = 0, right = k-1;
        for (int i = left; i <= right; i++) {
            max += powers[i];
        }
        max += preSum[left];
        max += suffixSum[right];
        res = max;

        right++;
        left++;
        // 滑动窗口
        while (right < n) {
            res -= preSum[left-1];
            res -= powers[left-1];
            res += preSum[left];

            res -= suffixSum[right-1];
            res += powers[right];
            res += suffixSum[right];

            if (res > max) {
                max = res;
            }

            right++;
            left++;
        }
        System.out.println(max);
    }
}
