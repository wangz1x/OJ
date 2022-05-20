package com.wzx.algorithm;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        new Solution().test();
    }

    public void test() {
        Node B = new Node("B", false, "",
                new Node("0", false, ""),
                new Node("A", false, "",
                        new Node("C", false, "",
                                new Node("D", false, "",
                                        new Node("0", false, ""),
                                        new Node("1", true, "B<D")),
                                new Node("D", false, "",
                                        new Node("1", true, "B<C"),
                                        new Node("1", true, "B<D+B<C"))),
                        new Node("1", false, "")));
        //     A<B*A<C + D<E
        // ==> A<B*A<C
        // ==>         + (B<A+C<A)*D<E
        // ==>         + (B<A+A<B*C<A)*D<E
        // ==>         + B<A*D<E + A<B*C<A*D<E

        Node A = new Node("A", false, "",
                new Node("B", false, "",
                        new Node("0", false, ""),
                        new Node("S", false, "",
                                new Node("0", false, ""),
                                new Node("1", true, "B<S+S<B"))),
                new Node("B", false, "",
                        new Node("S", false, "",
                                new Node("0", false, ""),
                                new Node("1", true, "A<S+S<A")),
                        new Node("1", false, "")));

        Set<String> nodes = new HashSet<>();
        Set<String> result = new HashSet<>();
        recurse(A, nodes, result);

        result.add("A<B<C<D");
        result.add("A<B");
        result.add("B<D<C<A");
        result.add("B<C");
        result.add("C<A");
        result.add("{A,B,C}");
        result.add("{A}");
        result.add("{B,C}");
        result.add("{C}");
        result.add("{C,D}");

        System.out.println(result);
        // 存储最小割集
        List<Set<String>> cutSet = new ArrayList<>();
        Trie trie = new Trie();
        for (String res : result) {
            if (res.contains("<")) {  // 表明是一个时序关系, 计算最小割序
                String[] sequences = res.split("<");
                trie.insert(sequences);
            } else {                  // 计算最小割集
                String temp = res.substring(1, res.length() - 1);
                String[] splits = temp.split(",");      // 得到所有的基本事件
                Set<String> cut = new HashSet<>(Arrays.asList(splits));
                getCutSet(cutSet, cut);
            }
        }

        List<String> temp = new ArrayList<>();
        Set<String> res = new HashSet<>();
        trie.getMinCutSeq(trie.root, temp, res);
        System.out.println(res);
        System.out.println(cutSet);
    }

    // 最小割集
    public void getCutSet(List<Set<String>> cutSet, Set<String> cur) {
        if (cutSet.size() == 0) {
            cutSet.add(cur);
        } else {
            boolean cont = true;   // 判断cur是否暂时为最小割集
            // 从当前最小割集的最后一个开始与cur判断
            for (int i = cutSet.size() - 1; i >= 0; i--) {
                boolean flag = true;  // 用于判断cur和当前最小割集的比较关系
                Set<String> curCutSet = cutSet.get(i);

                // 个数少地割集在外层，判断其元素是否都被包含在内层割集中
                if (cur.size() <= curCutSet.size()) {
                    for (String str : cur) {
                        if (!curCutSet.contains(str)) {
                            // cur 不是 curCutSet的子集
                            // cur 继续与下一个割集做判断
                            flag = false;
                            break;
                        }
                    }
                    if (flag) {  // 说明 cur是curCutSet的子集
                        // 删除curCutSet, 然后cur再继续和其他的割集做判断
                        cutSet.remove(i);
                    }
                } else {
                    for (String str : curCutSet) {
                        if (!cur.contains(str)) {
                            // curCutSet 不是 cur的子集
                            flag = false;
                            break;
                        }
                    }
                    if (flag) {   // 说明 curCutSet是cur的子集
                        // 那么cur就不用再继续往后判断了, 并且也不要再加入到最小割集里边
                        cont = false;
                        break;
                    }
                }
            }
            if (cont) { // 说明 cur可能是最小割集，先加进去
                cutSet.add(cur);
            }
        }
    }

    public void recurse(Node node, Set<String> nodeNames, Set<String> result) {
        if (node == null) return;
        if ("0".equals(node.name)) return;
        if ("1".equals(node.name)) {
            if (node.flag) { // 带有时序关系
                dealSequence(node, nodeNames, result);
            } else {         // 没有时序关系, 相当于割集
                result.add(setToString(nodeNames));
            }
        } else {
            nodeNames.add("-" + node.name);
            recurse(node.left, nodeNames, result);
            nodeNames.remove("-" + node.name);

            nodeNames.add(node.name);
            recurse(node.right, nodeNames, result);
            nodeNames.remove(node.name);
        }
    }

    public String setToString(Set<String> nodes) {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (String node : nodes
        ) {
            sb.append(node);
            sb.append(",");
        }
        return sb.substring(0, sb.length() - 1) + "}";
    }


    // A<B*A<C + D<E*F<G + M<N
    public void dealSequence(Node node, Set<String> nodes, Set<String> result) {
        String[] sequences = node.order.split("\\+");
        for (int i = 0; i < sequences.length; i++) {   // 第i个正向, 这里每次循环都表示一种时序关系, 需要和事件进行结合
            List<StringBuilder> last = new ArrayList<>();
            for (int j = 0; j < i; j++) {              // 前边的反向, 涉及到与取反变为或, 如果带有*, 取反时需要再次使用SDP
                List<StringBuilder> temp = new ArrayList<>();
                if (sequences[j].contains("*")) {      // 如果当前取反项中包含有"*"号，需要额外处理
                    String[] more = sequences[j].split("\\*");

                    for (int k = 0; k < more.length; k++) {
                        StringBuilder sb1 = new StringBuilder();
                        StringBuilder sb2 = new StringBuilder();
                        for (int l = 0; l < k; l++) {  // 前边不用取反
                            if (sb1.length() > 0) {
                                sb1.append("*");
                            }
                            sb1.append(more[l]);
                        }
                        // 当前的需要取反
                        String[] events = more[k].split("<");
                        sb2.append(events[1]);
                        sb2.append("<");
                        sb2.append(events[0]);
                        if (sb1.length() > 0) {
                            sb1.append("*");
                        }
                        sb1.append(sb2);
                        temp.add(sb1);
                    }
                } else {   // 不包含"*", 说明只有单独的一项
                    StringBuilder sb = new StringBuilder();
                    String[] split = sequences[j].split("<");
                    sb.append(split[1]);
                    sb.append("<");
                    sb.append(split[0]);
                    temp.add(sb);
                }

                if (last.size() == 0) {
                    last = temp;
                } else {  // last中的要和temp中的相乘
                    List<StringBuilder> res = new ArrayList<>();
                    for (StringBuilder sb1 : last) {
                        for (StringBuilder sb2 : temp) {
                            StringBuilder sb = new StringBuilder(sb1).append("*").append(sb2);
                            res.add(sb);
                        }
                    }
                    last = res;
                }
            }
            if (last.size() > 0) {
                for (StringBuilder sb : last
                ) {
                    sb.append("*");
                    sb.append(sequences[i]);
                }
            } else {
                last.add(new StringBuilder(sequences[i]));
            }

            // TODO: 再往后处理last
//            System.out.println(Arrays.toString(last.toArray()));
            getCSeq(nodes, last, result);
        }
    }

    public void getCSeq(Set<String> nodes, List<StringBuilder> sequences, Set<String> result) {
        Set<String> happens = new HashSet<>();
        Set<String> notHappens = new HashSet<>();
        boolean flag;
        for (String node : nodes) {
            if (node.startsWith("-")) {
                notHappens.add(node);
            } else {
                happens.add(node);
            }
        }

        for (StringBuilder sb : sequences) {
            String sequence = sb.toString();
            String[] split = sequence.split("\\*");
            // 存储前驱
            Map<String, Set<String>> precursor = new HashMap<>();
            // 存储后继
            Map<String, Set<String>> successor = new HashMap<>();
            for (String seq : split) {
                String[] pair = seq.split("<");

                Set<String> set1 = successor.getOrDefault(pair[0], new HashSet<>());
                set1.add(pair[1]);
                successor.put(pair[0], set1);

                Set<String> set2 = precursor.getOrDefault(pair[1], new HashSet<>());
                set2.add(pair[0]);
                precursor.put(pair[1], set2);
            }

            // 先判断是否存在非事件包含后继
            flag = false;
            for (String notHappen : notHappens) {
                if (successor.containsKey(notHappen.substring(1))) {
                    flag = true;
                    break;
                }
            }
            if (!flag) { // 没有冲突
                Set<String> contain = new HashSet<>();
                List<String> temp = new ArrayList<>();
                backtrace(happens, precursor, contain, result, temp);
            }
        }
    }

    public void backtrace
            (Set<String> happens, Map<String, Set<String>> precursor, Set<String> contain, Set<String> result, List<String> temp) {
        if (contain.size() == happens.size()) {
            StringBuilder sb = new StringBuilder();
            sb.append(String.join("<", temp));
            result.add(sb.toString());
            return;
        }
        for (String str : happens) {
            if (!contain.contains(str) && isExist(precursor, str, temp)) {
                // 还要判断 str所有的前驱是否已经存在了
                temp.add(str);
                contain.add(str);
                backtrace(happens, precursor, contain, result, temp);
                temp.remove(temp.size() - 1);
                contain.remove(str);
            }
        }
    }

    public boolean isExist(Map<String, Set<String>> precursor, String cur, List<String> temp) {
        // 判断当前temp是否包含cur的所有前驱
        Set<String> set = precursor.getOrDefault(cur, new HashSet<>());
        for (String s : set) {
            if (!temp.contains(s)) {
                return false;
            }
        }
        return true;
    }
}

