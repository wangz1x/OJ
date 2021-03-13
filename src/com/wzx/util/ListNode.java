package com.wzx.util;

public class ListNode {
    public int val;
    public ListNode next;

    public static ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6, new ListNode(7, new ListNode(8, new ListNode(18, new ListNode(28, new ListNode(38,
            new ListNode(48, new ListNode(58, new ListNode(68, new ListNode(78, new ListNode(88, null))))))))))))))));

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public String toString() {
        return val + "->" + next;
    }
}
