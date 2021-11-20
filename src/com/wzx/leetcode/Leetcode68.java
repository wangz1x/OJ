package com.wzx.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangzx
 * email wangzx22@163.com
 * date 2021/9/10 下午1:38
 */
public class Leetcode68 {
    public static void main(String[] args) {

    }

    public List<String> fullJustify(String[] words, int maxWidth) {
        // 做了一百遍
        // 1. 遍历单词，统计当前长度, 除非是最后一行，否则当前行的长度为单词的长度+单词个数减1

        List<String> res = new ArrayList<>();

        int start = 0, end = 0, length = 0;

        while (end < words.length) {
            if (words[end].length() + length + end - start <= maxWidth) {
                length += words[end].length();
                end++;
            } else {
                // 空格的长度
                int spaces = maxWidth - length;
                // 空格的个数
                int count = end - 1 - start;
                // 平均每个空白的长度
                int avg = spaces / count;
                // 可能会有一些剩余的需要补充到左边
                int remainder = spaces % count;

                StringBuilder sb = new StringBuilder();
                for (int i = start; i < end - 1; i++) {
                    sb.append(words[i]);
                    for (int j = 0; j < avg; j++) {
                        sb.append(" ");
                    }
                    // 多加一个空格
                    if (i - start < remainder) {
                        sb.append(" ");
                    }
                }
                sb.append(words[end - 1]);
                res.add(sb.toString());
                start = end;
                length = 0;
            }
        }
        // 可能有最后一行
        StringBuilder sb = new StringBuilder();
        length = 0;
        for (int i = start; i < end - 1; i++) {
            length += words[i].length() + 1;
            sb.append(words[i]).append(" ");
        }
        sb.append(words[end - 1]);
        length += words[end - 1].length();
        // 补充最后的空格
        for (int i = maxWidth - length; i > 0; i--) {
            sb.append(" ");
        }
        res.add(sb.toString());
        return res;
    }

}
