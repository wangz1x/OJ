package com.wzx.access;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main12 {

    static Map<String, int[]> maps = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        for (int i = 0; i < n+1; i++) {
            String str = scanner.nextLine();
//            String str = scanner.nextLine();
            String[] ops = str.split(" ");
            dealRequest(ops);
        }
    }

    public static void dealRequest(String[] ops) {
        // Add PizzaHut 205 100
        // Add 205 100
        if ("Add".equals(ops[0]) && ops.length == 4) {
            maps.put(ops[1], new int[]{Integer.parseInt(ops[2]), Integer.parseInt(ops[3])});
        } else if ("Change".equals(ops[0]) && ops.length == 4) {   // Change PizzaHut 222 123
            if (maps.containsKey(ops[1])) {        // 只有包含的时候才移动
                maps.put(ops[1], new int[]{Integer.parseInt(ops[2]), Integer.parseInt(ops[3])});
            }
        } else if ("Delete".equals(ops[0]) && ops.length == 2) {      // Delete PizzaHut
            maps.remove(ops[1]);
        }
        else if ("Query".equals(ops[0]) && ops.length == 2) {
            if (maps.containsKey(ops[1])) {
                int[] pos = maps.get(ops[1]);
                System.out.println("yes");
                System.out.println(pos[0] + " " + pos[1]);
            } else {
                System.out.println("no");
            }
        }
    }
}
