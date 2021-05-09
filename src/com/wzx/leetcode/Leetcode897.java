package com.wzx.leetcode;

import com.wzx.util.TreeNode;

public class Leetcode897 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5, new TreeNode(1), new TreeNode(7));
        System.out.println(increasingBST(root));
    }

    public static TreeNode increasingBST(TreeNode root) {
        TreeNode pre = null, cur = root, next, head = root;

        while (cur != null) {
            next = findPre(cur);

            if (next != cur && next.right != cur) {
                next.right = cur;
                cur = cur.left;

                continue;
            }

            if (pre == null) {
                head = cur;
            } else {
                cur.left = null;
                pre.right = cur;
            }
            pre = cur;
            cur = cur.right;
        }
        return head;
    }

    public static TreeNode findPre(TreeNode cur) {
        if (cur != null && cur.left != null) {
            cur = cur.left;
            while (cur.right != null) {
                cur = cur.right;
            }
        }
        return cur;
    }
}
