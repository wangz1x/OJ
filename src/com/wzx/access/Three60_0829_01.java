package com.wzx.access;
import java.util.Scanner;
public class Three60_0829_01 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), p = in.nextInt(), q = in.nextInt();
        int[] count = new int[101];
        // 记录各个分数的学生数
        for (int i = 0; i < n; i++) {
            count[in.nextInt()]++;
        }
        int max = 100, res = 0;
        for (int i = 100; i >= 0; i--) {
            if (count[i] > 0) {
                // 考试成绩为i，平时成绩为max
                if ((p*max*1.0+q*i)/100 >= 60) {
                    res += count[i];
                    // 后边学生的平时成绩就要减小了
                    max--;
                } else {
                    break;
                }
            }
        }
        System.out.println(res);
    }
}
