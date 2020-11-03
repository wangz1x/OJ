package com.wzx;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    public int a;
    public static int b;

    public static void main(String[] args) {
//        int[] arr1 = {1, 4, 5, 7, 34, 56, 90};
//        int[] arr2 = {8, 12, 45, 67, 89, 99, 110, 234};
//
//        System.out.println(Arrays.toString(formerK(arr1, arr2, 6)));
    }

    public static int[] formerK(int[] arr1, int[] arr2, int K) {
        int[] res = new int[K];
        int count = 0;

        // range from 0 to arr2.length-1
        int[] pointers = new int[arr1.length];

        Comparator<Node> comparator = new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.val - o2.val;
            }
        };
        Queue<Node> nodes = new PriorityQueue<>(arr1.length, comparator);
        for (int i = 0; i < arr1.length; i++) {
            nodes.offer(new Node(arr1[i] + arr2[pointers[i]], i));
        }

        Node temp;
        while (count < K) {
            temp = nodes.poll();
            if (temp != null) {
                res[count] = temp.val;
                pointers[temp.index]++;
                if (pointers[temp.index] < arr2.length) {
                    nodes.offer(new Node(arr1[temp.index] + arr2[pointers[temp.index]], temp.index));
                }
                count++;
            }
        }
        return res;
    }

    // arr1 = a, b, c, d ...
    // arr2 = A, B, C, D ...
    // construct minimum heap with a+A, b+A, c+A, d+A
}

/**
 * used by max heap
 */
class Node {
    int val;         // save element in array
    int index;       // save the pointer

    public Node(int val, int index) {
        this.val = val;
        this.index = index;
    }
}

