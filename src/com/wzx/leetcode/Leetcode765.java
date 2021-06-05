package com.wzx.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wangzx
 * @email wangzx22@163.com
 * @date 2021/5/29 上午11:38
 */
public class Leetcode765 {

    static int count = 1;

    public static void main(String[] args) {
        // [22, 13, 23, 5, 24, 14, 10, 15, 4, 16, 25, 11, 17, 2, 26, 18, 27, 8, 9, 28, 6, 19, 20, 3, 21, 1, 29, 0, 7, 12]
        int[] row = {22, 13, 23, 5, 24, 14, 10, 15, 4, 16, 25, 11, 17, 2, 26, 18, 27, 8, 9, 28, 6, 19, 20, 3, 21, 1, 29, 0, 7, 12};
//        System.out.println(minSwapsCouples(row));
        System.out.println(0x80000000);
    }

    public static int minSwapsCouples(int[] row) {
        // 0~len(row)的全排列，
        int len = row.length;
        int n = len >> 1;

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < len; i++) {
            map.put(row[i], i);                // 保存每个点和其对应的index
        }

        int[][] edges = new int[n][n];         // 组与组之间的边

        for (int i = 0; i < len; i += 2) {
            if (Math.abs(row[i] - row[i + 1]) != 1 || (((row[i] + row[i + 1]) >> 1) & 1) == 1) {    // 除以二为奇数，说明不是一对

                int idx1, idx2;
                if ((row[i] & 1) == 1) {         // 为奇数，和row[i]-1配对
                    idx1 = map.get(row[i] - 1) >> 1;
                } else {                       // 为偶数, 和row[i]+1配对
                    idx1 = map.get(row[i] + 1) >> 1;
                }

                if ((row[i + 1] & 1) == 1) {
                    idx2 = map.get(row[i + 1] - 1) >> 1;
                } else {
                    idx2 = map.get(row[i + 1] + 1) >> 1;
                }

                // 无向图
                edges[i / 2][idx1] = 1;
                edges[idx1][i / 2] = 1;
                edges[i / 2][idx2] = 1;
                edges[idx2][i / 2] = 1;
            }
        }

        boolean[] visited = new boolean[n];           // n个分组
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(edges, i, visited);
            }
            res += count - 1;
            count = 1;
        }
        return res;
    }

    public static void dfs(int[][] edges, int cur, boolean[] visited) {
        if (!visited[cur]) {
            visited[cur] = true;
        }
        for (int i = 0; i < edges.length; i++) {
            if (!visited[i] && edges[cur][i] == 1) {
                count++;
                dfs(edges, i, visited);
            }
        }
    }
}
