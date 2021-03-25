package com.wzx.algorithm;

import com.wzx.util.TreeNode;

/**
 * 特殊的先序遍历二叉树的方法，可扩展
 */
public class Mirrors_ {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(0, new TreeNode(1, new TreeNode(2), new TreeNode(3)), new TreeNode(4, null, new TreeNode(5)));
        System.out.println(root);
        visitedTree(root);
        System.out.println(root);
    }

    public static void visitedTree(TreeNode root) {
        TreeNode cur = root;
        TreeNode pre;

        while (cur != null) {
//            if (cur.left == null) {
//                System.out.println("visit: " + cur.val);
//                cur = cur.right;
//            } else {
//                pre = findPre(cur);
//                if (pre.right == null) {
//                    System.out.println("visit: " + cur.val);
//                    pre.right = cur;
//                    cur = cur.left;
//                } else if (pre.right == cur) {
//                    pre.right = null;
//                    cur = cur.right;
//                }
//            }
            pre = findPre(cur);
            if (pre == null) {
                System.out.println("visit: " + cur.val);
                cur = cur.right;
            } else if (pre.right == null) {
                System.out.println("visit: " + cur.val);
                pre.right = cur;
                if (cur.left != null) cur = cur.left;
                else cur = cur.right;
            } else if (pre.right == cur) {
                pre.right = null;
                cur = cur.right;
            }
        }
    }

    public static TreeNode findPre(TreeNode root) {
        if (root == null || root.left == null) return null;
        TreeNode pre = root.left;
        while (pre.right != null && pre.right != root) {
            pre = pre.right;
        }
        return pre;
    }
}
