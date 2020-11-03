package com.wzx.leetcode;

public class Leetcode25 {
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1,new ListNode(2, new ListNode(3, null)));
        System.out.println(reverseKGroup(head, 3));
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k == 1) return head;

        ListNode p = head;
        int len = 1;
        while (p != null && len++ < k) p=p.next;
        if (len < k || p == null) return head;

        ListNode pre = head;
        ListNode next = head.next;
        ListNode nextNext;

        // p is new head
        while (pre != p && next != null) {
            nextNext = next.next;
            next.next = pre;
            pre = next;
            next = nextNext;
        }
        head.next = reverseKGroup(next, k);
        return p;
    }
}
