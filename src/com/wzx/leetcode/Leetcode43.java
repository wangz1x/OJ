package com.wzx.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode43 {
    public static void main(String[] args) {
        System.out.println(multiply("25", "50"));
    }

    public static String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) return "0";

        if ("1".equals(num1)) return num2;

        if ("1".equals(num2)) return num1;

        List<Integer> temp = new ArrayList<>();

        for (int i = num1.length()-1; i >= 0; i --) {
            int a1 = num1.charAt(i) - '0';
            int forward = 0;

            for (int j = num2.length()-1; j >=0; j --) {
                int b1 = num2.charAt(j) - '0';

                int curIndex = num1.length()-1 - i + num2.length()-1 - j;
                int product = a1 * b1 + forward;

                if (curIndex <= temp.size() - 1) {
                    product += temp.get(curIndex);
                    forward = product / 10;
                    product %= 10;
                    temp.set(curIndex, product);
                }
                else {
                    forward = product / 10;
                    temp.add(product%10);
                }
            }
            temp.add(forward);
        }

        StringBuilder sb = new StringBuilder();
        if (temp.get(temp.size()-1) != 0) {
            sb.append(temp.get(temp.size()-1));
        }
        for (int i = temp.size()-2; i >= 0; i --) {
            sb.append(temp.get(i));
        }
        return sb.toString();
    }
}
