package com.wzx.algorithm;

import java.util.Arrays;

/**
 * 实现最大堆
 */
public class MaxHeap {
    int[] heap;
    int cap;
    int size;

    public static void main(String[] args) {
        System.out.println("".matches("[0-9]+"));
        String[] a = {"H","96","21","W","59","I","V","s","59","w","X","33","29","H","32","51","f","i","58","56","66","90","F","10","93","53","85","28","78","d","67","81","T","K","S","l","L","Z","j","5","R","b","44","R","h","B","30","63","z","75","60","m","61","a","5","S","Z","D","2","A","W","k","84","44","96","96"};
        String[] b = {"52","3","v","71","J","A","0","v","51","E","k","H","96","21","W","59","I","V","s","59","w","X","33","29","H","32","51","f","i","58","56","66","90","F","10","93","53","85","28","78","d","67","81","T","K","S","l","L","Z","j","5","R","b","44","R","h","B","30","63","z","75","60","m","61","a","5"};
        System.out.println(a.length);
        System.out.println(b.length);

//        MaxHeap maxHeap = new MaxHeap(20);
//        maxHeap.insert(10);
//        maxHeap.insert(2);
//        maxHeap.insert(13);
//        maxHeap.insert(9);
//        System.out.println(Arrays.toString(maxHeap.heap));
//        maxHeap.insert(8);
//        maxHeap.insert(20);
//        maxHeap.insert(101);
//        System.out.println(Arrays.toString(maxHeap.heap));
//        System.out.println(maxHeap.remove());
//        System.out.println(Arrays.toString(maxHeap.heap));
    }

    public MaxHeap(int cap) {
        this.cap = cap;
        this.heap = new int[cap];
        this.size = 0;
    }

    public void insert(int val) {
        if (size < cap) {
            heap[size++] = val;
            shiftUp(size - 1);
        }
    }

    public int remove() {
        int res = -1;
        if (size > 0) {
            res = heap[0];
            heap[0] = heap[size-1];
            heap[--size] = 0;
            if (size > 1)
                shiftDown(0);
        }
        return res;
    }

    // idx : 2*idx+1, 2*idx+2
    // 0: 1, 2
    // 1: 3, 4
    // 2: 5, 6
    public void shiftUp(int idx) {
        if (idx != 0) {
            // get father
            int father = (idx - 1) >>> 1;
            if (heap[father] < heap[idx]) {
                exchange(father, idx);
                shiftUp(father);
            }
        }
    }

    public void shiftDown(int idx) {
        if (idx < (size >>> 1)) {         // 满足这个条件的点，至少有一个孩子
            int lc = 2 * idx + 1;
            int rc = 2 * idx + 2;
            if (rc < size && heap[lc] < heap[rc]) {          // 左右孩子都在
                exchange(idx, rc);
                shiftDown(rc);
            } else if (heap[lc] > heap[idx]) {
                exchange(idx, lc);
                shiftDown(lc);
            }
        }
    }

    public void exchange(int x, int y) {
        int temp = heap[x];
        heap[x] = heap[y];
        heap[y] = temp;
    }
}
