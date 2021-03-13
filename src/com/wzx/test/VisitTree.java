package com.wzx.test;

import com.wzx.util.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class VisitTree {

    public static void preOrderVisit(TreeNode root) {
        Deque<TreeNode> deque = new ArrayDeque<>();

        deque.push(root);

        while (!deque.isEmpty()) {
            TreeNode node = deque.poll();
            System.out.print("" + node.val + "->");

            if (node.right != null) deque.push(node.right);
            if (node.left != null) deque.push(node.left);
        }
    }

    public static void inOrderVisit(TreeNode root) {
        Deque<TreeNode> deque = new ArrayDeque<>();
        TreeNode cur = root;
        while (!deque.isEmpty() || cur != null) {

            while (cur != null) {
                deque.push(cur);
                cur = cur.left;
            }

            cur = deque.poll();
            System.out.print("" + cur.val + "->");
            cur = cur.right;
        }
    }

    public static void postOrderVisit(TreeNode root) {
        Deque<TreeNode> deque = new ArrayDeque<>();
        TreeNode pre = null;
        deque.push(root);

        while (!deque.isEmpty()) {
            TreeNode cur = deque.peek();

            if ((cur.left == null && cur.right == null) || (pre!=null && (pre == cur.left || pre == cur.right))) {
                System.out.print("" + cur.val + "->");
                pre = cur;
                deque.pop();
            }
            else {
                if (cur.right != null) deque.push(cur.right);
                if (cur.left != null) deque.push(cur.left);
            }
        }
    }

    public static void main(String[] args) {
        preOrderVisit(TreeNode.root);
        System.out.println();
        inOrderVisit(TreeNode.root);
        System.out.println();
        postOrderVisit(TreeNode.root);
    }
}
