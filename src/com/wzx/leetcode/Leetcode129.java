package com.wzx.leetcode;

public class Leetcode129 {
    public static void main(String[] args) {
    }

    public static int sumNumbers(TreeNode root) {
        return recursive(root, 0);
    }

    public static int recursive(TreeNode node, int sum) {
        if (node != null) {
            sum = sum*10 + node.val;
            int left = 0;
            int right = 0;
            if (node.left != null)
                left = recursive(node.left, sum);
            if (node.right != null)
                right = recursive(node.right, sum);
            sum = left + right;
        }
        return sum;
    }
}
