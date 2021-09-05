package com.wzx.access;

import java.util.*;

public class Net_0828_02 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 数据组数
        int T = in.nextInt();
        for (int i = 0; i < T; i++) {
            // N个任务
            int N = in.nextInt();
            // 第i个任务的耗时
            int[] cost = new int[N];
            // 第i个任务的依赖数
            int[] count = new int[N];
            // 依赖于key的所有任务
            HashMap<Integer, List<Integer>> depends = new HashMap<>();
            // 工作队列，当前依赖数为0，可直接执行
            Deque<Integer> work = new LinkedList<>();
            // 当前工作队列中的最长的任务
            int max = 0x80000000;
            for (int j = 0; j < N; j++) {
                // 格式为 时间，前置任务个数，具体的前置任务
                cost[j] = in.nextInt();
                count[j] = in.nextInt();
                if (count[j] > 0) {
                    for (int k = 0; k < count[j]; k++) {
                        // 注意这里输入依赖任务时是从1开始的，但是我的任务编号是从0开始的
                        int key = in.nextInt() - 1;
                        List<Integer> depend = depends.getOrDefault(key, new ArrayList<>());
                        // 当前为第j个任务，依赖于第key个任务
                        depend.add(j);
                        depends.put(key, depend);
                    }
                } else {
                    // 否则第j个任务没有依赖，可直接执行
                    work.offer(j);
                    max = Math.max(max, cost[j]);
                }
            }
            System.out.println(deal(depends, cost, count, work, max));
        }
    }

    public static long deal(HashMap<Integer, List<Integer>> depends, int[] cost, int[] count, Deque<Integer> work, int max) {
        // 先考虑把其他用时少的任务做了，再考虑
        long res = 0L;
        // 当任务队列不为空时
        while (!work.isEmpty()) {
            int size = work.size();
            // 这一轮要处理的个数
            while (size > 0) {
                int cur = work.poll();
                // 留给后边任务的时间 max-cost[cur]
                dfs(depends, cost, count, cur, max - cost[cur], work);
                size--;
            }
            res += max;
            max = 0x80000000;
            // 再找现在队列中用时最长的任务
            for (int ele : work) {
                max = Math.max(max, cost[ele]);
            }
        }
        return res;
    }

    public static void dfs(HashMap<Integer, List<Integer>> depends, int[] cost, int[] count, int cur, int max, Deque<Integer> work) {
        // 如果有其他任务依赖于当前正在处理的任务
        if (depends.containsKey(cur)) {
            List<Integer> depend = depends.get(cur);
            // 遍历所有有依赖的任务
            for (int ele : depend) {
                count[ele]--;
                if (count[ele] == 0 && cost[ele] <= max) {
                    // 此时这个任务可以在队列里最耗时任务执行的同时，偷偷的执行
                    dfs(depends, cost, count, ele, max - cost[ele], work);
                } else if (count[ele] == 0) {
                    // 虽然这个任务没有依赖了，但没法在当前队列最耗时任务执行过程中偷偷的执行，只能执行一段
                    cost[ele] -= max;
                    // 只能是下一轮在执行了
                    work.offer(ele);
                }
            }
        }
    }
}
