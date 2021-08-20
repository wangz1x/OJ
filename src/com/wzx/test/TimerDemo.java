package com.wzx.test;

import java.util.Timer;
import java.util.TimerTask;

public class TimerDemo {
    public static void main(String[] args) throws InterruptedException {
        Timer t = new Timer("timer demo");

        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                System.out.println("I'm running at " + System.currentTimeMillis());
            }
        };
        System.out.println("-----------------------begin at: " + System.currentTimeMillis() + "----------------------- ");
        t.schedule(timerTask, 5000, 1000);

        System.out.println("------------------------main sleep() ----------------------");
        Thread.sleep(10000);
        System.out.println("timerTask cancel...");
        timerTask.cancel();
        System.out.println("timer cancel");
        t.cancel();
    }
}
