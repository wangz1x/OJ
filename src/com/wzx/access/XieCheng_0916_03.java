package com.wzx.access;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class XieCheng_0916_03 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<Integer> primes = new LinkedList<>();
        int start = 2;
        while (start < 1000001) {
            if (isPrime(start)) {
                primes.add(start);
            }
            start++;
        }
        int[] prime = new int[primes.size()];
        int idx = 0;
        for (int p : primes) {
            prime[idx++] = p;
        }

        while (in.hasNext()) {
            int round = in.nextInt();
            for (int i = 0; i < round; i++) {
                int l = in.nextInt(), r = in.nextInt();
                System.out.println(findRight(r, prime) - findLeft(l, prime) + 1);
            }
        }
    }

    // 找到左边界，即最小的 大于等于ele的元素的下标
    // 2,3,5,7
    public static int findLeft(int ele, int[] prime) {
        int l = 0, r = prime.length - 1, pos = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (prime[mid] == ele) {
                return mid;
            } else if (prime[mid] < ele) {
                l = mid + 1;
            } else {
                pos = mid;
                r = mid - 1;
            }
        }
//        System.out.println("findLeft: " + pos);
        return pos;
    }

    // 找到右边界，即最大的 小于等于ele的元素的下标
    // 2,3,5,7
    public static int findRight(int ele, int[] prime) {
        int l = 0, r = prime.length - 1, pos = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (prime[mid] == ele) {
                return mid;
            } else if (prime[mid] < ele) {
                pos = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
//        System.out.println("findRight: " + pos);
        return pos;
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
}
