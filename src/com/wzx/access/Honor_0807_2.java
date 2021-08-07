package com.wzx.access;

import java.util.Scanner;

public class Honor_0807_2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] words = in.next().split(",");
        int L = in.nextInt();

        StringBuilder sb = new StringBuilder();

        // 这一行的长度?
        int length = 0;

        // 这一行包含的单词的起始和结束坐标?
        int start = 0, end = 0;

        // 循环处理每个单词
        for (end = 0; end < words.length; end++) {

            // 判断当前单词是否能放在当前建立的这一行

            // 假设能放下
            // case 1. 很充足
            // case 2. 刚刚好
            if (length + words[end].length() < L) {
                length += words[end].length();
                // 每个单词后边至少空一格
                length++;
            } else if (length + words[end].length() == L) {
                // 此时就要输出了
                for (int j = start; j < end; j++) {
                    sb.append(words[j]).append("*");
                }
                sb.append(words[end]);
                System.out.println(sb.toString());

                // init
                sb = new StringBuilder();
                start = end + 1;
                length = 0;
            } else {
                // 放不下第end个单词了, 那就不放了

                // 不包含第end个单词
                int wordCount = end - start;

                if (wordCount == 1) {
                    sb.append(words[start]);

                    int star = L-(length-1);

                    for (int k = 0; k < star; k++) {
                        sb.append("*");
                    }
                } else {
                    // 有几个单词, 前边就预留了几个空格，要计算出全部的空格
                    int space = wordCount + L-length;

                    // 需要空 wordCount - 1
                    int each = space/(wordCount-1);

                    // 前这么多个要多加一个空格
                    int remainder = space%(wordCount-1);

                    for (int j = start; j < end-1; j++) {
                        sb.append(words[j]);
                        for (int k = 0; k < each; k++) {
                            sb.append("*");
                        }
                        // 当前是否是 remainder 个空格中的一个
                        if (j-start+1 <= remainder) {
                            sb.append("*");
                        }
                    }
                    sb.append(words[end-1]);
                }
                System.out.println(sb.toString());

                // init
                sb = new StringBuilder();
                start = end;
                // 这个是和后边循环中 end++抵消，因为第end个单词还没处理
                end--;
                length = 0;
            }
        }
        // 缓冲区还有内容
        if (length != 0) {

            int star = L-(length-1);

            for (int j = start; j < end; j++) {
                sb.append(words[j]).append("*");
            }
            for (int j = 0; j < star-1; j++) {
                sb.append("*");
            }
            System.out.println(sb.toString());
        }
    }
}
