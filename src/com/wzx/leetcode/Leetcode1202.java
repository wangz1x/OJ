package com.wzx.leetcode;

import java.util.*;

public class Leetcode1202 {
    public static void main(String[] args) {
//                [[5,3],[3,0],[5,1],[1,1],[1,5],[3,0],[0,2]]
        String s = "pwqlmqm";
        List<List<Integer>> pairs = new ArrayList<>();
        pairs.add(new ArrayList<>(Arrays.asList(5,3)));
        pairs.add(new ArrayList<>(Arrays.asList(3,0)));
        pairs.add(new ArrayList<>(Arrays.asList(5,1)));
        pairs.add(new ArrayList<>(Arrays.asList(1,1)));
        pairs.add(new ArrayList<>(Arrays.asList(1,5)));
        pairs.add(new ArrayList<>(Arrays.asList(3,0)));
        pairs.add(new ArrayList<>(Arrays.asList(0,2)));

        System.out.println(smallestStringWithSwaps(s, pairs));
    }

    public static String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        if (pairs.size() == 0) return s;

        int len = s.length();
        char[] sArr = s.toCharArray();

        Map<Integer, Set<Integer>> hashMap = new HashMap<>();

        for (List<Integer> list : pairs) {
            if (!hashMap.containsKey(list.get(0))) {
                hashMap.put(list.get(0), new HashSet<>(Collections.singletonList(list.get(1))));
            } else {
                hashMap.get(list.get(0)).add(list.get(1));
            }

            if (!hashMap.containsKey(list.get(1))) {
                hashMap.put(list.get(1), new HashSet<>(Collections.singletonList(list.get(0))));
            } else {
                hashMap.get(list.get(1)).add(list.get(0));
            }
        }

        boolean[] visited = new boolean[len];

        Deque<Integer> visit = new LinkedList<>();
        for (int i = 0; i < len; i ++) {
            if (!visited[i]) {
                visited[i] = true;
                // char
                List<Character> set1 = new ArrayList<>();
                // idx
                Set<Integer> set2 = new TreeSet<>();
                visit.addLast(i);

                set1.add(sArr[i]);
                set2.add(i);

                while (!visit.isEmpty()) {
                    Integer head = visit.pollFirst();

                    if (hashMap.get(head) != null) {
                        for (Integer integer : hashMap.get(head)) {
                            if (!visited[integer]) {
                                visited[integer] = true;
                                visit.addLast(integer);
                                set1.add(sArr[integer]);
                                set2.add(integer);
                            }
                        }
                    }
                }
                set1.sort(Comparator.comparingInt(ele -> ele));
                Iterator<Character> iterator1 = set1.iterator();
                Iterator<Integer> iterator2 = set2.iterator();

                while (iterator1.hasNext() && iterator2.hasNext()) {
                    sArr[iterator2.next()] = iterator1.next();
                }
            }
        }

        return String.valueOf(sArr);
    }
}
