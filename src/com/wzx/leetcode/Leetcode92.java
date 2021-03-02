package com.wzx.leetcode;

import java.util.List;

public class Leetcode92 {

    ListNode successor;
    public ListNode reverseAllNode(ListNode head) {
        if (head.next == null) return head;
        ListNode last = reverseAllNode(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

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

    public static void main(String[] args) {
        Leetcode92 leetcode92 = new Leetcode92();
        System.out.println(leetcode92.reverseFirstN(ListNode.head, 5));
    }
}
