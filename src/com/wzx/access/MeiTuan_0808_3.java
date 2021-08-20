package com.wzx.access;

import java.util.Scanner;
import java.util.TreeSet;

public class MeiTuan_0808_3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        long sum = 0L;
        TreeSet<Integer> tree = new TreeSet<>();

        int[] sequences = new int[n];
        for (int i = 0; i < n; i++) {
            sequences[i] = in.nextInt();
            tree.add(sequences[i]);
            // 处理每个元素
            Integer lower = tree.lower(sequences[i]);
            if (lower != null) {
                sum += (long)(i + 1) * lower;
            }
        }
        System.out.println(sum);

//        Scanner in = new Scanner(System.in);
//
//        int n = in.nextInt(), idx = 0;
//        long sum = 0;
//
//        int mod = 1000000009;
//
//        int[] sequences = new int[n];
//        for (int i = 0; i < n; i++) {
//            int ele = in.nextInt();
//
//            if (idx == 0) {
//                sequences[idx++] = ele;
//            } else {
//                // 处理每个元素
//                if (ele > sequences[idx-1]) {
////                    sum += (i+1)*sequences[idx-1];
//                    sum = ((sum%mod)+((i+1)*sequences[idx-1]%mod))%mod;
//                    sequences[idx++] = ele;
//                } else {
//                    // binary search
//                    int left = 0, right = idx-1;
//                    int pos = -1;
//                    while (left <= right) {
//                        int mid = left + (right-left)/2;
//                        if (sequences[mid] < ele) {
//                            pos = mid;
//                            left = mid+1;
//                        } else {
//                            right = mid-1;
//                        }
//                    }
//                    // valid position
//                    if (pos != -1) {
////                        sum += (i+1)*sequences[pos];
//                        sum = ((sum%mod)+((i+1)*sequences[pos]%mod))%mod;
//                    }
//                    // 如果pos位置后边一个不等于ele的话，说明ele是新来的，要加进去
//                    if (sequences[pos+1] != ele) {
//                        moveArr(sequences, pos+1, idx-1);
//                        sequences[pos+1] = ele;
//                        idx++;
//                    }
//                }
//            }
//        }
//        System.out.println(sum);
    }

    public static void moveArr (int[] arr, int start, int end) {
        if (end + 1 - start >= 0) System.arraycopy(arr, start, arr, start + 1, end + 1 - start);
    }
}
