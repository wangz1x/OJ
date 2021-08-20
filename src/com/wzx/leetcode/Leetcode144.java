package com.wzx.leetcode;

import com.wzx.util.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Leetcode144 {
    public static void main(String[] args) {
        System.out.println();
    }

    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        // recursive(root, res);

        Deque<TreeNode> deque = new LinkedList<>();
        deque.addLast(root);

        while (deque.size() != 0) {
            TreeNode temp = deque.peekLast();
            if (temp != null) {
                res.add(temp.val);
                if (temp.left != null)
                    deque.addLast(temp.left);
                else {
                    deque.pollLast();
                    if (temp.right != null)
                        deque.addLast(temp.right);
                }
            }
        }
        return res;
    }
}
