package com.wzx.leetcode;

import com.wzx.util.ListNode;

public class Leetcode92 {

    // reverse the all list
    public ListNode reverseAllNode(ListNode head) {
        if (head.next == null) return head;
        ListNode last = reverseAllNode(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

    // reverse first n node in the list
    ListNode successor;
    public ListNode reverseFirstN(ListNode head, int n) {
        if (n == 1 || head.next == null) {
            successor = head.next;
            return head;
        }

        ListNode last = reverseFirstN(head.next, n-1);
        head.next.next = head;
        head.next = successor;
        return last;
    }

    // reverse list, include start, exclude end [ )
    public ListNode reverseInterval(ListNode start, ListNode end) {
        ListNode cur = start, pre = null, next;
        while (cur != end) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode end = head;
        for (int i = 0; i < k; i ++) {
            if (end == null || end.next == null) return head;
            end = end.next;
        }
        ListNode newHead = reverseInterval(head, end);
        head.next = reverseKGroup(end, k);
        return newHead;
    }

    public static void main(String[] args) {
        Leetcode92 leetcode92 = new Leetcode92();
        System.out.println(ListNode.head);
//        System.out.println(leetcode92.reverseFirstN(ListNode.head, 5));
        System.out.println(leetcode92.reverseKGroup(ListNode.head, 5));
    }
}
