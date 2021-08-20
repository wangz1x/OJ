package com.wzx.leetcode;

public class Leetcode705 {
    // 一个int 32位，可以表示 32 个数， 32*idx + remainder
    // 由于 32 是2的幂次方, 因此对32 求余 可以 key & (32-1)， 至于放第几个桶，就要做除法, 直接右移5位
    static int[] exist = new int[1000000 >>> 5 + 1];

    public static void main(String[] args) {
        System.out.println(1000000 >>> 5);
    }

    public static void add(int key) {
        int idx = key >>> 5;         // 放在哪个桶
        int remainder = key & 31;    // 在该桶的第几位
        exist[idx] |= (1 << remainder);
    }

    public static void remove(int key) {
        int idx = key >>> 5;         // 放在哪个桶
        int remainder = key & 31;    // 在该桶的第几位
        if (contains(key))
            exist[idx] ^= (1 << remainder);
    }

    /**
     * Returns true if this set contains the specified element
     */
    public static boolean contains(int key) {
        int idx = key >>> 5;         // 放在哪个桶
        int remainder = key & 31;    // 在该桶的第几位
        return (exist[idx] & (1 << remainder)) == 1;
    }
}
