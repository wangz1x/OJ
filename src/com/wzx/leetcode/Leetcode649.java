package com.wzx.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode649 {
    public static void main(String[] args) {
        String se = "DRRDRDRDRDDRDRDR";
        System.out.println(predictPartyVictory(se));
    }

    public static String predictPartyVictory(String senate) {
        char[] chars = senate.toCharArray();

        while (true) {
            int countD = 0;
            int dBanChance = 0;
            List<Integer> cacheD = new ArrayList<>();

            int countR = 0;
            int rBanChance = 0;
            List<Integer> cacheR = new ArrayList<>();
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] == 'D') {
                    if (rBanChance > 0) {
                        chars[i] = 'N';
                        rBanChance--;
                    } else {
                        if (countR > 0) {
                            chars[cacheR.get(0)] = 'N';
                            cacheR.remove(0);
                            countR--;
                            dBanChance--;
                        }
                        countD++;
                        dBanChance++;
                        cacheD.add(i);
                    }
                } else if (chars[i] == 'R') {
                    if (dBanChance > 0) {
                        chars[i] = 'N';
                        dBanChance--;
                    } else {
                        if (countD > 0) {
                            chars[cacheD.get(0)] = 'N';
                            cacheD.remove(0);
                            countD--;
                            rBanChance--;
                        }
                        countR++;
                        rBanChance++;
                        cacheR.add(i);
                    }
                }
            }
            if (countD == 0) return "Radiant";
            else if (countR == 0) return "Dire";
        }
    }
}
