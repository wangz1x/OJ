package com.wzx.access;

import java.util.HashSet;
import java.util.Random;

public class Test {
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();
        Random r = new Random();
        for (int i = 0; i < 10 ; i++ ) {
            set.add(r.nextInt());
        }

        for (int i = 0; i < 50 ; i++) {
            for (int j : set) {
                System.out.print(j + " ");
            }
            System.out.println();
        }

    }
}
