package com.wzx.leetcode;

public class Leetcode148 {

    public static void main(String[] args) {
        ListNode root = new ListNode(4, new ListNode(2, new ListNode(1, new ListNode(3, null))));
        System.out.println(sortList(root));
    }

    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode dummy = new ListNode(0, head);
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }

        int subLen = 1;

        while (subLen < length) {
            int step = subLen;
            subLen = 2 * subLen;

            // deal with each piece
            ListNode slow;
            ListNode fast;
            head = dummy;

            // take fast as the next piece dummy;
            while (head != null) {
                // init head
                slow = head;
                fast = head;
                int count = 0;
                while (count++ < step) {
                    if (slow != null) slow = slow.next;
                    if (fast != null && fast.next != null) {
                        fast = fast.next.next;
                    } else {
                        fast = null;
                    }
                }

                if (slow == null) break;
                // full piece
                ListNode firstPre = head;
                ListNode firstPart = head.next;
                ListNode secondPre = slow;
                ListNode secondPart = slow.next;
                ListNode secondEnd = fast == null ? null : fast.next;
                head = fast == null ? null : (slow.val <= fast.val ? fast : slow);
                while (firstPart != slow.next && firstPart != null && secondPart != secondEnd) {
                    if (firstPart.val <= secondPart.val) {
                        firstPre = firstPart;
                        firstPart = firstPart.next;
                    } else {   // insert
                        secondPre.next = secondPart.next;
                        firstPre.next = secondPart;
                        secondPart.next = firstPart;
                        firstPre = secondPart;
                        secondPart = secondPre.next;
                    }
                }
            }
        }
        return dummy.next;
    }


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
}
