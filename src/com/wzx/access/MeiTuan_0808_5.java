package com.wzx.access;

import java.util.Scanner;

public class MeiTuan_0808_5 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();
        int k = in.nextInt();

        int[][] children = new int[n + 1][2];

        for (int i = 1; i <= n; i++) {
            children[i][0] = in.nextInt();
            children[i][1] = in.nextInt();
        }

        // 记录每个节点要交换的次数
        int[] swapCount = new int[n + 1];

        for (int i = 0; i < m; i++) {
            int swap = in.nextInt();
            if (swapCount[swap] == 0) {
                swapCount[swap] = 1;
            } else {
                swapCount[swap] = 0;
            }
        }

        visitTree(children, swapCount, k);
    }

    public static void visitTree(int[][] tree, int[] swapCount, int root) {
        // 当前节点的子树需要交换
        if (root == 0) {
            return;
        }
        if (swapCount[root] == 1) {
            visitTree(tree, swapCount, tree[root][1]);
            System.out.print(root + " ");
            visitTree(tree, swapCount, tree[root][0]);
        } else {
            visitTree(tree, swapCount, tree[root][0]);
            System.out.print(root + " ");
            visitTree(tree, swapCount, tree[root][1]);
        }
    }
}
