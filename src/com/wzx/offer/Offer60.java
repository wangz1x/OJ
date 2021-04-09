package com.wzx.offer;

import java.util.Arrays;

public class Offer60 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(dicesProbability(2)));
    }

    public static double[] dicesProbability(int n) {
        // 1, 2, 3, 4, 5, 6
        //    2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12
        //       3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18
        // n个骰子，最小为 n, 最大为 6n
        double prob = 1.0/6.0;

        double[] poss = new double[]{prob, prob, prob, prob, prob, prob};

        int round = 1;
        while (round < n) {
            double[] temp = new double[6*(round+1) - (round+1) + 1];    //
            for (int i = 0; i < 6; i++) {    // 第k+1个骰子的数
                for (int j = 0; j < poss.length; j++) {
                    temp[i+j] += prob*poss[j];
                }
            }
            round++;
            poss = temp;
        }
        return poss;
    }
}
