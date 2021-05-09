package com.wzx.test;

import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Test {

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
