package com.wzx.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wangzx
 * @email wangzx22@163.com
 * @date 2021/7/7 下午3:44
 * 两数之和为2的幂次方的组合数
 */
public class Leetcode1711 {

    public static void main(String[] args) {
        int[] deliciousness = {149,107,1,63,0,1,6867,1325,5611,2581,39,89,46,18,12,20,22,234};
        Leetcode1711 leetcode1711= new Leetcode1711();
        System.out.println(leetcode1711.countPairs(deliciousness));

        long L = 69552L * 69551L/2;

        System.out.println(L%1000000007);
    }

    public int countPairs(int[] deliciousness) {
        Map<Integer, Long> map = new HashMap<>();

        for (int delicious : deliciousness) {
            map.put(delicious, map.getOrDefault(delicious, 0L)+1);
        }

        long res = 0, res_ = 0;
        for (Map.Entry<Integer, Long> entry : map.entrySet()) {
            int k = entry.getKey();
            long v = entry.getValue();
            for (int i = 0; i < 31; i++) {
                int temp = 1<<i;
                int diff = temp-k;

                // 两数相等, 和为2的幂
                if (diff == k) {
                    res = (v*(v-1)/2%1000000007 + res%1000000007)%1000000007;
                } else {
                    long count = map.getOrDefault(diff, 0L);
                    res_ = (v*count%1000000007 + res_%1000000007)%1000000007;
                }
            }
        }
        // 3, 9, 3,
        return (int) (res+res_/2);
    }

}
