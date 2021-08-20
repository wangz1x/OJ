package com.wzx;

import java.math.BigDecimal;
import java.util.*;

public class Main {
    public int a;
    public static int b;

    public static void main(String[] args) {
        char c = 47;
        System.out.println(c);

        int[][] arr = {{1, 5}, {1, 2}, {2, 3}, {1, 3}, {8, 9}, {5, 7}};
//        int[][] arr1 = {{1, 2}, {3, 4}};

        Arrays.sort(arr, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]);
        System.out.println(Arrays.deepToString(arr));

//        Set<int[][]> visited = new HashSet<>();
//        visited.add(arr);
//        System.out.println(visited.contains(arr1));

    }

    public int[] countPairs(int n, int[][] edges, int[] queries) {
        int[][] connected = new int[n + 1][n + 1];

        // 每个点 和其他点相连的总数
        int[] counts = new int[n + 1];

        for (int[] edge : edges) {
            if (edge[0] < edge[1]) {
                connected[edge[0]][edge[1]]++;
            } else {
                connected[edge[1]][edge[0]]++;
            }
            counts[edge[0]]++;
            counts[edge[1]]++;
        }

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                int key = counts[i] + counts[j] - connected[i][j];
                map.put(key, map.getOrDefault(key, 0) + 1);
            }
        }

        int[] res = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            Set<Integer> integers = map.keySet();
            for (int key : integers) {
                if (key > queries[i]) {
                    res[i] += map.get(key);
                }
            }
        }
        return res;
    }

    public static int beautySum(String s) {
        if (s.length() <= 1) return 0;

        char[] sChars = s.toCharArray();

        int[][] counts = new int[sChars.length + 1][26];

        for (int i = 0; i < sChars.length; i++) {

            for (int j = 0; j < 26; j++) {
                if (j == (int) (sChars[i] - 'a')) {
                    counts[i + 1][j] = counts[i][j] + 1;
                } else {
                    counts[i + 1][j] = counts[i][j];
                }
            }
        }

        int res = 0;

        for (int i = 0; i < sChars.length; i++) {
            for (int j = i; j < sChars.length; j++) {
                // from i~j
                int max = 0;
                int min = 502;
                for (int k = 0; k < 26; k++) {
                    if (counts[j + 1][k] - counts[i][k] > max) max = counts[j + 1][k] - counts[i][k];
                    if (counts[j + 1][k] - counts[i][k] != 0 && counts[j + 1][k] - counts[i][k] < min)
                        min = counts[j + 1][k] - counts[i][k];
                }
                res += max - min;
            }
        }
        return res;
    }


    public static boolean dfs(int target, int cur, int visited, int start) {
        if (cur == target) return true;

        for (int i = start; i >= 0; i--) {
            if ((visited & (1 << i)) == 0) {  // not visited
                if (Math.pow(3, 1 << i) + cur < target) {
                    visited |= 1 << i;

                    if (dfs(target, cur + (int) (Math.pow(3, 1 << i)), visited, i + 1)) return true;

                    visited ^= 1 << i;
                }
            }
        }
        return false;
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
    // construct minimum heap with a+A, b+A, c+A, d+A ... a+B, b+B, c+B ...
    public int lemonadeChange(int[] bills) {
        int count = 0;
        int five = 2, ten = 0;
        for (int bill : bills) {
            if (bill == 5) {
                five++;
            } else if (bill == 10) {
                if (five == 0) {
                    return count;
                }
                five--;
                ten++;
            } else {
                if (five > 0 && ten > 0) {
                    five--;
                    ten--;
                } else if (five >= 3) {
                    five -= 3;
                } else {
                    return count;
                }
            }
            count++;
        }
        return count;
    }

    // 有几种情况，
    // A正 B正           大的减小的
    // A正 B负           两个相加
    // A负 B正           两个相加，结果取非
    // A负 B负           A+(-B)， 实际上是A负，B正，相加，如果绝对值A>=B，那么就A-B取非；如果绝对值A<B，直接B-A
    public List<Integer> subLink(List<Integer> listA, List<Integer> listB) {
        int flagA = 1, flagB = 1;
        List<Integer> res = new LinkedList<>();
        if (listA.size() > 0 && listA.get(0) < 0) {
            flagA = -1;
        }
        if (listB.size() > 0 && listB.get(0) < 0) {
            flagB = -1;
        }

        if (flagA == 1 && flagB == 1) {            // 还要知道谁大谁小
            int resFlag = 1;
            if (listA.size() < listB.size()) {    // B 大，结果为负
                resFlag = -1;
            } else if (listA.size() > listB.size()) {
                List<Integer> temp = listA;
                listA = listB;
                listB = temp;
            } else {                             // 长度相等
                Iterator<Integer> iteratorA = listA.iterator();
                Iterator<Integer> iteratorB = listB.iterator();

                while (iteratorB.hasNext() && iteratorA.hasNext()) {
                    if (iteratorB.next() > iteratorA.next()) {
                        resFlag = -1;
                        break;
                    }
                }
                if (resFlag == 1) {
                    List<Integer> temp = listA;
                    listA = listB;
                    listB = temp;
                }
            }

            Collections.reverse(listA);
            Collections.reverse(listB);
            int borrow = 0;

            Iterator<Integer> iteratorA = listA.iterator();
            Iterator<Integer> iteratorB = listB.iterator();

            while (iteratorB.hasNext() && iteratorA.hasNext()) {
                int cur = iteratorB.next() - borrow - iteratorA.next();
                if (cur < 0) {      // 不够减，listB要问前边的借一位
                    cur = 10 + cur;
                    borrow = 1;     // 减法应该最多就问前边借一吧
                }
                res.add(cur);
            }
            while (iteratorB.hasNext()) {       // 因为B是大数，如果有剩下的话，一定是B生下了
                int cur = iteratorB.next() - borrow;
                if (cur < 0) {
                    cur = 10 + cur;
                    borrow = 1;
                }
                res.add(cur);
            }
            // 最后还要去除前导0，因为是从后开始减的，前边可能为0
            Collections.reverse(res);
            while (res.size() > 0 && res.get(0) == 0) {
                res.remove(0);
            }
            if (res.size() == 0) {        // 全是0，还要在加个0表示结果
                res.add(0);
            }
            if (res.get(0) > 0) {
                res.set(0, resFlag * res.get(0));
            }
            return res;
        }
        return res;
    }


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

