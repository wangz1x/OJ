package com.wzx.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode51 {
    public static void main(String[] args) {
        Leetcode51 l = new Leetcode51();
        System.out.println(l.solveNQueens(4));
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        int[] arr = new int[n];
        dfs(res, arr, n, 0);
        return res;
    }

    public void dfs(List<List<String>> res, int[] temp, int n, int curRow) {

        // ok
        if (curRow == n) {
            List<String> ls = new ArrayList<>();
            // change to List<String>
            for (int i = 0; i < n; i ++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < n; j ++) {
                    if (j == temp[i]) sb.append("Q");
                    else sb.append(".");
                }
                ls.add(sb.toString());
            }
            res.add(new ArrayList<>(ls));
            return;
        }

        for (int i = 0; i < n; i ++) {
            temp[curRow] = i;
            if (isValid(temp, curRow)) {
                dfs(res, temp, n, curRow+1);
            }
        }
    }

    public boolean isValid(int[] temp, int curRow) {
        // column
        for (int i = 0; i < curRow; i ++) {
            if (temp[i] == temp[curRow]) return false;
        }

        // /
        for (int i = 0; i < curRow; i ++) {
            if (i+temp[i] == curRow+temp[curRow]) return false;
        }

        // \
        for (int i = 0; i < curRow; i ++) {
            if (i-temp[i] == curRow-temp[curRow]) return false;
        }

        return true;
    }
}
