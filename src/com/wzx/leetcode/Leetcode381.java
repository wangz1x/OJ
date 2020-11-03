package com.wzx.leetcode;


import java.util.*;

public class Leetcode381 {
    Map<Integer, Deque<Integer>> idx = new HashMap<>();
    List<Integer> ele = new ArrayList<>(10);
    int size = 0;

    /**
     * Initialize your data structure here.
     */
    public Leetcode381() {
    }

    public static void main(String[] args) {
        Leetcode381 l = new Leetcode381();
        System.out.println(l.insert(1));
        System.out.println(l.insert(1));
        System.out.println(l.insert(2));
        System.out.println(l.insert(2));
        System.out.println(l.insert(3));
        System.out.println(l.insert(3));

        System.out.println(l.remove(1));
        System.out.println(l.remove(1));
        System.out.println(l.remove(3));
        System.out.println(l.remove(3));

        System.out.println(l.getRandom());
        System.out.println(l.getRandom());
        System.out.println(l.getRandom());
        System.out.println(l.getRandom());
        System.out.println(l.getRandom());
        System.out.println(l.getRandom());
        System.out.println(l);
    }

    /**
     * Inserts a value to the collection. Returns true if the collection did not already contain the specified element.
     */
    public boolean insert(int val) {
        ele.add(val);
        if (idx.containsKey(val)) {
            idx.get(val).push(size++);
            return false;
        } else {
            Deque<Integer> linkedList = new LinkedList<>();
            linkedList.push(size++);
            idx.put(val, linkedList);
            return true;
        }
    }

    /**
     * Removes a value from the collection. Returns true if the collection contained the specified element.
     */
    public boolean remove(int val) {
        if (idx.containsKey(val)) {
            int temp = idx.get(val).poll();
            if (temp != size - 1) {
                int lastEle = ele.get(size-1);
                // swap
                ele.set(temp, lastEle);
//                if (!idx.get(lastEle).isEmpty())
//                    idx.get(lastEle).poll();
                idx.get(lastEle).remove(new Integer(size-1));
                idx.get(lastEle).push(temp);
            }
            ele.remove(size - 1);
            size--;
            if (idx.get(val).isEmpty()) idx.remove(val);
            return true;
        }
        return false;
    }

    /**
     * Get a random element from the collection.
     */
    public int getRandom() {
        Random random = new Random();
        if (size > 0) {
            int index = random.nextInt(size);
            return ele.get(index);
        }
        return 0;
    }

    @Override
    public String toString() {
        return "Leetcode381{" +
                "ele=" + ele +
                ", size=" + size +
                '}';
    }
}
