package com.wzx.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode842 {
    public static void main(String[] args) {
        String s = "123456579";
        System.out.println(splitIntoFibonacci(s));
    }

    public static List<Integer> splitIntoFibonacci(String S) {
        List<Integer> ret = new ArrayList<>();
        List<int[]> sub = new ArrayList<>();

        if (S.length() < 3) return ret;

        dfs(sub, S, 0);

        if (sub.size()<3) return ret;
        for (int[] arr : sub) {
            ret.add(Integer.parseInt(S.substring(arr[0], arr[1])));
        }
        return ret;
    }

    public static boolean dfs(List<int[]> ret, String S, int start) {
        if (start == S.length()) {
            return ret.size() > 2;
        }

        if (ret.size() < 2) {
            for (int i = 1; i < S.length() - start + 1; i++) {
                long l = Long.parseLong(S.substring(start, start + i));
                if (l > 0x7fffffff || (i > 1 && S.charAt(start) == '0')) break;
                ret.add(new int[]{start, start + i});
                if (dfs(ret, S, start + i)) return true;
                ret.remove(ret.size() - 1);
            }
        } else {
            int[] pre = ret.get(ret.size() - 1);
            int[] prePre = ret.get(ret.size() - 2);

            long preNum = Long.parseLong(S.substring(pre[0], pre[1]));
            long prePreNum = Long.parseLong(S.substring(prePre[0], prePre[1]));
            if (preNum + prePreNum > 0x7fffffff) return false;

            int remainder = S.length() - pre[1];         // start = pre[1]+1
            int startLen = Math.max(pre[1] - pre[0], prePre[1] - prePre[0]);
            if (remainder < startLen) return false;
            for (int i = startLen; i < remainder + 1; i++) {
                long curNum = Long.parseLong(S.substring(start, start + i));
                if (curNum > preNum + prePreNum || (i > 1 && S.charAt(start) == '0')) break;
                if (prePreNum + preNum == curNum) {    // ok
                    ret.add(new int[]{start, start + i});
                    if (dfs(ret, S, start + i)) return true;
                    ret.remove(ret.size() - 1);
                }
            }
        }
        return false;
    }
}
