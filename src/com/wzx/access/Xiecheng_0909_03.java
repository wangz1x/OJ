package com.wzx.access;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class Xiecheng_0909_03 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), m = in.nextInt();
        in.nextLine();
        String data = in.nextLine();
        Map<Integer, Integer> scores = new HashMap<>();
        for (int i = 0; i < m; i++) {
            int key = in.nextInt(), value = in.nextInt();
            int def = scores.getOrDefault(key, 0);
            scores.put(key, Math.max(def, value));
        }

        // 记录所有连续的1的长度
        Map<Integer, Integer> deals = new HashMap<>();
        char[] cs = data.toCharArray();
        int count = 0, max = 0;
        for (int i = 0; i < cs.length; i++) {
            if (cs[i] == '1') count++;
            else {
                max = Math.max(max, count);
                int def = deals.getOrDefault(count, 0);
                deals.put(count, def+1);
                count = 0;
            }
        }
        if (count != 0) {
            max = Math.max(max, count);
            int def = deals.getOrDefault(count, 0);
            deals.put(count, def+1);
        }

        //
        int[] dp = new int[max+1];
        for (Map.Entry<Integer, Integer> entry : scores.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            for (int i = 0; i < max+1; i++) {
                if (i >= key) {
                    dp[i] = Math.max(dp[i], dp[i-key]+value);
                }
            }
        }
        int res = 0;
        for (Map.Entry<Integer, Integer> entry : deals.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            res += value * dp[key];
        }
        System.out.println(res);
    }
}
