package com.wzx.leetcode;

import java.util.*;

public class Leetcode399 {

    public static double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Integer> map = new HashMap<>();
        double[] res = new double[queries.size()];
        int varCount = 0;

        for (List<String> equation : equations) {
            if (!map.containsKey(equation.get(0))) {
                map.put(equation.get(0), varCount++);
            }
            if (!map.containsKey(equation.get(1))) {
                map.put(equation.get(1), varCount++);
            }
        }

        int[] parents = new int[varCount];
        double[] weights = new double[varCount];
        int[] childCount = new int[varCount];

        for (int i = 0; i < varCount; i++) {
            parents[i] = i;
            weights[i] = 1;
            childCount[i] = 0;
        }

        for (int i = 0; i < equations.size(); i++) {
            int p1 = map.get(equations.get(i).get(0));
            int p2 = map.get(equations.get(i).get(1));
            union(parents, p1, p2, weights, childCount, values[i]);
        }

        int idx = 0;
        for (List<String> query : queries) {
            if (map.containsKey(query.get(0)) && map.containsKey(query.get(1))) {
                int p1 = map.get(query.get(0));
                int p2 = map.get(query.get(1));

                if (find(parents, p1) == find(parents, p2)) {
                    res[idx++] = weights[p2] / weights[p1];
                } else res[idx++] = -1;
            } else {
                res[idx++] = -1;
            }
        }

        return res;
    }

    // how to update weight
    public static int find(int[] parents, int child) {
        int parent = child;
        if (parents[child] != child) {
            parent = find(parents, parents[child]);
        }
        return parent;
    }

    public static void union(int[] parents, int p1, int p2, double[] weights, int[] childCount, double weight) {
        int p1Parent = find(parents, p1);
        int p2Parent = find(parents, p2);
        if (p1Parent != p2Parent) {
            if (childCount[p1Parent] < childCount[p2Parent]) {
                int temp = p1Parent;
                p1Parent = p2Parent;
                p2Parent = temp;
                weight = 1 / weight;
                weights[p1] = 1 / weights[p1];
            } else {
                weights[p2] = 1 / weights[p2];
            }
            parents[p2Parent] = p1Parent;
            childCount[p1Parent]++;
            weights[p2Parent] = weights[p1] * weight * weights[p2];

        }
    }

    public static void main(String[] args) {
        List<List<String>> equations = new ArrayList<>();
        equations.add(Arrays.asList("a", "b"));
        equations.add(Arrays.asList("b", "c"));
        equations.add(Arrays.asList("a", "c"));

        double[] values = {2.0, 3.0, 6.0};

        List<List<String>> query = new ArrayList<>();
        query.add(Arrays.asList("a", "c"));
        query.add(Arrays.asList("b", "a"));
        query.add(Arrays.asList("a", "e"));
        query.add(Arrays.asList("a", "a"));
        query.add(Arrays.asList("d", "d"));

        System.out.println(Arrays.toString(calcEquation(equations, values, query)));

    }
}
