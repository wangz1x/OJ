package com.wzx.access;

import java.util.*;
public class JD_0911_02 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), q = in.nextInt();
        // key 依赖于哪些程序
        Map<Integer, List<Integer>> depend = new HashMap<>();
        // 哪些程序 依赖于 key
        Map<Integer, List<Integer>> depended = new HashMap<>();

        // n 个任务以及他们依赖的任务
        for (int i = 1; i <= n; i++) {
            int count = in.nextInt(), d;
            List<Integer> list = depend.getOrDefault(i, new ArrayList<>());
            for (int j = 0; j < count; j++) {
                d = in.nextInt();
                list.add(d);
                List<Integer> list1 = depended.getOrDefault(d, new ArrayList<>());
                list1.add(i);
                depended.put(d, list1);
            }
            depend.put(i, list);
        }

        boolean[] started = new boolean[n+1];
        for (int i = 0; i < q; i++) {
            int status = in.nextInt(), program = in.nextInt();
            // 启动program程序，以及其所依赖的所有程序，以及其依赖的依赖所依赖的所有程序...
            if (status == 1) {
                start(depend, started, program);
            } else {
                shutdown(depended, started, program);
            }
            System.out.println(count(started));
        }
    }

    public static void start(Map<Integer, List<Integer>> depend,
                             boolean[] started,
                             int program) {
        // 当该程序没有被启动时
        if (!started[program]) {
            started[program] = true;
            // 所有program依赖的程序也要启动
            List<Integer> list = depend.getOrDefault(program, new ArrayList<>());
            for (int ele : list) {
                start(depend, started, ele);
            }
        }
    }

    public static void shutdown(Map<Integer, List<Integer>> depended,
                             boolean[] started,
                             int program) {
        // 如果程序没有被关闭
        if (started[program]) {
            started[program] = false;
            // 所有依赖于program的程序也要关闭
            List<Integer> list = depended.getOrDefault(program, new ArrayList<>());
            for (int ele : list) {
                shutdown(depended, started, ele);
            }
        }
    }

    public static int count(boolean[] started) {
        int count = 0;
        for (int i = 1; i < started.length; i++) {
            if (started[i]) count++;
        }
        return count;
    }
}
