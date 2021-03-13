package com.wzx.test;

import com.wzx.util.ListNode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class AddRepeate {
    public static void main(String[] args) {
        Deque<ListNode> deque = new ArrayDeque<>();
        ListNode l = new ListNode(12);

        deque.offer(l);
        deque.offer(l);
        deque.offer(l);
        deque.offer(l);

        System.out.println(deque.size());

        System.out.println(deque.poll());
        System.out.println(deque.poll());
        System.out.println(deque.poll());

        System.out.println(deque.size());

        String a = "1,2,3,4,5,";
        System.out.println(Arrays.toString(a.split(",")));

    }
}
