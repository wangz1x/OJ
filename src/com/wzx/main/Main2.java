package com.wzx.main;


import java.util.Arrays;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt(); //人的数量
        int val, res = -1;
        int[] cache = new int[10001];

        Arrays.fill(cache, -1);

        for (int i = 0; i < n; i++) {
            val = input.nextInt();
            if (cache[val] != -2) {           //  已经有重复的了，不用考虑val了
                if (cache[val] != -1) {       // 已经有人要价val了
                    cache[val] = -2;
                } else {                      // 第一次要加 val
                    cache[val] = 1;
                }
            }
        }

        for (int i = 0; i < 10001; i++) {
            if (cache[i] == 1) {
                res = i;
                break;
            }
        }
        System.out.println(res);
    }
}