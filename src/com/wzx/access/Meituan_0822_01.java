package com.wzx.access;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author wangzx
 * email wangzx22@163.com
 * date 2021/8/22 上午11:10
 */
public class Meituan_0822_01 {

    public static List<List<Integer>> res = new ArrayList<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] cards = new int[n];

        for (int i = 0; i < n; i++) {
            cards[i] = in.nextInt();
        }
        deal(n, cards);

        System.out.println(res.size());
        for (List<Integer> tmp : res) {
            for (int ele : tmp) {
                System.out.print(ele + " ");
            }
            System.out.println();
        }
    }

    public static void deal(int n, int[] cards) {
        Arrays.sort(cards);
        boolean[] visited = new boolean[n];
        List<Integer> tmp = new ArrayList<>();
        dfs(n, cards, visited, tmp);
    }

    public static void dfs(int n, int[] cards, boolean[] visited, List<Integer> tmp) {
        if (n == 0) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        int last = -1;
        for (int i = 0; i < cards.length; i++) {
            // 第i个数没被用过, 且和上一次用的不一样
            if (!visited[i] && cards[i] != last) {
                visited[i] = true;
                tmp.add(cards[i]);
                dfs(n - 1, cards, visited, tmp);
                last = cards[i];
                tmp.remove(tmp.size() - 1);
                visited[i] = false;
            }
        }
    }
}