class Node {
    boolean flag;
    String name;
    // 时序描述 "a<b"等
    String order;
    // type=0/1 时, 无需孩子节点
    Node left = null;
    Node right = null;

    /**
     * 构造函数
     *
     * @param flag 0, 1节点后是否包含时许关系
     * @param name 节点的名称
     */
    public Node(String name, boolean flag, String order) {
        this.flag = flag;
        this.name = name;
        this.order = order;
    }

    public Node(String name, boolean flag, String order, Node left, Node right) {
        this.flag = flag;
        this.name = name;
        this.order = order;
        this.left = left;
        this.right = right;
    }
}

class TrieNode //字典树节点
{
    public Map<String, TrieNode> son;
    public boolean isEnd;//是不是最后一个节点
    public boolean haveSon;
    public String val;//节点的值

    TrieNode() {
        son = new HashMap<>();
        isEnd = false;
        haveSon = false;
    }
}

class Trie {
    public TrieNode root;

    Trie() {
        root = new TrieNode();
    }

    /**
     * 在字典树中插入一条序列
     *
     * @param sequences
     */
    public void insert(String[] sequences) {
        if (sequences == null || sequences.length == 0) {
            return;
        }
        TrieNode node = root;
        for (String val : sequences) {
            // 如果该节点是终结节点，就没必要再往下插入了
            if (node.isEnd) {
                break;
            }
            // 如果当前节点没有该儿子，就创建对应节点
            if (!node.son.containsKey(val)) {
                TrieNode curSon = new TrieNode();
                curSon.val = val;
                node.son.put(val, curSon);
                node.haveSon = true;
            }
            node = node.son.get(val);
        }
        node.isEnd = true;
    }

    /**
     * 获取最小割序，即遍历前缀树，当节点为End时就不再往下遍历
     */
    public void getMinCutSeq(TrieNode node, List<String> temp, Set<String> result) {
        if (node == null) return;

        if (node.isEnd) {
            result.add(String.join("<", temp));
        } else {
            // 遍历当前节点的所有孩子
            for (TrieNode son : node.son.values()) {
                temp.add(son.val);
                getMinCutSeq(son, temp, result);
                temp.remove(temp.size() - 1);
            }
        }
    }
}

