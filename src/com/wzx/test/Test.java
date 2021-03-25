package com.wzx.test;

import java.util.Set;
import java.util.TreeSet;

public class Test {
    public static void main(String[] args) {
        Set<Integer> treeset = new TreeSet<>();
        Set<Integer> treeset2 = new TreeSet<>();
        treeset.add(0);
        treeset2 = treeset;
        for (int i = 0; i < 10; i++) {
            treeset.add(i);
        }
        System.out.println(treeset2);
    }
}
