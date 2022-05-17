package com.wzx.access;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}

public class Notknown_0912_03 {


    public static void main(String[] args) {
        TreeNode root = new TreeNode(2,
                new TreeNode(3, new TreeNode(1), null),
                new TreeNode(5, null, new TreeNode(4)));
        new Notknown_0912_03().shiftTree(root, 2);
        System.out.println(root);
    }

    Map<Integer, List<TreeNode>> map = new HashMap<>();
    public TreeNode shiftTree(TreeNode root, int k) {
        deal(root);
        for (Map.Entry<Integer, List<TreeNode>> entry : map.entrySet()) {
            List<TreeNode> value = entry.getValue();
            int[] values = new int[value.size()];
            int idx = 0;
            for (TreeNode node : value) {
                values[idx++] = node.val;
            }
            k = k % value.size();
            idx = 0;
            for (TreeNode node : value) {
                node.val = values[(idx - k + value.size()) % value.size()];
                idx++;
            }
        }
        return root;
    }

    public int deal(TreeNode root) {
        if (root == null) return 0;
        int cur = Math.max(deal(root.left), deal(root.right)) + 1;
        List<TreeNode> list = map.getOrDefault(cur, new ArrayList<>());
        list.add(root);
        map.put(cur, list);
        return cur;
    }
}
