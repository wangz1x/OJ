package com.wzx.beauty;

/**
 * given N
 * find M
 * then M * N only consist of '0' and '1'
 */
public class Beauty0208 {
    public static void main(String[] args) {
        int m, n=125;
        System.out.println(m=findM(n));
        System.out.println(m*n);
    }


    public static int findM(int N) {
        // keep the minimum of each remainder (1~N-1)
        int[] remainders = new int[N];  // remainders[i] 保存 mod N == i的最小整数
        boolean isChange;
        remainders[1] = 1;
        int start = 1;
        for (; ; ) {
            isChange = false;
            start *= 10;
            int remainder1 = start % N;                     //
            int remainder2;

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

            if (remainders[0] != 0) {             // 有一个数 % N == 0, 满足条件
                break;
            }

            if (!isChange) {        // 循环一轮没有任何最小值改变，后续也不用在遍历了
                break;
            }
        }
        return remainders[0]/N;
    }
}
