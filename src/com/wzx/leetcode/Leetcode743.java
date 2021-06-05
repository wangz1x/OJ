package com.wzx.leetcode;

/**
 * @author wangzx
 * @email wangzx22@163.com
 * @date 2021/5/28 下午9:21
 */
public class Leetcode743 {

    public static void main(String[] args) {
        int[][] times = {{1,2,1}, {2,3,2}, {1,3,2}};
        System.out.println(networkDelayTime(times, 3, 1));
    }

    public static int networkDelayTime(int[][] times, int n, int k) {
        // 深度遍历最长的路径
        int[][] distances = new int[n+1][n+1];
        int next, shortest, res = -1;
        for (int[] time : times) {
            distances[time[0]][time[1]] = time[2];
        }

        // dijstral: 从k到所有点的最短距离
        boolean[] visited = new boolean[n+1];
        visited[k] = true;

        // 要找这么多次
        for (int i = 1; i < n+1; i++) {
            next = 0;
            shortest = 0x7fffffff;

            // 从没遍历过得点中，找最短路径
            for (int j = 1; j < n+1; j++) {
                if (!visited[j] && distances[k][j] > 0 && distances[k][j] < shortest) {
                    next = j;
                    shortest = distances[k][j];
                }
            }

            if (next == 0) {          // 存在无法到达的点
                break;
            }
            visited[next] = true;

            // 以next为中介点
            for (int j = 1; j < n+1; j++) {
                if (distances[k][next] > 0 && distances[next][j] > 0 && (distances[k][next]+distances[next][j] < distances[k][j]
                        || distances[k][j] == 0)) {
                    distances[k][j] = distances[k][next]+distances[next][j];
                }
            }
        }
        for (int i = 1; i < n+1; i++) {
            if (k != i && distances[k][i] == 0) {
                res = -1;
                break;
            }
            res = Math.max(res, distances[k][i]);
        }
        return res;
    }
}
