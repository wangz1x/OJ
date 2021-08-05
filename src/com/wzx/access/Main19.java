package com.wzx.access;

import java.util.*;

public class Main19 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();

        boolean toM = false;

        int[][] deps = new int[N][N];
        int[] count = new int[N];
        int[] count2 = new int[N];
        //         依赖于key的服务的列表
        Map<Integer, List<Integer>> depends = new HashMap<>();

        int T, d;
        for (int i = 0; i < N; i++) {
            T = scanner.nextInt();
            count[i] = T;
            count2[i] = T;
            if (T != 0) {
                for (int j = 0; j < T; j++) {
                    d = scanner.nextInt();
                    deps[i][d] = 1;               // i 依赖于d

                    if (depends.containsKey(d)) {
                        depends.get(d).add(i);
                    } else {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(i);
                        depends.put(d, temp);
                    }
                }
            }
        }
        if (count[M] == 0) {
            System.out.println("null");
            return;
        }
        // init
        Deque<Integer> visited = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            if (count[i] == 0) {          // i 可以visited
                visited.offer(i);
            }
        }

        while (!visited.isEmpty()) {
            int node = visited.poll();         // 取出一个
            if (node == M) {
                toM = true;
                break;
            }
            if (depends.containsKey(node)) {
                List<Integer> nodes = depends.get(node);      // 这些节点的依赖数都减一
                for (int no : nodes) {
                    count[no]--;
                    if (count[no] == 0) {
                        visited.offer(no);
                    }
                }
            }
        }

        if (!toM) {
            System.out.println(-1);
        } else {
            Set<Integer> sets = new HashSet<>();
            dfs(sets, deps, M, count2);
            for (int i = 0; i < N - 1; i++) {
                if (sets.contains(i)) {
                    System.out.print(i + " ");
                }
            }
            if (sets.contains(N - 1)) {
                System.out.print(N - 1);
            }
        }
    }

    public static void dfs(Set<Integer> depends, int[][] deps, int M, int[] count) {
        if (count[M] == 0) return;               // M没有依赖的
        for (int i = 0; i < deps.length; i++) {
            if (deps[M][i] == 1) {
                depends.add(i);
                dfs(depends, deps, i, count);
            }
        }
    }
}
