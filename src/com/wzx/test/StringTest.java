package com.wzx.test;

public class StringTest {
    public static void main(String[] args) {
        String str0 = "str0";
        String str1 = "str1"+"str2";
        String str2 = new String("newString");
        System.out.println(str0 == new InnerStringTest().str);
    }
}

class InnerStringTest {
    public String str = "str0";
}