package com.wzx.access;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class JD_0911_03 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            int key = in.nextInt(), value = in.nextInt();
            int ele = map.getOrDefault(key, 0);
            map.put(key, ele+value);
        }

        int min = 0, attack = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey(), value = entry.getValue();
            if (attack < key) {
                min += key-attack;
                attack = key;
            }
            attack += value;
        }
        System.out.println(min);
    }
}
