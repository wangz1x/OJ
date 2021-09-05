package com.wzx.access;

/**
 * @author wangzx
 * email wangzx22@163.com
 * date 2021/8/22 下午8:58
 */
public class Tencent_0822_02 {
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        System.out.println(deal(arr));
    }

    public static int deal (int[] data) {
        int res = 0;
        for (int i = data.length-1; i >= 0; i--) {
            if (i < data.length-1) {
                data[i] += res;
            }
            res += data[i];
        }
        return res;
    }
}
