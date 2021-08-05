package com.wzx.access;

import java.util.*;

public class Pdd_0725_2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // N 张牌
        int N = in.nextInt();
        // 多多鸡的牌
        int[] ji = new int[N];
        // 多多鸭的牌
        int[] ya = new int[N];
        for (int i = 0; i < N; i++) {
            ji[i] = in.nextInt();
        }
        for (int i = 0; i < N; i++) {
            ya[i] = in.nextInt();
        }

        int pointer_ji = 0, pointer_ya = 0;
        // 筹码
        int own_ji = 0, own_ya = 0;
        // 记录放的牌
        int[] count = new int[14];

        Deque<Integer> stack = new LinkedList<>();
        boolean jump = false;

        while (pointer_ji < N && pointer_ya < N) {
            if (!jump) {
                // 鸡先放
                if (count[ji[pointer_ji]] != 0) {
                    own_ji++;
                    while (!stack.isEmpty()) {
                        own_ji++;
                        int ele = stack.pop();
                        count[ele]--;
                        if (ele == ji[pointer_ji]) {
                            break;
                        }
                    }
                    pointer_ji++;
                    continue;
                } else {
                    stack.push(ji[pointer_ji]);
                    count[ji[pointer_ji]]++;
                    pointer_ji++;
                }
            }

            // 鸡没有收，鸭再放
            if (count[ya[pointer_ya]] != 0) {
                own_ya++;
                while (!stack.isEmpty()) {
                    own_ya++;
                    int ele = stack.pop();
                    count[ele]--;
                    if (ele == ya[pointer_ya]) {
                        break;
                    }
                }
                pointer_ya++;
                jump = true;
            } else {
                stack.push(ya[pointer_ya]);
                count[ya[pointer_ya]]++;
                pointer_ya++;
                jump = false;
            }
        }
        // 如果鸡还有剩余的话
        while (pointer_ji < N) {
            if (count[ji[pointer_ji]] != 0) {
                own_ji++;
                while (!stack.isEmpty()) {
                    own_ji++;
                    int ele = stack.pop();
                    count[ele]--;
                    if (ele == ji[pointer_ji]) {
                        break;
                    }
                }
            } else {
                stack.push(ji[pointer_ji]);
                count[ji[pointer_ji]]++;
            }
            pointer_ji++;
        }
        // 如果鸭还有剩余
        while (pointer_ya < N) {
            if (count[ya[pointer_ya]] != 0) {
                own_ya++;
                while (!stack.isEmpty()) {
                    own_ya++;
                    int ele = stack.pop();
                    count[ele]--;
                    if (ele == ya[pointer_ya]) {
                        break;
                    }
                }
            } else {
                stack.push(ya[pointer_ya]);
                count[ya[pointer_ya]]++;
            }
            pointer_ya++;
        }
        // 把剩下的牌分了
        for (int i = 1; i < 14; i++) {
            if ((i & 1) == 1) {
                own_ji += count[i];
            } else {
                own_ya += count[i];
            }
        }
        System.out.println(own_ji + " " + own_ya);
    }
}
