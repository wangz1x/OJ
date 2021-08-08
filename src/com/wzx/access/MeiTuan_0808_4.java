package com.wzx.access;

import java.util.Scanner;

public class MeiTuan_0808_4 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // 并查集
        int n = in.nextInt();

        int[] arr = new int[n];
        int[] parent = new int[100001];
        int[] child = new int[100001];

        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            child[i] = 1;
        }

        for (int i = 0; i < n/2; i++) {
            if (arr[i] != arr[i+n/2]) {
                union(parent, arr[i], arr[i+n/2], child);
            }
        }

        int op = 0;
        for (int i = 0; i < n; i++) {
            op += child[i]-1;
        }
        System.out.println(op);
    }

    // x和y的祖先有关系
    public static void union(int[] parent, int x, int y, int[] child) {
        int px = find(parent, x);
        int py = find(parent, y);

        if (px != py) {
            if (child[px] > child[py]) {
                parent[py] = px;
                child[px] += child[py];
                child[py] = 1;
            } else {
                parent[px] = py;
                child[py] += child[px];
                child[px] = 1;
            }
        }
    }

    // 找到x的爹
    public static int find(int[] parent, int x) {
        int p = parent[x];

        // p 还有爹, 那么就要x指向它
        while (parent[p] != p) {
            parent[x] = parent[p];
            p = parent[p];
        }
        return p;
    }
}
