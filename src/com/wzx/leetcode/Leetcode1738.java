package com.wzx.leetcode;

import java.util.PriorityQueue;

/**
 * @author wangzx
 * @email wangzx22@163.com
 * @date 2021/5/19 下午8:25
 */
public class Leetcode1738 {

    public static void main(String[] args) {
        int[][] arr = {{5,2}, {1,6}};
        System.out.println(kthLargestValue(arr, 1));
    }

    public static int kthLargestValue(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] prefix = new int[m + 1][n + 1];

        // 最小堆, 超了要删除最小的
        PriorityQueue<Integer> pq = new PriorityQueue<>(k + 1);

        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                prefix[i][j] = prefix[i - 1][j] ^ prefix[i][j - 1] ^ prefix[i - 1][j - 1] ^ matrix[i - 1][j - 1];
                pq.add(prefix[i][j]);
                if (pq.size() > k) {
                    pq.poll();           // 移除最小的
                }
            }
        }
        return pq.isEmpty() ? 0 : pq.peek();
    }
}
