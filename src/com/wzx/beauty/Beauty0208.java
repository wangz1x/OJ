package com.wzx.beauty;

import java.util.Arrays;

/**
 * given N
 * find M
 * then M * N only consist of '0' and '1'
 */
public class Beauty0208 {
    public static void main(String[] args) {
        System.out.println(findM(9));
    }

    public static int findM(int N) {
        // keep the minimum of each remainder (1~N-1)
        int[] remainders = new int[N];
        boolean isChange = false;
        remainders[1] = 1;
        int start = 1;
        for (int i = 1; ; i++) {
            start *= 10;
            int remainder1 = start % N;
            int remainder2 = 0;

            if (remainders[remainder1] == 0 || start < remainders[remainder1]) {
                remainders[remainder1] = start;
                isChange = true;
            }

            // loop remainder
            for (int j = 1; j < N; j++) {
                if (remainders[j] != 0 && remainders[j] < start) {
                    remainder2 = (remainder1 + remainders[j]) % N;
                    if (remainders[remainder2] == 0 || start + remainders[j] < remainders[remainder2]) {
                        remainders[remainder2] = start + remainders[j];
                        isChange = true;
                    }
                }
            }

            if (remainders[0] != 0) {
                break;
            }

            if (isChange) {
                isChange = false;
            } else {
                break;
            }
        }
        return remainders[0]/N;
    }
}
