package com.wzx.util;

public class ArrayGenerator {

    public static void main(String[] args) {
        int[] ints = generateArray(100, 100, false);   // 10*10
//        Arrays.sort(ints);
        System.out.print("[");
        for (int i = 0; i < ints.length; i++) {
            if (i%10 == 0) {
                System.out.print("[");
            }
            System.out.print(ints[i]);
            if (i%10 == 9) {
                System.out.print("],");
            } else {
                System.out.print(",");
            }
        }
        System.out.print("]");
    }

    public static int[] generateArray(int length, int max, boolean unique) {
//        boolean[] occurred = new boolean[max];
        int[] arr = new int[length];

        for (int i = 0; i < length; i ++) {
            int flag = Math.random() > 0.5 ? 1 : -1;
//            int flag = 1;
            int temp = flag * (int) (Math.round(Math.random() * max) & 0x7fffffff);
//            if (unique)  {
//                if (!occurred[temp]) {
//                    arr[i] = temp;
//                    occurred[temp] = true;
//                }
//            } else {
//                arr[i] = temp;
//            }
            arr[i] = temp;
        }
        return arr;
    }
}
