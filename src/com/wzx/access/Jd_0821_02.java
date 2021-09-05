package com.wzx.access;

import java.util.Random;

/**
 * @author wangzx
 * email wangzx22@163.com
 * date 2021/8/21 下午7:43
 */
public class Jd_0821_02 {

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        Random r = new Random();
        for (int i = 0; i < 500000; i++) {
            sb.append(r.nextDouble() > 0.5 ? 1 : 0);
        }
        String s = sb.toString();
        int n = s.length();
        deal(n, s);
    }

    public static void deal(int n, String s) {
        int[] count_1 = new int[n];
        char[] sc = s.toCharArray();
        for (int i = 0; i < sc.length; i++) {
            if (sc[i] == '1') {
                if (i > 0) {
                    count_1[i] = count_1[i - 1] + 1;
                } else {
                    count_1[i] = 1;
                }
            } else {
                if (i > 0) {
                    count_1[i] = count_1[i - 1];
                } else {
                    count_1[i] = 0;
                }
            }
//            System.out.print(realDeal(i + 1, count_1) + " ");
            realDeal(i + 1, count_1);
        }
    }

    /**
     * @param n       总长度
     * @param count_1 1的个数
     */
    public static int realDeal(int n, int[] count_1) {
        int cur_1 = count_1[n - 1], cur_0 = n - count_1[n - 1];
        if (cur_0 == 0) return cur_1;
        if (cur_1 == 0) return cur_0;
        int min = gcd(cur_0, cur_1);

        boolean valid = true;
        for (int i = min; i >= 2; i--) {
            // 如果0和1都能分成i份
            if (cur_0 % i == 0 && cur_1 % i == 0) {
                // 每i份就要有 cur_0/i和cur_1/i个0和1
                int need_0 = cur_0 / i, need_1 = cur_1 / i, real_1 = 0;
                for (int j = need_0 + need_1 - 1; j < n; j += need_0 + need_1) {
                    if (j - (need_0 + need_1) >= 0) {
                        real_1 = count_1[j] - count_1[j - (need_0 + need_1)];
                    } else {
                        real_1 = count_1[j];
                    }
                    if (real_1 != need_1) {
                        valid = false;
                        break;
                    }
                }
                if (!valid) {
                    valid = true;
                } else {
                    return i;
                }
            }
        }
        return 1;
    }

    public static int gcd(int x, int y) {
        if (x < y) {
            return gcd(y, x);
        }
        if (y == 0) {
            return x;
        } else {
            if ((x & 1) == 0) {
                if ((y & 1) == 0) {
                    return gcd(x >> 1, y >> 1) << 1;
                } else {
                    return gcd(x >> 1, y);
                }
            } else {
                if ((y & 1) == 0) {
                    return gcd(x, y >> 1);
                } else {
                    return gcd(y, x - y);
                }
            }
        }
    }
}
