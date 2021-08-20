package com.wzx.access;

import java.util.*;

public class Main1 {

    static Map<String, Integer> hashmap = new HashMap<>();

    public static void main(String[] args) {
        int N;
        int[] parent;

        try (Scanner scanner = new Scanner(System.in)) {
            N = scanner.nextInt();
            parent = new int[N];

            for (int i = 0; i < N; i++) {
                parent[i] = i;
            }

            int idx = 0;
            for (int i = 0; i < N; i++) {
                String firstName = scanner.next();
                String secondName = scanner.next();

                int firstIdx = -1, secondIdx = -1;

                if (hashmap.containsKey(firstName)) {
                    firstIdx = hashmap.get(firstName);
                } else {
                    hashmap.put(firstName, idx);
                    firstIdx = idx++;
                }

                if (hashmap.containsKey(secondName)) {
                    secondIdx = hashmap.get(secondName);
                } else {
                    hashmap.put(secondName, idx);
                    secondIdx = idx++;
                }

                union(firstIdx, secondIdx, parent);
            }
        }

        Set<Integer> set = new HashSet<>();
        for (int par : parent) {
            set.add(par);         // 看有几个不同的爹，就有几组
        }
        System.out.println(set.size());
    }

    public static void union(int x, int y, int[] parent) {
        int x_parent = find(x, parent);
        int y_parent = find(y, parent);

        if (x_parent != y_parent) {       // 进行合并, x的祖先变为 y祖先的后代
            parent[x_parent] = y_parent;
        }
    }

    public static int find(int x, int[] parent) {
        while (x != parent[x]) {
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }
}
