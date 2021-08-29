package com.wzx.access;

import java.util.HashMap;
import java.util.Scanner;

/**
 * date 2021/8/29 上午10:20
 */
public class Meituan_0829_04 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 草地的边长
        int n = in.nextInt(), m = in.nextInt(), k = in.nextInt();
        // 圆心点坐标以及半径
        int[][] data = new int[k][3];
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < 3; j++) {
                data[i][j] = in.nextInt();
            }
        }
        // 第一天割草每块只能割一个单位

        // 后边每一天, 如果割的是之前割过得, 那么割多少单位呢
        // 记录每块地在哪一天被割过, 原本是 x,y 替换为 (x-1)*m+y作为key, 注意是从1开始的
        HashMap<Integer, Integer> map = new HashMap<>();
        int cut = 0;
        // 每天的处理
        for (int i = 0; i < k; i++) {
            // y范围
            int l = data[i][1] - data[i][2], r = data[i][1] + data[i][2];
            // x范围
            int u = data[i][0] - data[i][2], d = data[i][0] + data[i][2];

            // 对于每一行, 用二分找到最左边的点, 然后可以对称到右边
            for (int x = u; x <= d; x++) {
                int left = l, right = data[i][1], pos = right;
                while (left <= right) {
                    int mid = left + (right - left) / 2;
                    // 判断mid是否满足条件
                    int res = (x - data[i][0]) * (x - data[i][0]) + (mid - data[i][1]) * (mid - data[i][1]);
                    if (res > data[i][2] * data[i][2]) {
                        // 太远了
                        left = mid+1;
                    } else {
                        pos = mid;
                        right = mid-1;
                    }
                }

                for (int y = pos; y <= 2*data[i][1]-pos; y++) {
                    int key = (x - 1) * m + y;
                    // x,y 这块地啥时候被割的, -1就是还没被割过
                    Integer day = map.getOrDefault(key, -1);
                    cut += i - day;
                    // 标记在第i天被割过
                    map.put(key, i);
                }
            }

//            for (int x = u; x <= d; x++) {
//                for (int y = l; y <= r; y++) {
//                    if (Math.pow(x - data[i][0], 2) + Math.pow(y - data[i][1], 2) <= Math.pow(data[i][2], 2)) {
//                        int key = (x - 1) * m + y;
//                        // x,y 这块地啥时候被割的, -1就是还没被割过
//                        Integer day = map.getOrDefault(key, -1);
//                        cut += i - day;
//                        // 标记在第i天被割过
//                        map.put(key, i);
//                    }
//                }
//            }
        }
        System.out.println(n * m * k - cut);
    }
}
