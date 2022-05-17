package com.wzx.access;
import java.util.Arrays;
public class Huawei_0911_02 {
    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 1, 1, 0, 0, 1};
        int n = arr.length;
        int round = 10000;

        int[] copy = new int[n];
        // 循环轮次
        for (int i = 0; i < round; i++) {
            System.out.println(Arrays.toString(arr));
            // 判断当前元素两边是否相同
            for (int j = 1; j < n - 1; j++) {
                if (arr[j - 1] == arr[j + 1]) { // 两边相同则当前位为1
                    copy[j] = 1;
                } else {                    // 不等则为0
                    copy[j] = 0;
                }
            }
            // 第一轮之后把两端置为0，因为两端点不可能为1，但是要在第一轮更新完后在置0
            if (i == 0) {
                copy[0] = 0;
                copy[n-1] = 0;
            }
            for (int j = 0; j < n; j++) {
                arr[j] = copy[j];
            }
        }
    }
}
