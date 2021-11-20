package com.wzx.test;

/**
 * @author wangzx
 * email wangzx22@163.com
 * date 2021/9/1 上午11:25
 */
public enum EnumTest {
    SAVING, FIXED, CURRENT;
    private EnumTest() {
        System.out.println("NEW EnumTest");
    }
}

class Main {
    public static void main(String[] args) {
        System.out.println(EnumTest.FIXED);
        for (EnumTest value : EnumTest.values()) {
            System.out.println(value);
        }
    }
}

