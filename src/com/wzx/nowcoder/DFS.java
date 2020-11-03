package com.wzx.nowcoder;

import java.util.ArrayList;
import java.util.List;

public class DFS {
    public static void main(String[] args) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp1 = new ArrayList<>();
        List<Integer> temp2 = new ArrayList<>();
        List<Integer> temp3 = new ArrayList<>();
        List<Integer> temp4 = new ArrayList<>();
        temp1.add(3);
        temp2.add(2);
        temp3.add(1);
        temp4.add(1);
        res.add(temp1);
        res.add(temp2);
        res.add(temp3);
        res.add(temp4);
        System.out.println(lottery(4, res));

    }

    public static boolean lottery(int poolCount, List<List<Integer>> pool) {
        boolean[] isVisit = new boolean[poolCount];
        return dfs(isVisit, 0, pool, 0);
    }

    public static boolean dfs(boolean[] isVisit, int visitCount, List<List<Integer>> pool, int currentVisit) {
        // need init 0 and set visitCount=1 and isVisit[0]=true
        if (visitCount >= isVisit.length) {
            return true;
        }

        List<Integer> temp = pool.get(currentVisit);
        for (int tempVisit: temp) {
            if (!isVisit[tempVisit]) {
                isVisit[tempVisit] = true;
                if (dfs(isVisit, visitCount+1, pool, tempVisit)) {
                    return true;
                }
                isVisit[tempVisit] = false;
            }
        }
        return false;

        // don't need any pre-process
//        if (!isVisit[currentVisit]) {
//            isVisit[currentVisit] = true;
//            visitCount++;
//            List<Integer> temp = pool.get(currentVisit);
//            for (int tempVisit : temp) {
//                if (dfs(isVisit, visitCount, pool, tempVisit)) {
//                    return true;
//                }
//                isVisit[tempVisit] = false;
//            }
//        }
//        return visitCount >= isVisit.length;
    }
}
