package com.wzx.leetcode;

/**
 * @author wangzx
 * @email wangzx22@163.com
 * @date 2021/6/3 下午1:16
 */
public class Leetcode854 {

    public static void main(String[] args) {
        String str1 = "aabbccddee";
        String str2 = "dcacbedbae";

        System.out.println(kSimilarity(str1, str2));
    }

    public static int kSimilarity(String s1, String s2) {
        // 统计两个字符串中, 各个位置字符对应的数量
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();

        int[][] count = new int[6][6];
        for (int i = 0; i < chars1.length; i++) {
            if (chars1[i] != chars2[i]) {
                count[chars1[i]-'a'][chars2[i]-'a']++;
            }
        }

        int res = 0;

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                while (count[i][j] > 0) {
                    res+=(dfs(count, i, j, i, 1)-1);
                }
            }
        }

        return res;
    }

    public static int dfs(int[][] count, int curx, int cury, int end, int num) {
        if (count[curx][cury] > 0) {
            count[curx][cury]--;
            // 从cury出发
            if (count[cury][end] > 0) {
                count[cury][end]--;
                return num+1;
            }
            for (int i = 0; i < 6; i++) {
                if (count[cury][i] != 0) {
                    int temp = 0;
                    if ((temp = dfs(count, cury, i, end, num+1)) != 0) {
                        return temp;
                    }
                }
            }
        }
        return 0;
    }
}
