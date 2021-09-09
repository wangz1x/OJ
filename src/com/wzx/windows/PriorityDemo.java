package com.wzx.windows;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityDemo {

    public static void main(String[] args) {
        PriorityQueue<double[]> queue = new PriorityQueue<>((o1, o2) -> {
            double diff = o1[0] - o2[0];
            if (diff > 0) {
                return 1;
            } else if (diff < 0) {
                return -1;
            } else {
                return 0;
            }
        });
        queue.add(new double[]{0.9, 0.9, 1});
        queue.add(new double[]{0.92, 0.92, 1});
        queue.add(new double[]{0.94, 0.94, 1});
        queue.add(new double[]{0.92, 0.92, 1});
        queue.add(new double[]{0.95, 0.95, 1});

        int k = 5;
        while (k > 0) {
            double[] poll = queue.poll();
            assert poll != null;
            poll[2]++;
            poll[0] = 1-Math.pow(1-poll[1], poll[2]);
            queue.offer(poll);
            k--;
        }
        for (double[] doubles : queue) {
            System.out.println(doubles[0]);
        }
    }
}
