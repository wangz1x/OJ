package com.wzx.access;


import java.util.*;

public class Main2 {
    public static void main(String[] args) {
        Map<Integer, Integer> hashmap1 = new HashMap<>();        // 各任务额外依赖了几个任务
        Map<Integer, List<Integer>> hashmap2 = new HashMap<>();   // 存储依赖关系, 依赖key的有哪些
        int N;
        try (Scanner scanner = new Scanner(System.in)) {
            String allTime = scanner.next();
            String[] allTimes = allTime.split(",");
            N = allTimes.length;
            int[] times = new int[N];
            Deque<Integer> deque = new LinkedList<>();

            for (int i = 0; i < N; i++) {
                times[i] = Integer.parseInt(allTimes[i]);
                deque.offer(i);                  // 依次把任务加到队列里边
            }

            String dep = scanner.next();
            String[] deps = dep.split(",");
            for (String depss : deps) {          // 处理依赖关系
                String[] idx = depss.split("->");
                int first = Integer.parseInt(idx[0]);
                int second = Integer.parseInt(idx[1]);

                // first依赖second, first的依赖数+1
                hashmap1.put(first, hashmap1.getOrDefault(first, 0) + 1);

                if (hashmap2.containsKey(second)) {
                    hashmap2.get(second).add(first);
                } else {
                    List<Integer> list = new ArrayList<>();
                    list.add(first);
                    hashmap2.put(second, list);
                }
            }

            int curWaitTime = 0;               // 当前已经过了多久
            int[] waitTimes = new int[N];      // 记录各个任务的完成等待时间
            while (!deque.isEmpty()) {         // 循环队列
                int curTask = deque.poll();
                // 如果当前任务可执行
                if (!hashmap1.containsKey(curTask) || hashmap1.get(curTask) == 0) {
                    curWaitTime += times[curTask];
                    waitTimes[curTask] = curWaitTime;

                    // 看有没有依赖当前任务的任务
                    List<Integer> waiters;
                    if (hashmap2.containsKey(curTask) && (waiters = hashmap2.get(curTask)).size() > 0) {
                        for (int waiter : waiters) {        // 依赖当前任务的任务 的 依赖数 -1
                            if (hashmap1.containsKey(waiter)) {
                                int depends = hashmap1.get(waiter);
                                if (depends == 1) {    // 只用等待一个, 那必是当前任务, 不用在等了
                                    hashmap1.remove(waiter);
                                } else {
                                    hashmap1.put(waiter, depends-1);
                                }
                            }
                        }
                    }
                } else {
                    deque.offer(curTask);          // 把不能执行的任务加到最后取
                }
            }
            for (int i = 0; i < waitTimes.length-1; i++) {
                System.out.print(waitTimes[i]+",");
            }
            System.out.print(waitTimes[N-1]);
        }
    }
}
