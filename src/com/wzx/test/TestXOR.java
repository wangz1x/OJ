package com.wzx.test;

import java.util.*;

public class TestXOR {
    public static void main(String[] args) {
        Queue<Object> objects = new PriorityQueue<>();
        objects.add(5);
        objects.add(2);
        objects.add(3);
        objects.add(4);
        System.out.println(objects);
        System.out.println(objects.peek());
        Iterator<Object> iterator = objects.iterator();
    }
}
