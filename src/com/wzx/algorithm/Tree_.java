package com.wzx.algorithm;

public class Tree_ {
    Node[] nodes;
    int[] arr;

    public Tree_(int[] arr) {
        this.arr = arr;
        nodes = new Node[arr.length << 2];
        build(arr, 0, arr.length - 1, 0);
    }

    static class Node {
        int start;
        int end;
        int data;

        public Node(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public void build(int[] data, int start, int end, int index) {
        if (nodes[index] == null) {
            nodes[index] = new Node(start, end);
        }
        if (start == end) {
            nodes[index].data = data[start];
            return;
        }
        int mid = (start + end) >> 1;
        build(data, start, mid, 2 * index + 1);
        build(data, mid + 1, end, 2 * index + 2);
        nodes[index].data = Math.max(nodes[2 * index + 1].data, nodes[2 * index + 2].data);
    }

    public int queryMax(int start, int end, int index) {
        if (nodes[index].start >= start && nodes[index].end <= end) return nodes[index].data;
        if (nodes[index].start > end || nodes[index].end < start) return -1;
        return Math.max(queryMax(start, end, index * 2 + 1), queryMax(start, end, index * 2 + 2));
    }

    public int queryMax2(int start, int end, int index) {
        if (nodes[index].start >= start && nodes[index].end <= end) return nodes[index].data;
        if (nodes[index].start > end || nodes[index].end < start) return -1;
        int mid = (nodes[index].start+nodes[index].end)>>1;
        if (end <= mid) return queryMax(start, end, index*2+1);
        if (start > mid) return queryMax(start, end, index*2+2);
        return Math.max(queryMax(start, end, index * 2 + 1), queryMax(start, end, index * 2 + 2));
    }

    public static void main(String[] args) {
        int[] arr = new int[9999999];
        for (int i = 0; i < 9999999; i++) {
            arr[i] = (int) Math.round(Math.random() * 100000000);
        }
        Tree_ tree_ = new Tree_(arr);

        int start = 6421;
        int end = 1678421;

        long l = System.currentTimeMillis();
        System.out.println(tree_.queryMax(start, end, 0));
        System.out.println("queryMax cost time: " + (System.currentTimeMillis()-l));

        long l1 = System.currentTimeMillis();
        System.out.println(tree_.queryMax2(start, end, 0));
        System.out.println("queryMax2 cost time: " + (System.currentTimeMillis()-l1));

        long l2 = System.currentTimeMillis();
        int max = 0;
        for (int i = start; i <= end; i ++) {
            if (arr[i] > max) max = arr[i];
        }
        System.out.println(max);
        System.out.println("scan cost time: " + (System.currentTimeMillis()-l2));
    }
}
