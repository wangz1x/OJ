package com.wzx.test;

import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Test {
<<<<<<< HEAD
    public static void main(String[] args) {
//        List<String> lists = new ArrayList<String>() {{
//            add("千与千寻");
//            add("白夜行");
//            add("编程珠玑");
//            add("编程之美");
//        }};
//
//        List<String> strings = lists.subList(0, 1);
//        strings.add("Effective Java");
//
//        lists.add("haha");
//
//        strings = null;
//        System.out.println(lists);
//        System.out.println(strings);
//        minNumber(new String[]{"30", "3", "5", "34", "9"});
//        int[][] arr = new int[][]{{6, 2}, {4, 2}};
//        Arrays.sort(arr, (e1, e2) -> e2[1] - e1[1]);
//        System.out.println(Arrays.deepToString(arr));
//        System.out.println(kmp("abcabcabcabcdab", "abcabcdab"));
//        String s = "string";
//        int a = s.charAt(0);
//        System.out.println((char)a);
//        double d = 12324.12521321;
//        String format = String.format("%.4f", d);
//        System.out.println(format);
//        System.out.printf("%.2f", d);
//        System.out.println();
//        System.out.format("%.1f", d);
//        System.out.println();
//        System.out.println(s.matches("abdg.*"));
        String s1 = "12345";
        String s2 = "567432";
        String re = multiply(s1, s2);
        System.out.println(re);
    }

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
=======
>>>>>>> 419cb0a7b9c7a586460052dc9bae72cc9f178007

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
