package com.wzx.poj;

public class Poj2411 {
    public static void main(String[] args) {
        System.out.println(filledWithRec(4, 11));
    }

    public static int filledWithRec(int h, int w) {
        if ((h*w & 1) == 1)
            return 0;
        int[][][] dp = new int[h][w][1 << w];
        // dp[i][j][k] represent how many different ways to cover the remainder place after (i, j) at status k
        dp[h - 1][w - 1][0] = 0;
        dp[h - 1][w - 1][1] = 1;

        int[] next = {-1, -1};

        for (int i = h - 1; i >= 0; i--) {
            for (int j = w - 1; j >= 0; j--) {
                boolean hasNext = hasNext(i, j, h, w, next);
                for (int k = 0; k < (1 << w); k++) {
                    // if (i, j) is filled
                    if ((k & 1) == 1) {
                        if (hasNext)
                            dp[i][j][k] = dp[next[0]][next[1]][k>>>1];
                    }
                    else {
                        // fill (i, j) with a 1*2 row, with status 00...
                        if (j+1<w && ((k&2) == 0)) {
                            dp[i][j][k] += dp[next[0]][next[1]][(k|2)>>>1];
                        }
                        // fill (i, j) with a 2*1 column
                        if (i+1 < h) {
                            dp[i][j][k] += dp[next[0]][next[1]][(k>>>1)|(1<<(w-1))];
                        }
                    }
                }
            }
        }
        return dp[0][0][0];
    }

    public static boolean hasNext(int i, int j, int h, int w, int[] next) {
        if (i == h - 1 && j == w - 1)
            return false;
        next[1] = (j + 1) % w;
        next[0] = j == w - 1 ? i + 1 : i;
        return true;
    }
}
