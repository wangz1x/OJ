package com.wzx.windows;

import java.util.ArrayList;
import java.util.List;

public class CaseDemo {
    static final String STR;

    static {
        STR = "hello";
    }

    static String a = "6";
    static double b = 1;

    public static void main(String[] args) {
        int c = 8;
        System.out.println(a+b+c);

        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        for (String ele : list) {
            if ("1".equals(ele)) {
                list.remove(ele);
                System.out.println("delete 1 success");
            }
        }
        for (String ele : list) {
            if ("2".equals(ele)) {
                list.remove(ele);
                System.out.println("delete 2 success");
            }
        }
    }
}
