package com.wzx.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        findRu();
    }

    public static void findRu() {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        for (int i = 0; i < n; i++) {  //输入n个测试样例
            int nodes = input.nextInt(); //节点数
            int[][] road = new int[nodes][nodes];
            for (int j = 0; j < nodes - 1; j++) {
                int x = input.nextInt(), y = input.nextInt();
                road[x - 1][y - 1] = road[y - 1][x - 1] = 1;
            }
            int[][] results;
            results = dfs_road(road);
            for (int k = 0; k < 2; k++) {
                System.out.println(results[k][0] + " " + results[k][1]);
            }
        }
    }

    public static int[][] dfs_road(int[][] road) {
        int max = 0;
        int len = road.length;
        List<int[]> list = new ArrayList<>();
        int[][] res = new int[2][2];
        for (int i = 0; i < len; i++) {
            int tmp = 0;
            for (int j = 0; j < len; j++) {
                if (road[i][j] == 1) tmp++;         // 计算i的度
            }
            if (tmp >= max) {
                max = tmp;
                list.add(new int[]{i, max}); //第i个节点的邻接表最长
            }
        }
        //需要选出最长的邻接表 随后再选择邻接表中不与最长节点相邻
        if (list.size() >= 2 && list.get(list.size() - 1)[1] == list.get(list.size() - 2)[1]) {
            //最后两个节点相等 随机选择一个节点
            int sel_keepNode = list.get(list.size() - 1)[0]; //选择保留节点
            int sel_takeNode = list.get(list.size() - 2)[0]; //选择去除节点
            int node = -1;
            for (int i = 0; i < len; i++) {
                if (road[sel_takeNode][i] == 1 && road[sel_keepNode][i] == 0) {
                    node = i;
                    res[0] = new int[]{sel_takeNode + 1, i + 1}; //选择封闭节点
                    break;
                }
            }
            res[1] = new int[]{node + 1, sel_keepNode + 1};
        } else if (list.size() == 1 || list.get(list.size() - 1)[1] > list.get(list.size() - 2)[1]) {
            int sel_keepNode = list.get(list.size() - 1)[0]; //选择保留节点
            for (int i = 0; i < len; i++) {
                if (road[sel_keepNode][i] == 1) {
                    res[0] = new int[]{sel_keepNode + 1, i + 1};
                    res[1] = new int[]{i + 1, sel_keepNode + 1};
                    break;
                }
            }
        }
        return res;
    }
}
