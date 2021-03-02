package com.wzx.leetcode;

import java.util.List;

public class Leetcode25 {

    public static void main(String[] args) {
        System.out.println(reverseKGroup(ListNode.head, 5));
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return head;
        ListNode end = head;
        for (int i = 0; i < k; i++) {
//            if (end == null) {
//                return reverse(head, end);
//            }
            if (end != null)
                end = end.next;
        }

        ListNode newHead = reverse(head, end);
        head.next = reverseKGroup(end, k);
        return newHead;
    }

    // reverse [a, b)
    public static ListNode reverse(ListNode a, ListNode b) {
        ListNode pre, cur, next;
        pre = null;
        cur = a;
        while (cur != b) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
