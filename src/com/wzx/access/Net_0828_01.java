package com.wzx.access;

import java.util.Scanner;

public class Net_0828_01 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 数据组数
        int T = in.nextInt();
        for (int i = 0; i < T; i++) {
            // 怪物数量
            int N = in.nextInt();
            int[][] data = new int[N][3];
            // 主角 攻击，防御
            int actorAtk = in.nextInt(), actorDef = in.nextInt();

            // 录入怪物的信息
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < 3; k++) {
                    data[j][k] = in.nextInt();
                }
            }
            System.out.println(deal(data, actorAtk, actorDef));
        }
    }

    public static int deal(int[][] data, int atk, int def) {
        int minHp = 0x7fffffff, curHp = 0, N = data.length;

        // 遍历每个怪兽
        for (int[] monster : data) {
            // 当主角的无法击穿怪物的护甲时，其无法继续通关
            if (atk <= monster[1]) {
                return -1;
            }

            // 当怪物还没死时
            while (monster[2] > 0) {
                // 主角回合
                if (atk - monster[1] >= monster[2]) {
                    // 主角攻击能一击必杀时，发动被动
                    curHp += atk - monster[1] - monster[2];
                    // 怪物死了，推出
                    break;
                } else {
                    monster[2] -= atk-monster[1];
                }

                // 怪物回合
                if (monster[0]>def) {
                    // 敌方能击穿我方护甲
                    curHp -= monster[0]-def;
                }
                // 取最小的血量
                minHp = Math.min(minHp, curHp);
            }
        }
        return minHp>0 ? 1 : 1-minHp;
    }
}
