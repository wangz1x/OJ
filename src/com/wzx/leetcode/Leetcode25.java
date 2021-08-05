package com.wzx.leetcode;

import com.wzx.util.ListNode;

/**
 * @author wangzx
 * @email wangzx22@163.com
 * 翻转链表以及每k个翻转链表
 */
public class Leetcode25 {

    public static void main(String[] args) {
        System.out.println("origin: " + ListNode.head);
        ListNode reverse = reverse(ListNode.head, null);
        System.out.println("reverse: "  + reverse);
        System.out.println("reverseRecurse: " + reverseRecurse(ListNode.head));
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return head;
        ListNode end = head;
        for (int i = 0; i < k; i++) {
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

    public static ListNode reverseRecurse(ListNode node) {

        return node;
    }
}
