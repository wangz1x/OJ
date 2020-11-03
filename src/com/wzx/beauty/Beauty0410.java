package com.wzx.beauty;

public class Beauty0410 {

    public static void main(String[] args) {
        for (int i = 10000; i < 99999; i++) {
            int a1 = i%10;
            int a2 = i/10%10;
            int a3 = i/100%10;
            int a4 = i/1000%10;
            int a5 = i/10000;
            for (int j = 1; j < 10; j++) {
                if (i * j == a1*10000+a2*1000+a3*100+a4*10+a5 && a1 != a2 && a1 != a3 && a1 != a4 && a1 != a5 && a2 != a3 && a4 != a2 && a5 != a2 && a4 != a3 && a3 != a5 && a4 != a5  ) {
                    System.out.println("find: " + i);
                    System.out.println("wo: " + j);
                }
            }
        }
    }
}
