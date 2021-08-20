package com.wzx.extend;

public class Human implements InterOne, InterTwo{

    @Override
    public void sayHello() {
    }

    static class Man extends Human {

    }

    static class Woman extends Human {

    }

    public void isHuman(Human human) {
        System.out.println("this is human");
    }

    public void isHuman(Man man) {
        System.out.println("this is man");
    }

    public void isHuman(Woman woman) {
        System.out.println("this is woman");
    }

    public static void main(String[] args) {
        Man hu = new Man();
        hu.sayHello();
    }
}
