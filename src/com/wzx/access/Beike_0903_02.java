package com.wzx.access;
import java.util.Scanner;
/**
 * @author wangzx
 * email wangzx22@163.com
 * date 2021/9/3 下午6:39
 */
public class Beike_0903_02 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // T组测试用例
        int T = in.nextInt();
        for (int i = 0; i < T; i++) {
            int len = in.nextInt();
            in.nextLine();
            String line = in.nextLine();
            System.out.println(deal(line));
        }
    }

    public static int deal(String line) {
        int n = line.length();

        int l, r, res = 0;
        // 预处理
        for (l = 0, r = n - 1; l < r; l++, r--) {
            if (line.charAt(l) == ')' && line.charAt(r) == '(') {
                res++;
            } else {
                break;
            }
        }

        int left = 0;
        for (int i = l; i <= r; i++) {
            char c = line.charAt(i);
            if (c == '(') {
                left++;
            } else if (c == ')') {
                if (left == 0) {
                    res++;
                } else {
                    left--;
                }
            }
        }
        return res;
    }
}
