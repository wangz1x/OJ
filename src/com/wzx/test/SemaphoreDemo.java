package com.wzx.test;

import java.util.concurrent.Semaphore;

/**
 * @author wangzx
 * email wangzx22@163.com
 * date 2021/9/1 下午2:38
 */
public class SemaphoreDemo {

    static Semaphore semaphore = new Semaphore(1);
    static int count = 0;

    public static void main(String[] args) throws InterruptedException {

        long a = 123;
//        float b = 1.2;
        double c = 1.2;
//        int d = 11L;

        Thread one = new Thread(() -> {
            try {
                while (count < 100) {
                    semaphore.acquire();
                    if (count % 2 == 0) {
                        System.out.println("Thread one print: " + count++);
                    }
                    semaphore.release();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread two = new Thread(() -> {
            try {
                while (count < 100) {
                    semaphore.acquire();
                    if (count % 2 == 1) {
                        System.out.println("Thread two print: " + count++);
                    }
                    semaphore.release();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        one.join();
        two.join();

        one.start();
        two.start();
    }
}
