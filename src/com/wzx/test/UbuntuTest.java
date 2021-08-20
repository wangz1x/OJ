package com.wzx.test;

import java.util.*;

public class UbuntuTest {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("11", "ff");
        map.put("22", "cc");
        map.put("44", "ee");
        Set<Map.Entry<String, String>> entries = map.entrySet();
        entries.removeIf(next -> next.getValue().equals("ff"));
        List<Integer> lists = new ArrayList<>();
        Collections.sort(lists);
    }
}
