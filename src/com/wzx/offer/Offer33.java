package com.wzx.offer;

import java.util.Deque;
import java.util.LinkedList;

public class Offer33 {

    public static void main(String[] args) {
        int[] post = {1,3,2,6,5};
        System.out.println(verifyPostorder(post));
    }

    public static boolean verifyPostorder(int[] postorder) {

        // 找规律？
        // 从左到右，先遇到最小的，然后遇到个大的，如果继续是大的，说明没有右孩子，
        //                                  如果是小的，但是还是要大于最小的，说明是右孩子
        //
        // return recurse(postorder, 0, postorder.length-1);

        Deque<Integer> stack = new LinkedList<>();
        int root = 0x7fffffff;        // 初始化root为一个很大的数

        for (int i = postorder.length-1; i >= 0; i--) {
            if (postorder[i] > root) return false;
            while (!stack.isEmpty() && postorder[i] < stack.peek()) {
                root = stack.pop();
            }
            stack.push(postorder[i]);
        }
        return true;
    }
}
