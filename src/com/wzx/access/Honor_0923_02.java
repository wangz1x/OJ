package com.wzx.access;

import java.util.Scanner;

public class Honor_0923_02 {
    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}};
        System.out.println(sum(arr));
//        Scanner in = new Scanner(System.in);
//        // 存储前10000个素数
//        int[] primes = new int[10000];
//        int start = 2;
//        for (int i = 0; i < 10000; i++) {
//            while (!isPrime(start)) {
//                start++;
//            }
//            primes[i] = start++;
//        }
//
//        int n = in.nextInt();
//        for (int i = 0; i < n; i++) {
//            int ele = in.nextInt();
//            boolean flag = false;
//            int l = 0, r = 0, sum = 0;
//            while (r < 10000) {
//                if (sum == ele) {
//                    System.out.println("yes");
//                    flag = true;
//                    break;
//                }
//                sum += primes[r];
//                while (l < r && sum > ele) {
//                    sum -= primes[l++];
//                }
//                r++;
//            }
//            if (!flag) {
//                System.out.println("no");
//            }
//        }
    }

    public static boolean isPrime(int num) {
        if (num <= 3) {
            return num > 1;
        }
        // 不在6的倍数两侧的一定不是质数
        if (num % 6 != 1 && num % 6 != 5) {
            return false;
        }
        int sqrt = (int) Math.sqrt(num);
        for (int i = 5; i <= sqrt; i += 6) {
            if (num % i == 0 || num % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }

    public static int sum(int[][] arr) {
        int n = arr.length, res = 0;
        for (int i = 0; i < n; i++) {
            res += arr[i][i];
        }
        for (int i = 0; i < n; i++) {
            res += arr[i][n - 1 - i];
        }
        // 减去重复的
        if (n % 2 == 1) {
            res -= arr[n/2][n/2];
        }
        return res;
    }
}


