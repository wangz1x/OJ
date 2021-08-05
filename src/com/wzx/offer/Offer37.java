package com.wzx.offer;

import com.wzx.util.TreeNode;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author wangzx
 * @email wangzx22@163.com
 * @date 2021/6/30 下午2:49
 */
public class Offer37 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3, new TreeNode(4), new TreeNode(5)));
        String m = midOrder(root);
        System.out.println(m);
        String p = preOrder(root);
        System.out.println(p);
        String s = p + "#" + m;
        System.out.println(s);
        String[] split = s.split("#");
        System.out.println(split.length + " : " + Arrays.toString(split));
    }

    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        Deque<TreeNode> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();

            while (size > 0) {
                TreeNode cur = queue.poll();

                if (cur == null) {
                    sb.append("#,");
                } else {
                    sb.append(cur.val).append(",");
                    queue.offer(cur.left);
                    queue.offer(cur.right);
                }
                size--;
            }
        }
        return sb.substring(0, sb.length()-1);
    }

    public static String preOrder(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if (root != null) {
            sb.append(root.val).append(",");
            String left = preOrder(root.left);
            String right = preOrder(root.right);
            sb.append(left).append(right);
        }
        return sb.toString();
    }

    public static String midOrder(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if (root != null) {
            String left = midOrder(root.left);
            sb.append(left);
            sb.append(root.val).append(",");
            String right = midOrder(root.right);
            sb.append(right);
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        if (data.length() == 1) {
            return null;
        }
        String[] values = data.split(",");
        Deque<TreeNode> queue = new LinkedList<>();

        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        queue.offer(root);

        int idx = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNode cur = queue.poll();
                if (idx < values.length) {
                    // 孩子节点不为null
                    if (!"#".equals(values[idx])) {
                        TreeNode left = new TreeNode(Integer.parseInt(values[idx]));
                        assert cur != null;
                        cur.left = left;
                        queue.offer(left);
                    }
                    idx++;
                }
                if (idx < values.length) {
                    // 孩子节点不为null
                    if (!"#".equals(values[idx])) {
                        TreeNode right = new TreeNode(Integer.parseInt(values[idx]));
                        assert cur != null;
                        cur.right = right;
                        queue.offer(right);
                    }
                    idx++;
                }
                size--;
            }
        }
        return root;
    }
}
