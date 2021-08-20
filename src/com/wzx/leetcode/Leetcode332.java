package com.wzx.leetcode;

import java.util.*;

public class Leetcode332 {
    static int countTickets;

    public static List<String> findItinerary(List<List<String>> tickets) {
        countTickets = tickets.size();

        Set<String> ls = new TreeSet<>();
        for (List<String> lists : tickets) {
            ls.add(lists.get(0));
            ls.add(lists.get(1));
        }

        Map<Integer, String> id2str = new HashMap<>(ls.size());
        Map<String, Integer> str2id = new HashMap<>(ls.size());

        int id = 0;

        for (String s : ls) {
            id2str.put(id, s);
            str2id.put(s, id++);
        }

        int[][] connected = new int[id][id];

        for (List<String> lists : tickets) {
            connected[str2id.get(lists.get(0))][str2id.get(lists.get(1))] = 1;
        }

        List<String> res = new LinkedList<>();
        List<Integer> temp = new ArrayList<>();

        int start = str2id.get("JFK");
        dfs(start, connected, temp, 0);
        temp.add(start);
        for (Integer i : temp) {
            ((LinkedList) res).addFirst(id2str.get(i));
        }
        return res;
    }

    public static boolean dfs(int start, int[][] connected, List<Integer> res, int curTickets) {
        if (curTickets == countTickets) {
            return true;
        }
        for (int i = 0; i < connected.length; i++) {
            if (connected[start][i] == 1) {
                connected[start][i] = 0;
                res.add(i);
                boolean r = dfs(i, connected, res, curTickets + 1);
                if (!r) {
                    connected[start][i] = 1;
                    res.remove(res.size()-1);
                }
            }
        }
        return false;
    }


    public static void main(String[] args) {
        List<List<String>> lists = new ArrayList<>();
        lists.add(new ArrayList<String>(){{add("JFK");add("KUL");}});
        lists.add(new ArrayList<String>(){{add("JFK");add("NRT");}});
        lists.add(new ArrayList<String>(){{add("NRT");add("JFK");}});
        System.out.println(findItinerary(lists));
    }
}
