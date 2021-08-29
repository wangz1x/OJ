package com.wzx.access;

import java.util.Scanner;
import java.util.TreeSet;
public class Meituan_0822_02 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        char[] str = in.nextLine().toCharArray();

        // 存放 a~z 的位置
        TreeSet<Integer>[] positions = new TreeSet[26];
        for (int i = 0; i < 26; i++) {
            positions[i] = new TreeSet<>();
        }

        // 预处理str
        for (int i = 0; i < str.length; i++) {
            positions[str[i] - 'a'].add(i + 1);
        }

        int n = in.nextInt(), opt, size = str.length;
        char c;
        int pos;

        StringBuilder sb = new StringBuilder(String.valueOf(str));

        for (int i = 0; i < n; i++) {
            opt = in.nextInt();
            if (opt == 1) {
                c = in.next().toCharArray()[0];
                sb.append(c);
                positions[c - 'a'].add(++size);
            } else {
                pos = in.nextInt();
                c = sb.charAt(pos - 1);
                Integer lower = positions[c - 'a'].lower(pos);
                Integer higher = positions[c - 'a'].higher(pos);
                if (lower == null && higher == null) {
                    System.out.println(-1);
                } else if (lower == null) {
                    System.out.println(higher - pos);
                } else if (higher == null) {
                    System.out.println(pos - lower);
                } else {
                    System.out.println(Math.min(higher - pos, pos - lower));
                }
            }
        }
    }
}
