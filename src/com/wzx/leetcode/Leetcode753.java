package com.wzx.leetcode;

import java.util.HashSet;
import java.util.Set;

public class Leetcode753 {
    static Set<Integer> visited = new HashSet<>();
    // 保留当前路径的后n-1位，因为转移时会自动添加一位
    static int lowNsub1;
    static StringBuilder sb = new StringBuilder();

    public static String crackSafe(int n, int k) {
        lowNsub1 = (int) Math.pow(10, n-1);
        for (int i = 0; i < n-1; i++) {
            sb.append(0);
        }
        dfs(0, k);
        return sb.toString();
    }

    public static void dfs(int x, int k) {
        for (int i = k-1; i >= 0; i--) {
            int curVal = x * 10 + i;
            if (!visited.contains(curVal)) {
                visited.add(curVal);
                sb.append(i);
                dfs(curVal % lowNsub1, k);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(crackSafe(3, 2));
    }
}
