package com.wzx.access;

import java.util.*;

public class Honor_0807_3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int[][] scores = new int[10][3];
        Map<String, Set<String>> map = new HashMap<>();

        for (int i = 0; i < 10; i++) {
            String name = in.next();
            scores[i][0] = in.nextInt();
            scores[i][1] = in.nextInt();
            scores[i][2] = in.nextInt();

            StringBuilder key = new StringBuilder();
            for (int j = 0; j < 3; j++) {
                key.append(scores[i][j]).append("/");
            }
            Set<String> set = map.getOrDefault(key.toString(), new TreeSet<>());
            set.add(name);
            map.put(key.toString(), set);
        }

        Arrays.sort(scores, (o1, o2) -> {
            int sum1 = 0, sum2 = 0;
            for (int i = 0; i < 3; i++) {
                sum1 += o1[i];
                sum2 += o2[i];
            }

            if (sum1 != sum2) {
                return sum2 - sum1;
            } else if (o1[0] != o2[0]) {
                return o2[0] - o1[0];
            } else if (o1[1] != o2[1]) {
                return o2[1] - o1[1];
            } else if (o1[2] != o2[2]) {
                return o2[2] - o1[2];
            }
            return 0;
        });

        System.out.println("[First round name list]");
        for (int i = 0; i < 10; ) {
            boolean flag = false;
            for (int j = 0; j < 3; j++) {
                if (scores[i][j] < 60) {
                    // 确实不及格
                    flag = true;
                    break;
                }
            }
            if (flag) {
                i++;
                continue;
            }
            // 输出当前成绩对应的学生
            StringBuilder key = new StringBuilder();
            for (int j = 0; j < 3; j++) {
                key.append(scores[i][j]).append("/");
            }
            Set<String> names = map.getOrDefault(key.toString(), new TreeSet<>());
            for (String name : names) {
                System.out.print(name + " ");
                for (int j = 0; j < 3; j++) {
                    System.out.print(scores[i][j] + " ");
                }
                System.out.println();
                i++;
            }
        }

        System.out.println();

        int valid = 0;
        System.out.println("[Final name list]");
        for (int i = 0; i < 10 && valid < 3; ) {
            boolean flag = false;
            for (int j = 0; j < 3; j++) {
                if (scores[i][j] < 60) {
                    // 确实不及格
                    flag = true;
                    break;
                }
            }
            if (flag) {
                i++;
                continue;
            }
            // 输出当前成绩对应的学生
            StringBuilder key = new StringBuilder();
            for (int j = 0; j < 3; j++) {
                key.append(scores[i][j]).append("/");
            }
            Set<String> names = map.getOrDefault(key.toString(), new TreeSet<>());
            for (String name : names) {
                System.out.print(name + " ");
                for (int j = 0; j < 3; j++) {
                    System.out.print(scores[i][j] + " ");
                }
                System.out.println();
                i++;
            }
            valid++;
        }
    }
}
