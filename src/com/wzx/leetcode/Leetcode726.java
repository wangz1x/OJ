package com.wzx.leetcode;

import java.util.*;

/**
 * @author wangzx
 * @email wangzx22@163.com
 * @date 2021/7/5 上午11:51
 */
public class Leetcode726 {

    public static void main(String[] args) {
        Leetcode726 leetcode726 = new Leetcode726();
        String formula = "(H)";
        System.out.println(leetcode726.countOfAtoms(formula));
    }

    public String countOfAtoms(String formula) {
        // 去括号
        Deque<String> stack = new LinkedList<>();
        char[] formulas = formula.toCharArray();
        for (int i = 0; i < formulas.length; ) {
            if (formulas[i] == '(') {
                stack.push("(");
                i++;
            } else if (formulas[i] == ')') {
                stack.push(")");
                i++;
                int countNum = 1;
                if (i < formulas.length && formulas[i] >= '0' && formulas[i] <= '9') {
                    // 碰到数字, 说明是在右括号后边出现的, 那么前边一对括号中出现的原子的个数都要和该数字相乘
                    StringBuilder count = new StringBuilder();
                    while (i < formulas.length && formulas[i] >= '0' && formulas[i] <= '9') {
                        count.append(formulas[i]);
                        i++;
                    }
                    countNum = Integer.parseInt(count.toString());
                }
                stack.pop();
                List<String> list = new ArrayList<>();
                while (!stack.isEmpty()) {
                    String s = stack.pop();
                    // 没有遇到左括号
                    if (!"(".equals(s)) {
                        String[] ss = s.split(":");
                        list.add(ss[0] + ":" + Integer.parseInt(ss[1]) * countNum);
                    } else {
                        break;
                    }
                }
                for (String s : list) {
                    stack.push(s);
                }
            } else if (formulas[i] >= 'A' && formulas[i] <= 'Z') {
                // 原子表达式得到了
                StringBuilder sb = new StringBuilder();
                sb.append(formulas[i]);
                i++;
                while (i < formulas.length && formulas[i] >= 'a' && formulas[i] <= 'z') {
                    sb.append(formulas[i]);
                    i++;
                }
                // 计算个数
                StringBuilder count = new StringBuilder();
                while (i < formulas.length && formulas[i] >= '0' && formulas[i] <= '9') {
                    count.append(formulas[i]);
                    i++;
                }
                int countNum = 1;
                if (count.length() > 0) {
                    countNum = Integer.parseInt(count.toString());
                }
                stack.push(sb.toString() + ":" + countNum);
            }
        }
        // 都处理完了
        Map<String, Integer> map = new TreeMap<>();
        while (!stack.isEmpty()) {
            String[] s = stack.pop().split(":");
            int orDefault = map.getOrDefault(s[0], 0);
            map.put(s[0], Integer.parseInt(s[1]) + orDefault);
        }

        StringBuilder res = new StringBuilder();
        map.forEach((k, v) -> {
            res.append(k);
            if (v > 1) {
                res.append(v);
            }
        });

        return res.toString();
    }
}
