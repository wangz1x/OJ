package com.wzx.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Leetcode460 {
    int capacity;
    Map<Integer, Node> map = new HashMap<>();
    Node head;
    Node tail;

    public static void main(String[] args) {
        Leetcode460 leetcode460 = new Leetcode460(2);
        leetcode460.put(1, 1);
        leetcode460.put(2, 2);
        leetcode460.get(1);
        leetcode460.put(3, 3);
        leetcode460.get(2);
        leetcode460.get(3);
        leetcode460.put(4, 4);
        leetcode460.get(1);
        leetcode460.get(3);
        leetcode460.get(4);
    }

    // head -- node1 -- node2 -- node3 -- tail
    // 新的放前边，旧的放后边
    public Leetcode460(int capacity) {
        this.capacity = capacity;
        head = new Node(0, -1);
        tail = new Node(0, -1);
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        int ret = -1;
        if (map.containsKey(key)) {
            Node temp = map.get(key);
            ret = temp.val;
            temp.cnt++;
            // modify this node, and move to a proper position
            head.moveIfNecessary(temp, head);
        }
        System.out.println("ret: " + ret);
        return ret;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node cur = map.get(key);
            cur.val = value;
            cur.cnt++;
            head.moveIfNecessary(cur, head);
        } else {
            if (map.size() == capacity) {   // 先删除
                Node del = tail.pre;
                del.pre.next = tail;
                tail.pre = del.pre;
                del.next = null;
                del.pre = null;
                map.remove(del.key);
            }
            Node cur = new Node(key, value);
            map.put(key, cur);
            Node pre_tail = tail.pre;
            pre_tail.next = cur;
            cur.pre = pre_tail;
            cur.next = tail;
            tail.pre = cur;
            head.moveIfNecessary(cur, head);
        }
    }


    class Node {
        Node pre;
        Node next;

        int key;
        int val;
        int cnt;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
            this.cnt = 1;
        }

        public void moveIfNecessary(Node temp, Node head) {
            Node cur = temp;
            while (temp != head && temp.cnt <= cur.cnt) {
                temp = temp.pre;
            }
            if (temp.next != cur) {
                // put cur after temp
                Node after_temp = temp.next;
                Node pre_cur = cur.pre;

                temp.next = cur;
                cur.pre = temp;

                pre_cur.next = cur.next;
                cur.next.pre = pre_cur;

                cur.next = after_temp;
                after_temp.pre = cur;
            }
        }
    }
}
