package com.wzx.access;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Didi_0912_01 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), m = in.nextInt();

        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            int ele = in.nextInt();
            if (heap.size() < m) {
                heap.offer(ele);
            } else if (ele >= heap.peek()) {
                heap.offer(ele);
                heap.poll();
            }
        }
        long sum = 0;
        for (int ele : heap) {
            sum += ele;
        }
        System.out.println(sum);
    }
}
