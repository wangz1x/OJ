package com.wzx.access;











import java.util.*;
public class Huawei_0825_03 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int[] cost = new int[n];
        Map<Integer, List<Integer>> depends = new HashMap<>();
        int[] counts = new int[n];
        for (int i = 0; i < n; i++) {
            String next = in.next();
            String[] splits = next.split(",");
            List<Integer> depend = new ArrayList<>();

            if (Integer.parseInt(splits[0]) == -1) {
                counts[i] = 0;
            } else {
                for (String split : splits) {
                    int de = Integer.parseInt(split);
                    List<Integer> list = depends.getOrDefault(de, new ArrayList<>());
                    list.add(i);
                    depends.put(de, list);
                }
                counts[i] = splits.length;
            }
            cost[i] = in.nextInt();
        }

        Deque<Integer> deque = new LinkedList<>();

        int max = 0, sum = 0;
        for (int i = 0; i < n; i++) {
            if (counts[i] == 0) {
                max = Math.max(max, cost[i]);
                deque.add(i);
            }
        }

        while (!deque.isEmpty()) {
            int size = deque.size();
            sum += max;
            while (size > 0) {
                int idx = deque.poll();
                dfs(cost, counts, depends, cost[idx], max, idx, deque);
                size--;
            }
            max = 0;
            for (int ele : deque) {
                max = Math.max(max, cost[ele]);
            }
        }

        boolean success = true;
        for (int count : counts) {
            if (count != 0) {
                success = false;
                System.out.println(-1);
                break;
            }
        }
        if (success) {
            System.out.println(sum);
        }
    }

    public static void dfs(int[] cost, int[] counts, Map<Integer, List<Integer>> depends, int temp, int max, int idx, Deque<Integer> deque) {

        if (depends.containsKey(idx)) {
            List<Integer> list = depends.get(idx);
            for (int ele : list) {
                counts[ele]--;
                if (counts[ele] == 0 && temp + cost[ele] <= max) {
                    dfs(cost, counts, depends, temp + cost[ele], max, ele, deque);
                } else if (counts[ele] == 0 && temp + cost[ele] > max) {
                    cost[ele] -= max-temp;
                    deque.offer(ele);
                }
            }
        }
    }
}
