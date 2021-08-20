package com.wzx.access;

public class Main9 {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//        int n = scanner.nextInt();
//        int[] powers = new int[n];
//
//        for (int i = 0; i < n; i++) {
//            powers[i] = scanner.nextInt();
//        }

        int n = 4;
        int[] powers = {2,3,1,1};

        int end = 0, max = 0, step = 0, cur = 0;

        while (end < n-1) {
            max = Math.max(max, cur+powers[cur]);
            if (cur == end) {
                step++;
                end = max;
            }
            cur++;
        }
        System.out.println(step);
    }
}
