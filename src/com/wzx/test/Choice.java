package com.wzx.test;

public class Choice {
    public static void main(String[] args) {
//        new Choice().go();
        String s = "祝你考出好成绩！";
        String ss = "祝你考出好成绩!";
        System.out.println(s+".length(): "+s.length());
        System.out.println(ss+".length(): "+ss.length());
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
}
