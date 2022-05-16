package com.wzx.algorithm;

import java.util.Set;

public class Solution {

    public void test() {
        Node B = new Node("B", false, "",
                new Node("A", false, "",
                        new Node("1", false, ""),
                        new Node("C", false, "",
                                new Node("D", false, "",
                                        new Node("1", true, "B<D+B<C"),
                                        new Node("1", true, "B<C")),
                                new Node("D", false, "",
                                        new Node("1", true, "B<D"),
                                        new Node("0", false, "")))),
                new Node("0", false, ""));


    }

    public void recurse(Node node, Set<Node> nodes, Set<String> result) {
        if (node == null) return;
        if ("0".equals(node.name)) return;
        if ("1".equals(node.name)) {
            if (node.flag) { // 带有时序关系

            } else {         // 没有时序关系, 相当于割集
                result.add(setToString(nodes));
            }
        } else {
            nodes.add(node);
            recurse(node.left, nodes, result);
            nodes.remove(node);

            node.name = "-" + node.name;
            nodes.add(node);
            recurse(node.left, nodes, result);
            nodes.remove(node);
        }
    }

    public String setToString(Set<Node> nodes) {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (Node node : nodes
        ) {
            sb.append(node.name);
            sb.append(", ");
        }
        return sb.substring(0, sb.length() - 1)+"}";
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
