package com.wzx.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Leetcode5563 {
    public static void main(String[] args) {
        Leetcode5563 l = new Leetcode5563();
        int[] inv = {1000000000};
        System.out.println(l.maxProfit(inv, 1000000000));
    }

    public int maxProfit(int[] inventory, int orders) {

        Map<Integer, Integer> map = new HashMap<>();

        long sum = 0;
        // value : count
        for (int i = 0; i < inventory.length; i++) {
            if (map.containsKey(inventory[i])) {
                map.put(inventory[i], map.get(inventory[i]) + 1);
            } else {
                map.put(inventory[i], 1);
            }
            sum += inventory[i];
        }

        int not0 = inventory.length;
        int[] start = new int[inventory.length];
        Arrays.fill(start, 1);
        long remainders = sum - orders;

        while (remainders != 0) {

            long avgSub = remainders / not0 == 0 ? 1 : remainders / not0;

            for (int i = 0; i < inventory.length; i++) {
                if (inventory[i] >= start[i]) {
                    if (inventory[i] - start[i] + 1 >= avgSub) {
                        start[i] += avgSub;
                        remainders -= avgSub;
                    } else {
                        remainders -= inventory[i] - start[i] + 1;
                        start[i] = inventory[i] + 1;
                    }

                    if (remainders == 0) {
                        break;
                    }

                    if (inventory[i] + 1 == start[i]) {
                        not0--;
                    }
                }
            }
        }

        long ret = 0;
        for (int i = 0; i < inventory.length; i++) {
            // valid
            if (inventory[i] - start[i] + 1 > 0) {
                ret += (long) (inventory[i] + start[i]) * (long) (inventory[i] - start[i] + 1) / 2L;
            }
        }
        return (int) (ret % (1000000007));
    }
}
