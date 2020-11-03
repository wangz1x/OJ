package com.wzx.leetcode;

public class Leetcode19 {


    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }


    public static void main(String[] args) {
        ListNode root = new ListNode(1, new ListNode(2, null));
        System.out.println(removeNthFromEnd(root, 1));
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || head.next == null) return null;

        ListNode t = head;
        int count = 0;
        while (t != null) {
            count++;
            t = t.next;
        }
        if (count == n) return head.next;

        count = count - n;
        t = head;
        ListNode next = t.next;

        int begin = 1;
        while (begin != count) {
            t = t.next;
            next = t.next;
            begin++;
        }
        t.next = next.next;
        return head;
    }
}
