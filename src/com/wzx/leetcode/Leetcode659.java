package com.wzx.leetcode;

import java.util.*;

public class Leetcode659 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 3, 4, 4, 5, 5};
        System.out.println(isPossible(arr));
    }

    public static boolean isPossible(int[] nums) {
        Map<Integer, List<PriorityQueue<Integer>>> cache = new HashMap<>();

        for (int num : nums) {
            if (cache.containsKey(num - 1) && cache.get(num - 1).size() > 0) {
                List<PriorityQueue<Integer>> priorityQueues = cache.get(num - 1);
                int max = priorityQueues.get(0).peek();
                int idx = 0;
                for (int j = 0; j < priorityQueues.size(); j++) {
                    if (max < priorityQueues.get(j).peek()) {
                        max = priorityQueues.get(j).peek();
                        idx = j;
                    }
                }

                PriorityQueue<Integer> integers = priorityQueues.get(idx);
                integers.add(num);
                if (cache.containsKey(num)) {
                    cache.get(num).add(integers);
                } else {
                    List<PriorityQueue<Integer>> tempQueues = new LinkedList<>();
                    tempQueues.add(integers);
                    cache.put(num, tempQueues);
                }
                priorityQueues.remove(idx);
            } else if (cache.containsKey(num) && cache.get(num).size() > 0) {
                cache.get(num).add(new PriorityQueue<>(Collections.singletonList(num)));
            } else {
                List<PriorityQueue<Integer>> tempQueues = new LinkedList<>();
                PriorityQueue<Integer> integers = new PriorityQueue<>();
                integers.add(num);
                tempQueues.add(integers);
                cache.put(num, tempQueues);
            }
        }

        Set<Map.Entry<Integer, List<PriorityQueue<Integer>>>> entries = cache.entrySet();
        for (
                Map.Entry<Integer, List<PriorityQueue<Integer>>> next : entries) {
            int end = next.getKey();

            for (PriorityQueue<Integer> p : next.getValue()) {
                if (end - p.peek() < 2) return false;
            }
        }
        return true;
    }
}
