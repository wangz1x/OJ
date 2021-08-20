package com.wzx.leetcode;

import com.wzx.util.TreeNode;

public class Leetcode450 {
    public static void main(String[] args) {
        System.out.println(deleteNode(TreeNode.root, 3));
    }

    static TreeNode pre = null;

    public static TreeNode deleteNode(TreeNode root, int key) {
        TreeNode head = root;
        if (root == null) return null;

        while (root != null) {
            if (root.val > key) {
                root = root.left;
            } else if (root.val < key) {
                root = root.right;
            } else {
                TreeNode successor;
                while ((successor = findSuccessor(root)) != null) {
                    root.val = successor.val;

                    root = successor;
                }
                if (pre.left == root) pre.left = null;
                else if (pre.right == root) pre.right = null;
            }
        }

        return head;
    }

    public static TreeNode findSuccessor(TreeNode root) {
        if (root == null || root.right == null) return null;

        TreeNode right = root.right;
        pre = root;

        while (right.left != null) {
            pre = right;
            right = right.left;
        }

        return right;
    }
}
