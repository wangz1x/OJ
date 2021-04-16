package com.wzx.leetcode;

import com.wzx.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode95 {
    public static void main(String[] args) {
        System.out.println(generateTrees(3));
    }

    public static List<TreeNode> generateTrees(int n) {
        List<TreeNode> res = new ArrayList<>();
        if (n == 0) return res;

        return generateTree(1, n);
    }

    // 1~root-1, root, root+1~end
    public static List<TreeNode> generateTree(int start, int end) {

        List<TreeNode> res = new ArrayList<>();

        if (start > end) {
            res.add(null);
            return res;
        }
        if (start == end) {
            res.add(new TreeNode(start));
            return res;
        }

        for (int root = start; root <= end; root++) {
            TreeNode rot = new TreeNode(root);
            List<TreeNode> left = generateTree(start, root-1);
            List<TreeNode> right = generateTree(root+1, end);
            for (TreeNode leftnode : left) {
                rot.left = leftnode;
                for (TreeNode rightnode : right) {
                    rot.right = rightnode;
                    res.add(rot);
                }
            }
        }

        return res;
    }
}
