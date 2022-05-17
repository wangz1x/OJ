package com.wzx.algorithm;

import java.util.*;

public class SDPToMCS {

    /**
     * 算法流程
     *
     * @param SDPs 所有的SDP路径
     */
    public static void covertSDPsToMCSs(String[] SDPs) {
        for (String sdp : SDPs) {
            Set<String> certain = new HashSet<>();
            Set<String> possible = new HashSet<>();
            Set<String> impossible = new HashSet<>();
            List<List<String>> sequence = new ArrayList<>();
            // 事件分类
            classifyEvents(sdp, certain, possible, impossible, sequence);
            // 可能事件所有的组合
            List<Set<String>> subset = subset(possible);
            // 遍历每种组合, 存在组合中的可能事件当前为发生事件, 其他的为不发生事件
            for (Set<String> set : subset) {
                Set<String> tempCertain = new HashSet<>(certain);
                Set<String> tempImpossible = new HashSet<>(impossible);

                // 将其与必然事件合并
                for (String str : possible) {
                    if (set.contains(str)) {
                        tempCertain.add(str);
                    } else {
                        tempImpossible.add(str);
                    }
                }

                // 并计算tempCertain全排列
                List<List<String>> permutation = permutation(tempCertain);
                // 用得到的序列验证这些全排列
                for (List<String> list : permutation) {
                    boolean flag = true;

                    for (List<String> seq : sequence) {
                        int idx1 = list.indexOf(seq.get(0));
                        int idx2 = list.indexOf(seq.get(1));
                        if (idx2 >= 0 && idx1 > idx2) {
                            flag = false;
                            break;  // 当前list不满足所有序列关系, 直接退出
                        }
                    }
                    if (flag) {
                        System.out.println(list);
                    }
                }
            }
            System.out.println("-------------------------------");
        }
    }

    /**
     * 将一条SDP中涉及到的各种事件分类
     * 1. 必然事件
     * 2. 不可能事件
     * 3. 可能事件
     *
     * @param SDP        format: -A*B*C*D*(C<B)*(B<D)
     * @param certain    必然事件集合
     * @param possible   可能事件集合
     * @param impossible 不可能事件集合
     * @param sequence   保存时序关系，用于后续的验证
     */
    public static void classifyEvents(String SDP, Set<String> certain,
                                      Set<String> possible, Set<String> impossible,
                                      List<List<String>> sequence) {
        String[] items = SDP.split("\\*");
        for (String item : items) {
            if (item.startsWith("-")) {  // 如果是非开头，说明是不能事件
                String event = item.substring(1);
                impossible.add(event);
                possible.remove(event);
            } else if (item.contains("<")) {  // 如果包含<, 说明是个时序, 后边验证要用到
                String[] events = item.substring(1, item.length()-1).split("<");
                certain.add(events[0]); // 第一个是必然事件
                possible.remove(events[0]);
                // 第二个是可能事件, 但是放之前需要判断它是不是已经是个必然事件, 或者不可能事件了
                if (!certain.contains(events[1]) && !impossible.contains(events[1])) {
                    possible.add(events[1]);
                }
                // 把时序保存, event[0],event[1]
                sequence.add(Arrays.asList(events[0], events[1]));
            } else {  // 否则就是普通的必然事件
                certain.add(item);
            }
        }
    }

    /**
     * 计算可能事件的所有子集
     *
     * @param possible 可能事件集合
     */
    public static List<Set<String>> subset(Set<String> possible) {
        List<Set<String>> res = new ArrayList<>();
        // 空集
        res.add(new HashSet<>());
        for (String str : possible) {
            // 遍历当前res中存在的集合
            int count = res.size();
            for (int i = 0; i < count; i++) {
                Set<String> set = new HashSet<>(res.get(i));
                set.add(str);
                res.add(set);
            }
        }
        return res;
    }

    /**
     * 计算tempCertain中包含元素的全排列
     * @param tempCertain 所有的元素
     * @return
     */
    public static List<List<String>> permutation(Set<String> tempCertain) {
        List<List<String>> res = new ArrayList<>();

        List<String> list = new ArrayList<>(tempCertain.size());

        Set<String> contain = new HashSet<>();

        backtrace(res, list, contain, 0, tempCertain);

        return res;
    }

    public static void backtrace(List<List<String>> res, List<String> list, Set<String> contain, int count, Set<String> tempCertain) {
        if (count == tempCertain.size()) {
            res.add(new ArrayList(list));
            return;
        }
        for (String str : tempCertain) {
            if (!contain.contains(str)) {
                list.add(str);
                contain.add(str);
                backtrace(res, list, contain, count + 1, tempCertain);
                list.remove(list.size() - 1);
                contain.remove(str);
            }
        }
    }


    public static void main(String[] args) {
//        String[] strings = {"B*(A<S)*(S<B)*(S<C)", "-B*C*(A<S)*(S<C)"};
        String[] strings = {"A*B", "-A*B*-C*D*(B<D)", "-A*B*C*D*(B<C)", "-A*B*C*D*(C<B)*(B<D)"};
        covertSDPsToMCSs(strings);
    }
}
