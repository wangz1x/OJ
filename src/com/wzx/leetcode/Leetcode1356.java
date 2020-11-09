package com.wzx.leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class Leetcode1356 {
    public static void main(String[] args) {

    }
    public int[] sortByBits(int[] arr) {
        List<Integer> ls = new ArrayList<>();
        for (int ar : arr) {
            ls.add(ar);
        }

        ls.sort((o1, o2) -> {
            int bit1 = Integer.bitCount(o1);
            int bit2 = Integer.bitCount(o2);
            return bit1 == bit2 ? o1 - o2 : bit1 - bit2;
        });

        int po = 0;
        for (int in : ls) {
            arr[po++] = in;
        }
        return arr;
    }

    public int[] sortByBitsStream(int[] arr) {
        return Arrays.stream(arr).boxed()
                .sorted((o1, o2) -> {
                    int b1 = Integer.bitCount(o1);
                    int b2 = Integer.bitCount(o2);
                    return b1==b2?o1-o2:b1-b2;
                })
                .collect(Collectors.toList())
                .stream().mapToInt(i->i)
                .toArray();
    }
}
