package com.wzx.test;

import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Test {

    public static String multiply(String s1, String s2) {
        StringBuilder sb1 = new StringBuilder(s1);
        StringBuilder sb2 = new StringBuilder(s2);
        sb1.reverse();
        sb2.reverse();
        int[] a = new int[sb1.length() + sb2.length()];
        for (int i = 0; i < sb1.length(); i++) {
            for (int j = 0; j < sb2.length(); j++) {
                a[i + j] += (sb1.charAt(i) - '0') * (sb2.charAt(j) - '0');
            }
        }
        for (int i = 0; i < a.length - 1; i++) {
            a[i + 1] += a[i] / 10;
            a[i] %= 10;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < a.length - 1; i++) {
            sb.append(a[i]);
        }
        if (a[a.length - 1] != 0) {
            sb.append(a[a.length - 1]);
        }
        return sb.reverse().toString();
    }

    public static final int _1_MB = 1024 * 1024;

    public static ThreadLocal<Integer> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) throws InterruptedException {

        List<GarbageCollectorMXBean> garbageCollectorMXBeans = ManagementFactory.getGarbageCollectorMXBeans();
        for (GarbageCollectorMXBean garbageCollectorMXBean : garbageCollectorMXBeans) {
            System.out.println(garbageCollectorMXBean.getName());
        }
        System.out.println(0x7fffffff);
        Test test = new Test();
        new Thread(() -> {
            test.test("thread", "first");
            threadLocal.set(1);
        }).start();
        new Thread(() -> test.test("thread", "first")).start();

        HashMap<Integer, Integer> map = new HashMap<>();
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        for (Map.Entry<Integer, Integer> entry : entries
             ) {
            entry.getValue();
            entry.getKey();
        }
    }

    public synchronized void test(String arg1, String arg2) {
        synchronized (this) {
            System.out.println(arg1 + arg2);
        }
    }
}
