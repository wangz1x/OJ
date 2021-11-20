package com.wzx.access;

import java.util.*;

public class Huawei_0922_02 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), max = 0;
        int[] v = new int[n];
        int[] t = new int[n];
        int[] d = new int[n];

        for (int i = 0; i < n; i++) {
            v[i] = in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            t[i] = in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            d[i] = in.nextInt();
            max = Math.max(max, d[i]);
        }

        // 前i天，只考虑前j个任务，取得的最大价值
        int[][] dp = new int[max + 1][n + 1];

        // 遍历最后期限
        for (int i = 1; i < max + 1; i++) {

            // 遍历n个任务
            for (int j = 1; j < n + 1; j++) {
                if (d[j - 1] >= i && i - t[j - 1] >= 0) {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - t[j - 1]][j - 1] + v[j - 1]);
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }
        System.out.println(dp[max][n]);
    }

    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> cnt = new HashMap<String, Integer>();
        for (String word : words) {
            cnt.put(word, cnt.getOrDefault(word, 0) + 1);
        }
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<Map.Entry<String, Integer>>(
                new Comparator<Map.Entry<String, Integer>>() {
                    public int compare(Map.Entry<String, Integer> entry1, Map.Entry<String, Integer> entry2) {
                        return entry1.getValue() == entry2.getValue() ?
                                entry2.getKey().compareTo(entry1.getKey()) :
                                entry1.getValue() - entry2.getValue();
                    }
                });
        for (Map.Entry<String, Integer> entry : cnt.entrySet()) {
            pq.offer(entry);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        List<String> ret = new ArrayList<String>();
        while (!pq.isEmpty()) {
            ret.add(pq.poll().getKey());
        }
        Collections.reverse(ret);
        return ret;
    }

}
