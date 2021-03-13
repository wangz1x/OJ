package com.wzx.leetcode;

import com.wzx.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode863 {

    public int length = -1;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.right = new TreeNode(1);
        root.left = null;
        root.right.left = new TreeNode(3);
        root.right.left.right = null;
        root.right.left.left = null;
        root.right.right = new TreeNode(2);
        root.right.right.left = new TreeNode(4);
        root.right.right.right = null;
        root.right.right.left.left = null;
        root.right.right.left.right = new TreeNode(5);

        Leetcode863 leetcode863 = new Leetcode863();
        List<Integer> integers = leetcode863.distanceK(root, root.right.right.left, 0);
        System.out.println(integers);
//        leetcode863.distanceK()
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> res = new ArrayList<>();
        dfs(res, root, target, K);
        return res;
    }

    public boolean dfs(List<Integer> res, TreeNode root, TreeNode target, int K) {
        if (root == null) return false;
        if (root == target) {
            getNode(res, root, K);
            length += 2;
            return true;
        }
        // the root side is not null
        boolean left = dfs(res, root.left, target, K);
        boolean right = dfs(res, root.right, target, K);
        if (length == K) {
            res.add(root.val);
            length ++;
        }
        else if (left) {
            getNode(res, root.right, K-1-length);
            length ++;
            return true;
        }
        else if (right) {
            getNode(res, root.left, K-1-length);
            length ++;
            return true;
        }
        return false;
    }

    public void getNode(List<Integer> res, TreeNode root, int distance) {
        if (root != null) {
            if (distance == 0) {
                res.add(root.val);
            }
            getNode(res, root.left, distance - 1);
            getNode(res, root.right, distance - 1);
        }
    }
}
