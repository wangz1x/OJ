package com.wzx.util;

import java.util.Random;

/**
 * @author wangzx
 * @email wangzx22@163.com
 * @date 2021/5/24 下午9:10
 */
public class StrGenerator {

    public static void main(String[] args) {
        int length = 100;

        Random random = new Random();
        StringBuilder sb = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            char c = (char)(random.nextInt(26)+97);
            sb.append(c);
        }
        // "ckmftlqffflxjwr"
        System.out.println(sb.toString());
    }
}
