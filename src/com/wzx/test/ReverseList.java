package com.wzx.test;

public class ReverseList {
    public static ListNode reverseFirstNode(ListNode head, int n) {
        return dfs(head, head, n);
    }

    public static ListNode dfs(ListNode first, ListNode head, int n) {
        if (head.next == null) return head;
        if (n == 1) first.next = head.next;
        if (n > 1) {
            ListNode last = dfs(first, head.next, n - 1);
            head.next.next = head;
            head.next = null;
            return last;
        }
        return head;
    }

    public static ListNode reverseAll(ListNode head) {
        if (head.next == null) return head;
        ListNode last = reverseAll(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

    public static ListNode reverseDirect(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode p = dummy, q = dummy.next;
        while (n > 0 && q != null) {
            ListNode temp = q.next;
            q.next = p;
            p = q;
            q = temp;
            n--;
        }
        assert dummy.next != null;
        dummy.next.next = q;
        return p;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null)))));
//        System.out.println(reverseAll(head));
//        System.out.println(reverseFirstNode(head, 3));
        System.out.println(reverseDirect(head, 6));
    }
}
