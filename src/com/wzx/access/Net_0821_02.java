package com.wzx.access;

/**
 * @author wangzx
 * email wangzx22@163.com
 * date 2021/8/21 下午4:16
 */
public class Net_0821_02 {

    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        String[] input = in.nextLine().split(",");
//        int n = Integer.parseInt(input[0]);
//        int p = Integer.parseInt(input[1]);
//        System.out.println(deal(n, p-1, false));
        int n = 5;
//        int p = 11102;
        for (int p = 1; p < (1 << n); p++)
            System.out.print(deal(n, p - 1, false));
    }

    /**
     * 返回第n个串的第p位
     *
     * @param n
     * @param p
     * @return
     */
    public static char deal(int n, int p, boolean reverse) {

        int len = (1 << n) - 1;

        int mid = (len - 1) >> 1;

        if (p == mid) {

            return reverse ? (char) ('a' + (26 - n)) : (char) ('a' + n - 1);
        }
        if (p < mid) {
            // left part
            return deal(n - 1, p, false);

        } else {
            // right part
            return deal(n - 1, p - mid - 1, true);
        }
    }
}
