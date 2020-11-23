package com.wzx.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Leetcode65 {
    public static void main(String[] args) {
        System.out.println(isNumber("-.1e1"));
    }

    public static boolean isNumber(String s) {
        s = s.trim();
        Automation au = new Automation();
        for (int i = 0; i < s.length(); i ++) {
            char c = s.charAt(i);
            if (!au.meet(c)) return false;
        }
        return au.meet_[3];
    }


    static class Automation {
        private String state = "start";
        // sign, point, e, num
        private boolean[] meet_ = new boolean[4];
        private Map<String, String[]> table = new HashMap<String, String[]>() {{
            put("start", new String[] {"in_sign", "in_point", "end", "in_number", "end"});
            put("in_sign", new String[] {"end", "in_point", "end", "in_number", "end"});
            put("in_point", new String[] {"end", "end", "in_e", "in_number", "end"});
            put("in_e", new String[] {"in_sign", "end", "end", "in_number", "end"});
            put("in_number", new String[] {"end", "in_point", "in_e", "in_number", "end"});
            put("end", new String[] {"end", "end", "end", "end", "end"});

        }};

        public boolean meet(char c) {
            // if sign . e repeat, then false
            if (get_col(c) < 3 && meet_[get_col(c)] || c == ' ') return false;

            state = table.get(state)[get_col(c)];

            if ("in_sign".equals(state)) meet_[0] = true;
            else if ("in_point".equals(state)) meet_[1] = true;
            else if ("in_e".equals(state)) {
                // set e
                meet_[2] = true;
                // reset +/-
                meet_[0] = false;
                // set .
                meet_[1] = true;
                // set number
                if (!meet_[3]) return false;
                meet_[3] = false;
            }
            else if ("in_number".equals(state)) meet_[3] = true;

            return !"end".equals(state);
        }

        public int get_col(char c) {
            if (c == '+' || c == '-') return 0;
            if (c == '.') return 1;
            if (c == 'e') return 2;
            if (c <= '9' && c >= '0') return 3;
            return 4;
        }
    }
}
