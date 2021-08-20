package com.wzx.test;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.NavigableSet;
import java.util.TreeSet;

public class Choice<T>{
    public static void main(String[] args) {

        List<String> c = new ArrayList<String>(){};

        Type genericSuperclass = c.getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) genericSuperclass;
        System.out.println(pt.getActualTypeArguments()[0].toString());

        String s = "祝你考出好成绩！";
        String ss = "祝你考出好成绩!";
        System.out.println(s+".length(): "+s.length());
        System.out.println(ss+".length(): "+ss.length());

        NavigableSet<Long> set = new TreeSet<>();
    }

    public void go() {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.print("foo");
            }
        };
        Thread t = new Thread(r);
        t.start();
    }

    static class Inner {

    }
}
