package com.wzx.access;

import java.util.*;

public class IQiYi_0801_3 {
    public static void main(String[] args) {

        int[] test1 = {1, 2, 1, 0, 2, 1};
        deal(test1);
    }

    public static void deal(int[] list) {
        int[] res = new int[list.length];
        int[] wrong = new int[0];

        Set<Integer> rains = new HashSet<>();
        Deque<Integer> empties = new LinkedList<>();

        for (int i = 0; i < list.length; i++) {
            int ele = list[i];
            // ele号湖泊要装水了
            if (ele > 0) {
                res[i] = -1;
                // ele 号湖泊没有下过雨
                if (!rains.contains(ele)) {
                    rains.add(ele);
                } else {
                    // ele 号已经下过雨了，需要前边的某一天进行抽水
                    if (!empties.isEmpty()) {
                        int day = empties.poll();
                        res[day] = ele;
                    } else {
                        // 前边没有空抽水，那gg
                        res = wrong;
                        break;
                    }
                }
            } else {
                empties.offer(i);
            }
        }

        for (int ele : res) {
            System.out.print(ele + " ");
        }
    }
}
