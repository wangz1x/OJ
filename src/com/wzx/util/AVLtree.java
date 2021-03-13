package com.wzx.util;

public class AVLtree {

    public static void main(String[] args) {
        AVLNode tree = null;
        System.out.println(tree=insert(tree, 6));
        System.out.println(tree=insert(tree, 4));
        System.out.println(tree=insert(tree, 3));
        System.out.println(tree=insert(tree, 1));
        System.out.println(tree=insert(tree, 10));
        System.out.println(tree=insert(tree, 8));
        System.out.println(tree=insert(tree, 9));
        System.out.println(tree=insert(tree, 11));
        System.out.println(tree=insert(tree, 81));
        System.out.println(tree=insert(tree, 16));
    }

    /**
     * 把p插入root中
     * @param root 根节点
     * @param p 待插入节点
     * @return 插入后的根节点
     */
    public static AVLNode insert(AVLNode root, int p) {
        // no root now
        if (root == null) return new AVLNode(p);
        if (root.val < p) root.right = insert(root.right, p);
        else if (root.val > p) root.left = insert(root.left, p);
        root.height ++;
        int leftHeight = root.left == null ? 0 : root.left.height;
        int rightHeight = root.right == null ? 0 : root.right.height;

        // 左子树比右子树高，那左边肯定不能为空啊
        if (leftHeight - rightHeight > 1) {
            assert root.left != null;
            int leftLeftHeight = root.left.left == null ? 0 : root.left.left.height;
            int leftRightHeight = root.left.right == null ? 0 : root.left.right.height;

            if (leftLeftHeight < leftRightHeight) root = lr_rotate(root);
            else root = ll_rotate(root);

        } else if (rightHeight - leftHeight > 1) {
            assert root.right != null;
            int rightLeftHeight = root.right.left == null ? 0 : root.right.left.height;
            int rightRightHeight = root.right.right == null ? 0 : root.right.right.height;

            if (rightLeftHeight < rightRightHeight) root = rr_rotate(root);
            else root = rl_rotate(root);
        }
        updateHeight(root);
        return root;
    }

    public static AVLNode ll_rotate(AVLNode root) {
        AVLNode newRoot = root.left;
        root.left = newRoot.right;  // if exists
        newRoot.right = root;
        return newRoot;
    }

    public static AVLNode lr_rotate(AVLNode root) {
        AVLNode left = root.left;
        AVLNode newRoot = left.right;
        left.right = newRoot.left;
        newRoot.left = left;
        root.left = newRoot;
        return ll_rotate(root);
    }

    public static AVLNode rr_rotate(AVLNode root) {
        AVLNode newRoot = root.right;
        root.right = newRoot.left;
        newRoot.left = root;
        return newRoot;
    }

    public static AVLNode rl_rotate(AVLNode root) {
        AVLNode right = root.right;
        AVLNode newRoot = right.left;
        right.left = newRoot.right;
        newRoot.right = right;
        root.right = newRoot;
        return rr_rotate(root);
    }

    public static int updateHeight(AVLNode root) {
        if (root == null) return 0;
        root.height = Math.max(updateHeight(root.left), updateHeight(root.right)) + 1;
        return root.height;
    }
}

class AVLNode{
    public int val;
    public int height;

    public AVLNode left;
    public AVLNode right;

    public AVLNode(int x) {
        val = x;
        height = 1;
    }

    @Override
    public String toString() {
        return val + "/" + left + "/" + right;
    }
}
