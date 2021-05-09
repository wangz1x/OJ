package com.wzx.access;

import java.util.*;

public class Main100 {

    static int min = 0x7fffffff;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();
        int x,y,u,v,w;

        // x*1000 + y
        HashMap<Integer, HashMap<Integer, Integer>> map = new HashMap<>();

        for (int i = 0; i < k; i++) {
            x = scanner.nextInt();
            y = scanner.nextInt();
            u = scanner.nextInt();
            v = scanner.nextInt();
            w = scanner.nextInt();

            int source = x*1000+y;
            int target = u*1000+v;

            if (map.containsKey(source)) {
                HashMap<Integer, Integer> integerHashMap = map.get(source);
                if (integerHashMap.containsKey(target)) {
                    integerHashMap.put(target, Math.min(w, integerHashMap.get(target)));    // 两条路径里边选短的
                } else {
                    integerHashMap.put(target, w);
                }
            } else {
                HashMap<Integer, Integer> temp = new HashMap<>();
                temp.put(target, w);
                map.put(source, temp);
            }
        }
        // 从1,1开始，到n,m
        dfs(1,1,n,m,map,0);
        if (min == 0x7fffffff) {
            min = -1;
        }
        System.out.println(min);
    }

    // 从x,y 到 n,m,      sum 表示路径和
    public static void dfs(int x, int y, int n, int m, HashMap<Integer, HashMap<Integer, Integer>> map, int sum) {
        if (x == n && y == m) {  // 到了
            min = Math.min(min, sum);
            return;
        }
        int cur = x*1000+y;
        if (!map.containsKey(cur)) {  // 没法从x,y往后走了
            return;
        }

        HashMap<Integer, Integer> integerHashMap = map.get(cur);   // 从x,y能到达的所有点
        Set<Map.Entry<Integer, Integer>> entries = integerHashMap.entrySet();
        for (Map.Entry<Integer, Integer> entry : entries) {
            int target = entry.getKey();
            int newx = target/1000;
            int newy = target-newx*1000;
            int w = entry.getValue();
            dfs(newx, newy, n, m, map, sum+w);
        }
    }
}
