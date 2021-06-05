package com.wzx.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangzx
 * @email wangzx22@163.com
 * @date 2021/6/1 下午8:19
 */
public class Leetcode797 {

    static List<List<Integer>> res = new ArrayList<>();

    public static void main(String[] args) {
        int[][] graph = {{1,3},{2},{3},{}};
        System.out.println(allPathsSourceTarget(graph));
    }

    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        // 深度?
        // 能不能记忆呢
        // 假设0经过k能到达n-1
        // 那么当发现有个点能到k后，直接合并
        List<Integer> path = new ArrayList<>();
        path.add(0);
        dfs(path, graph, 0);
        return res;
    }

    public static void dfs(List<Integer> path, int[][] graph, int cur) {
        if (cur == graph.length-1) {   // 到达最后一个点
            res.add(new ArrayList<>(path));
            return;
        }

        for (int node : graph[cur]) {     // 从cur开始往后走
            path.add(node);
            dfs(path, graph, node);
            path.remove(path.size()-1);
        }
    }

}
