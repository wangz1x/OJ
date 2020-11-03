package com.wzx.leetcode;

import java.util.Arrays;

public class Leetcode927 {
    public static void main(String[] args) {
        int[] A = {0,0,0,0,0,0};
        Leetcode927 ac = new Leetcode927();
        System.out.println(Arrays.toString(ac.threeEqualParts(A)));
    }

    public int[] threeEqualParts(int[] A) {
        int[] former0 = new int[A.length];
        int count = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] != 0) {
                former0[i] = count;
                count = 0;
            } else if (A[i] == 0){
                former0[i] = count;
                count++;
            }
        }

        int firstPoint = 0;
        int secondPoint = 0;
        // must
        int thirdPoint = A.length-1;
        boolean find = false;
        int[] res = {-1, -1};

        for (int validLen = 1; 3*validLen <= A.length; validLen +=1) {
            for (int i = 1; i <= former0[thirdPoint-validLen+1]+1; i ++) {
                secondPoint = thirdPoint-validLen+1 - i;
                if (secondPoint < validLen*2 - 1) break;
                if (A[thirdPoint]!=A[secondPoint]) continue;

                for (int j = 1; j <= former0[secondPoint-validLen+1]+1; j ++) {
                    firstPoint = secondPoint-validLen+1 - j;
                    if (firstPoint < validLen-1) break;
                    if (A[firstPoint]!=A[secondPoint]) continue;

                    if (threeMatch(A, firstPoint, secondPoint, thirdPoint, validLen, former0)) {
                        find = true;
                        res[0] = firstPoint;
                        res[1] = secondPoint+1;
                        break;
                    }
                }
                if (find)
                    break;
            }
            if (find)
                break;
        }
        return res;
    }

    public boolean threeMatch(int[] A, int firstPoint, int secondPoint, int thirdPoint, int validLen, int[] former0) {
        if (firstPoint < validLen-1 || secondPoint < validLen*2 - 1) {
            return false;
        }

        for (int i = 0; i < validLen; i ++) {
            if (A[thirdPoint-i]+A[secondPoint-i]+A[firstPoint-i] != 0 && A[thirdPoint-i]+A[secondPoint-i]+A[firstPoint-i] != 3) {
                return false;
            }
        }
        if (former0[firstPoint-validLen+1] != firstPoint-validLen+1) {
            return false;
        }
        if (former0[secondPoint-validLen+1] < secondPoint-validLen+1 - firstPoint - 1) {
            return false;
        }
        if (former0[thirdPoint-validLen+1] < thirdPoint-validLen+1 - secondPoint - 1) {
            return false;
        }
        return true;
    }

}
