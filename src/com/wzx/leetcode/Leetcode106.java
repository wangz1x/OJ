package com.wzx.leetcode;

import com.wzx.util.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class Leetcode106 {
    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        // both visit reverse,  and add as right child.
        int in_idx = inorder.length-1;
        Deque<TreeNode> stack = new LinkedList<>();

        int post_idx = postorder.length -1;

        TreeNode head = new TreeNode(postorder[post_idx--]);
        stack.push(head);

        while (post_idx >= 0) {
            if (stack.isEmpty()) {
                stack.push(new TreeNode(postorder[post_idx--]));
            }

            else if (stack.peek().val != inorder[in_idx]) {
                TreeNode pre = stack.peek();
                TreeNode cur = new TreeNode(postorder[post_idx--]);
                pre.right = cur;
                stack.push(cur);
            }

            else {
                TreeNode pre = null;
                while (!stack.isEmpty() && in_idx >= 0 && stack.peek().val == inorder[in_idx]) {
                    pre = stack.poll();
                    in_idx--;
                }
                if (pre != null) {
                    TreeNode cur = new TreeNode(postorder[post_idx--]);
                    pre.left = cur;
                    stack.push(cur);
                }
            }
        }
        return head;
    }

    public static void main(String[] args) {
        System.out.println(buildTree(new int[]{10, 9, 3, 15, 20, 17}, new int[]{10, 9, 15, 17, 20, 3}));
    }
}
