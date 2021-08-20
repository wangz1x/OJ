package com.wzx.leetcode;

import com.wzx.util.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class Leetcode236 {


    public static void main(String[] args) {
        TreeNode p = new TreeNode(4);
        TreeNode q = new TreeNode(7);
        TreeNode root = new TreeNode(3, new TreeNode(5, new TreeNode(6), new TreeNode(2, p, q)), new TreeNode(1, new TreeNode(0), new TreeNode(8)));
        System.out.println(lowestCommonAncestor(root, p, q));
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 两种情况 1 要么p和q都在同一边
        //            1.1 p或q为根节点，直接返回
        //            1.2 去root的子节点再找
        //         2 要么p和q不在同一边，则当前root就是公共祖先了
        //
        if (root == null) return null;
        if (root == p || root == q) return root;
        Deque<TreeNode> ppath = new LinkedList<>();
        Deque<TreeNode> qpath = new LinkedList<>();
        boolean findp = findNode(root, p, ppath);         // 如果为true，说明p就在左边
        boolean findq = findNode(root, q, qpath);         // 如果为true，说明q就在左边
        TreeNode res = root;
        if (findp && findq) {
            TreeNode ppre = ppath.removeLast();
            qpath.removeLast();
            TreeNode pcur;
            while (!ppath.isEmpty() && !qpath.isEmpty()) {
                if ((pcur = ppath.removeLast()).val != qpath.removeLast().val) {
                    res = ppre;
                    break;
                }
                ppre = pcur;
            }
        }
        return res;
    }

    public static boolean findNode(TreeNode root, TreeNode node, Deque<TreeNode> path) {
        if (root == null) return false;
        if (root == node || findNode(root.left, node, path) || findNode(root.right, node, path)) {
            path.add(root);
            return true;
        }
        return false;
    }
}
