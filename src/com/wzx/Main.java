package com.wzx;

import java.io.IOException;

public class Main extends Father{


    @Override
    public Main create() throws IOException {
        return (Main) new Object();
    }

    public static void main(String[] args) {
        System.out.println("重写方法: ");
        System.out.println("1. 修饰符不能更严格");
        System.out.println("2. 返回类型可以是原返回类型的子类(因为可以转为父类)");
        System.out.println("3. 抛出的异常可以是原返回类型的子类");
    }
}

class Father {

    protected Father create() throws Exception {
        return new Father();
    }
}


