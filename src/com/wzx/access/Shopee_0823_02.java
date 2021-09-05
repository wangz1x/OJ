package com.wzx.access;

import java.util.Arrays;
import java.util.Scanner;

public class Shopee_0823_02 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] eles = in.nextLine().split("\\s");
        int[] arr = new int[eles.length];
        for (int i = 0; i < eles.length; i++) {
            arr[i] = Integer.parseInt(eles[i]);
        }

        int target;
        while ((target = in.nextInt()) != -1) {
            int[] res = deal(arr, target);
            System.out.println(res[0] + "," + res[1]);
        }
    }

    public static int[] deal(int[] arr, int target) {
        // find left
        int l = 0, r = arr.length - 1, mid;
        int[] pos = {-1, -1};
        while (l <= r) {
            mid = l + (r - l) / 2;
            if (arr[mid] < target) {
                l = mid + 1;
            } else if (arr[mid] > target) {
                r = mid - 1;
            } else {
                pos[0] = mid;
                r = mid - 1;
            }
        }

        l = 0;
        r = arr.length - 1;
        // find right
        while (l <= r) {
            mid = l + (r - l) / 2;
            if (arr[mid] < target) {
                l = mid + 1;
            } else if (arr[mid] > target) {
                r = mid - 1;
            } else {
                pos[1] = mid;
                l = mid + 1;
            }
        }
        return pos;
    }
}
