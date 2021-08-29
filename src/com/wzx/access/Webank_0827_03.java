package com.wzx.access;

import java.util.*;

public class Webank_0827_03 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), weight;

        Map<Integer, Integer> chicken = new HashMap<>();
        Set<Integer> treeSet = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            weight = in.nextInt();
            Integer orDefault = chicken.getOrDefault(weight, 0);
            chicken.put(weight, orDefault+1);
            treeSet.add(weight);
        }

        // 当前需要的重量
        int cur = 1;
        // 从最小的开始吃
        for (int ele : treeSet) {
            // 获取当前最小重量的鸡的个数
            Integer integer = chicken.get(ele);

            // 当前重量只能吃一次
            if (ele == cur) {
                cur++;
            } else {
                // 可以吃多天
                while (ele >= cur && integer > 0) {
                    cur++;
                    integer--;
                }
            }
        }
        System.out.println(cur);
    }
}
