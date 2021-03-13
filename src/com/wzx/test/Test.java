package com.wzx.test;

public class Test {
    public static void main(String[] args) {
        String s3 = "aa";
        String s2 = s3.intern();
        String s1 = new String("aa");

        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
        System.out.println(s3 == s2);
    }
}
