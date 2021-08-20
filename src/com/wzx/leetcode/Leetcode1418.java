package com.wzx.leetcode;

import java.util.*;

/**
 * @author wangzx
 * @email wangzx22@163.com
 * @date 2021/7/6 下午5:44
 * 重构订单
 */
public class Leetcode1418 {

    public List<List<String>> displayTable(List<List<String>> orders) {
        // tableNumber,  foodItem, foodCount
        Map<Integer, Map<String, Integer>> map = new TreeMap<>();
        // foodItem
        Set<String> set = new TreeSet<>();
        for (List<String> order : orders) {
            int tableNumber = Integer.parseInt(order.get(1));
            String foodItem = order.get(2);
            set.add(foodItem);
            Map<String, Integer> temp = map.getOrDefault(tableNumber, new TreeMap<>());
            temp.put(foodItem, temp.getOrDefault(foodItem, 0)+1);
        }

        List<List<String>> res = new ArrayList<>();
        List<String> title = new ArrayList<>();

        title.add("Table");
        title.addAll(set);
        res.add(title);
        map.forEach((k, v)->{
            List<String> record = new ArrayList<>();
            record.add(String.valueOf(k));
            for (String food : set) {
                record.add(String.valueOf(v.getOrDefault(food, 0)));
            }
            res.add(record);
        });
        return res;
    }
}
