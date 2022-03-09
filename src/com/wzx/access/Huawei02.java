package com.wzx.access;

import java.util.*;

public class Huawei02 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String line = input.nextLine();

        String[] directory = line.split("\\s+");
        Map<String, Integer> count = new HashMap<>();

        while(input.hasNext()) {
            // 待匹配
            String word = input.next();

            // 匹配结果
            List<String> res = new ArrayList<>();

            Collections.sort(res, (a, b) -> {if (count.get(a) >= count.get(b)) {
                return 1;
            } else {
                return -1;
            }});

            // 暴力
            for (String s : directory) {
                if (s.startsWith(word)) {
                    count.put(s, count.getOrDefault(s, 0)+1);
                    res.add(s);
                }
            }

            // 根据各个词的count对res排序
            if (res.size() == 0) {
                System.out.print("<null>");
            } else {
                int idx = 1;
                for (String s : res) {
                    System.out.print(idx + "." + s + " ");
                    idx++;
                }
            }
        }
    }
}
