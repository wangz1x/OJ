package com.wzx.algorithm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wangzx
 * @email wangzx22@163.com
 * @date 2021/5/26 上午10:54
 */
public class BDDConstruction {
    // 各种缓存, 区别还要进一步分析
    private static Map<String, String> ite = new HashMap<>(); // BDD ite
    private static Map<String, String> compute = new HashMap<>(); // BDD ite
    private static Map<String, String> con = new HashMap<>(); // BDD ite
    private static Map<String, String> minCutSet = new HashMap<>(); // BDD ite
    private static Map<String, String> withoutOf = new HashMap<>(); // BDD ite
    private static Map<String, Double> probability = new HashMap<>(); // BDD ite
    private static Map<String, String> app = new HashMap<>(); // apply
    private static String R = "2";// BDD  2, 0, 1

    public BDDConstruction() {
    }

    public static void main(String[] args) {
        String g02 = "c02|c03";
        String gRoot = "c01&g02";
        // gateNames
        String[] gateNames = {"g02", "gRoot"};
        // event represented by the gate
        String[] gates = {g02, gRoot};
        // basic event index, used by construction
        String indexOf = "c01c02c03";
        double[] basicEventProbabilities = {0.01, 0.051, 0.051, 0.051, 0.051, 0.112, 0.112, 0.112, 0.112, 0.016, 0.016, 0.016, 0.016,
                0.0218, 0.0218, 0.0218, 0.0218, 0.015, 0.015, 0.015, 0.015, 0.016, 0.016, 0.016, 0.016, 0.015, 0.015,
                0.015, 0.015, 0.0137, 0.0137, 0.0137, 0.0137, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016,
                0.0038, 0.0038, 0.0117, 0.0117, 0.00052, 0.00052, 0.018, 0.018, 0.018, 0.018, 0.000008, 0.000072, 0.015,
                0.015, 0.015, 0.015, 0.0188, 0.0188, 0.0188, 0.0188};
        String[] basicEventNames = {"c01", "c02", "c03"};

        // current system time
//        long a = System.currentTimeMillis();
        // construction BDD
        String bdd = construct("gRoot", indexOf, gates, gateNames);
        // System.out.println("bdd"+bdd);
        //
        String efg = mincuts(bdd, indexOf);// BDD
        //
        String hij = result(efg, "");// mincuts
        //
        String[] hhh = hij.split(",");//

        for (String s : hhh) {
            System.out.println(s);
        }
//         System.out.println("\r calculation time : " + (System.currentTimeMillis() - a) / 1000f + " ?? ");
//         double reliabilityOfSystem = probability(bdd, basicEventProbabilities, basicEventNames);// probc
//         System.out.println("reliabilityOfSystem:" + reliabilityOfSystem);
    }

    /**
     * 递归构建BDD的过程
     *
     * @param root
     * @param indexOf
     * @param gates
     * @param gateNames
     * @return
     */
    static String construct(String root, String indexOf, String[] gates, String[] gateNames) {
        // R = "2", 不太懂是什么意思
        String Rb = R;
        // 保存已经构建过的节点? 重用? 是否一定可以重用呢?
        if (con.containsKey(root)) {
            return con.get(root);
        }

        String sign = "&";
        String[] consists;
        String right = "";
        String left = "";
        // 为叶子节点
        if (root.equals("1") || root.equals("0")) {
            return root;
        } else if (!root.contains("&") && !root.contains("|")) {
            // 基本事件
            if (root.indexOf("c") == 0) {
                return root;
            }
            // 门节点
            if (root.indexOf("g") == 0) {
                // 获取gate的表达式
                String representationOfGate = gates[Arrays.binarySearch(gateNames, root)];
                // 或优先级高?
                if (representationOfGate.contains("|")) {
                    sign = "\\|";
                }
                // 按照sign分开
                consists = representationOfGate.split(sign);
                // 构建第一个或门左边的子树
                left = construct(consists[0], indexOf, gates, gateNames);
                // 构建第一个或门右边的子树
                // 要注意表达式中可能存在多个"|", 因此要把左边的替换为空
                right = construct(representationOfGate.replaceFirst(consists[0] + sign, ""), indexOf, gates, gateNames);
                // 合并左右两个子树
                Rb = apply(sign, left, right, indexOf);
            }
        } else {             // 门的表达式中包含或
            if (root.contains("|")) {
                sign = "\\|";
            }
            consists = root.split(sign);
            left = construct(consists[0], indexOf, gates, gateNames);
            right = construct(root.replaceFirst(consists[0] + sign, ""), indexOf, gates, gateNames);
            Rb = apply(sign, left, right, indexOf);
        }
        // 这里也是缓存? 感觉好多缓存
        con.put(root, Rb);
        // construction 最终的返回结果是经过apply处理过得
        return Rb;
    }

    /**
     * 按照给定的符号合并左右子树的过程
     *
     * @param sign
     * @param left
     * @param right
     * @param indexOf
     * @return
     */
    static String apply(String sign, String left, String right, String indexOf) {
        String Ra = R;

        if (app.get(sign + "-" + left + "-" + right) != null) {         // 先找缓存
            return app.get(sign + "-" + left + "-" + right);
        } else if (sign.equals("&")) {                                  // 如果左右子树通过与门连接
            if (left.equals("0") || right.equals("0")) {                // 左右子树中有一个为0, 与的结果直接为0
                app.put(sign + "-" + left + "-" + right, "0");
                return "0";
            }
            // 从下边开始就不包含0了
            else if (left.equals("1") && (!right.equals("1"))) {        //
                if (!right.contains("c")) {                             // right既不等于0/1, 也不包含c, 那right能是啥玩意
                    app.put(sign + "-" + left + "-" + right, right);
                    return right;
                }
                Ra = Mk(right, low(right), high(right));                // 没搞懂什么意思
                app.put(sign + "-" + left + "-" + right, Ra);
                return Ra;
            } else if (right.equals("1") && (!left.equals("1"))) {
                if (!left.contains("c")) {
                    app.put(sign + "-" + left + "-" + right, left);
                    return left;
                }
                Ra = Mk(left, low(left), high(left));
                app.put(sign + "-" + left + "-" + right, Ra);
                return Ra;
            } else if (right.equals("1")) {                              // 两个1?
                return "1";
            }
        } //  0&x=0 x&0=0 0|x=x x|0=x 1&x=x x&1=x 1|x=1 x|1=1
        else if (sign.equals("|")) {
            if (left.equals("1") || right.equals("1")) {
                app.put(sign + "-" + left + "-" + right, "1");// "1"
                return "1";
            }
            if (left.equals("0") && (!right.equals("0"))) {
                if (!right.contains("c")) {
                    app.put(sign + "-" + left + "-" + right, right);
                    return right;
                }
                Ra = Mk(right, low(right), high(right));

                app.put(sign + "-" + left + "-" + right, Ra);
                return Ra;
            }
            if (right.equals("0") && (!left.equals("0"))) {
                if (!left.contains("c")) {
                    app.put(sign + "-" + left + "-" + right, left);
                    return left;
                }
                Ra = Mk(left, low(left), high(left));

                app.put(sign + "-" + left + "-" + right, Ra);
                return Ra;
            }
            if (right.equals("0")) {
                return "0";
            }
        }
        // CASE1: 左右两边都是基本事件?
        if (left.contains("c") && (right.contains("c"))) {
            if (indexOf.indexOf(left) == indexOf.indexOf(right)) {
                Ra = Mk(left, apply(sign, low(left), low(right), indexOf),
                        apply(sign, high(left), high(right), indexOf));
            } else if (indexOf.indexOf(left) < indexOf.indexOf(right)) {
                Ra = Mk(left, apply(sign, low(left), right, indexOf), apply(sign, high(left), right, indexOf));
            } else if (indexOf.indexOf(left) > indexOf.indexOf(right)) {
                Ra = Mk(right, apply(sign, left, low(right), indexOf), apply(sign, left, high(right), indexOf));
            }
            app.put(sign + "-" + left + "-" + right, Ra);
            return Ra;
        }
        // CASE2: 左右两边都不是基本事件?
        if ((!left.contains("c")) && (!right.contains("c"))) {

            String left1 = ite.get(left);
            String[] index = left1.split("-");
            String low = index[1];
            String high = index[2];
            String right1 = String.valueOf(ite.get(right));
            String[] index1 = right1.split("-");
            String low1 = index1[1];
            String high1 = index1[2];
            // 3
            if (indexOf.indexOf(index[0]) == indexOf.indexOf(index1[0])) {
                Ra = Mk(index[0], apply(sign, low, low1, indexOf), apply(sign, high, high1, indexOf));
            } else if (indexOf.indexOf(index[0]) < indexOf.indexOf(index1[0])) {
                Ra = Mk(index[0], apply(sign, low, right, indexOf), apply(sign, high, right, indexOf));
            } else if (indexOf.indexOf(index[0]) > indexOf.indexOf(index1[0])) {
                Ra = Mk(index1[0], apply(sign, left, low1, indexOf), apply(sign, left, high1, indexOf));
            }
            app.put(sign + "-" + left + "-" + right, Ra);

            return Ra;
        }
        // CASE3: 右边是基本事件
        if (!left.contains("c")) {
            String left1 = String.valueOf(ite.get(left));
            String[] index = left1.split("-");
            String low = index[1];
            String high = index[2];
            // 3
            if (indexOf.indexOf(index[0]) == indexOf.indexOf(right)) {
                Ra = Mk(index[0], apply(sign, low, low(right), indexOf), apply(sign, high, high(right), indexOf));
            } else if (indexOf.indexOf(index[0]) < indexOf.indexOf(right)) {
                Ra = Mk(index[0], apply(sign, low, right, indexOf), apply(sign, high, right, indexOf));
            } else if (indexOf.indexOf(index[0]) > indexOf.indexOf(right)) {
                Ra = Mk(right, apply(sign, left, low(right), indexOf), apply(sign, left, high(right), indexOf));
            }
            app.put(sign + "-" + left + "-" + right, Ra);
            return Ra;
        }

        // CASE4: 左边是基本事件
        if (!right.contains("c")) {
            String right1 = String.valueOf(ite.get(right));
            String[] index1 = right1.split("-");
            String low1 = index1[1];
            String high1 = index1[2];
            // 3
            if (indexOf.indexOf(left) == indexOf.indexOf(index1[0])) {
                Ra = Mk(left, apply(sign, low(left), low1, indexOf), apply(sign, high(left), high1, indexOf));
            } else if (indexOf.indexOf(left) < indexOf.indexOf(index1[0])) {
                Ra = Mk(left, apply(sign, low(left), right, indexOf), apply(sign, high(left), right, indexOf));
            } else if (indexOf.indexOf(left) > indexOf.indexOf(index1[0])) {
                Ra = Mk(index1[0], apply(sign, left, low1, indexOf), apply(sign, left, high1, indexOf));
            }
        }
        app.put(sign + "-" + left + "-" + right, Ra);
        return Ra;
    }

    static String Mk(String i, String l, String h) {// HASH , BDD, c001-0-1
        String R1 = R;
        if (l.equals(h)) {
            return l;
        } else if (h.equals("0")) {
            return l;
        } else if (compute.containsKey(i + "-" + l + "-" + h)) {
            return compute.get(i + "-" + l + "-" + h);
        } else {
            ite.put(R, i + "-" + l + "-" + h);
            compute.put(i + "-" + l + "-" + h, R);
            R = String.valueOf(Integer.parseInt(R) + 1);
            return R1;
        }
    }

    // 基本事件的低位(左边)为0
    static String low(String u) {
        if (u.equals("1")) {
            return "1";
        } else {
            return "0";
        }
    }

    // 基本事件的高位(右边)为1
    static String high(String u) {
        if (u.equals("0")) {
            return "0";
        } else {
            return "1";
        }

    }

    static String mincuts(String bdd, String indexof) {//  BDD
        String Rc = "";
        if (bdd.equals("0") || bdd.equals("1")) {
            return bdd;
        } else if (minCutSet.get("mincuts-" + bdd) != null) {
            return String.valueOf(minCutSet.get("mincuts-" + bdd));
        } else {
            String bdd1 = String.valueOf(ite.get(bdd));//  ite
            String[] index = bdd1.split("-");
            String low = index[1];
            String high = index[2];
            String high1 = mincuts(high, indexof);
            String Without = without(high1, low, indexof);//  T
            String low1 = mincuts(low, indexof);
            Rc = Mk(index[0], low1, Without);
        }
        minCutSet.put("mincuts-" + bdd, Rc);
        return Rc;
    }

    static String without(String high1, String low, String indexof) {//    Xy X  y
        if (high1.equals("0")) {
            return "0";
        } //
        else if (low.equals("1")) {
            return "0";
        } else if (low.equals("0")) {
            return high1;
        } else if (high1.equals("1")) {
            return "1";
        } else if (withoutOf.get("withoutof-" + high1 + "-" + low) != null) {
            return String.valueOf(withoutOf.get("withoutof-" + high1 + "-" + low));
        } else {//  ite
            String left1 = String.valueOf(ite.get(high1));
            String[] index = left1.split("-");
            String loww = index[1];
            String highh = index[2];
            String right1 = String.valueOf(ite.get(low));
            String[] index1 = right1.split("-");
            String low1 = index1[1];
            String high11 = index1[2];
            if (indexof.indexOf(index[0]) < indexof.indexOf(index1[0])) {//  CASE1
                String Without = without(highh, low, indexof);
                String low2 = without(loww, low, indexof);
                String Rc = Mk(index[0], low2, Without);
                withoutOf.put("withoutof-" + high1 + "-" + low, Rc);
                return Rc;
            } else if (indexof.indexOf(index[0]) > indexof.indexOf(index1[0])) {//  CASE2
                return without(high1, low1, indexof);
            } else {//  CASE3
                String Without = without(highh, high11, indexof);
                String low2 = without(loww, low1, indexof);
                String Rc = Mk(index[0], low2, Without);
                withoutOf.put("withoutof-" + high1 + "-" + low, Rc);
                return Rc;
            }
        }

    }

    static String result(String root, String index) {//
        if (root.equals("0")) {
            return "empty";
        } else if (root.equals("1")) {
            return index;
        } else {
            String F = String.valueOf(ite.get(root));
            String[] rootvalue = F.split("-");
            String X = rootvalue[0];
            String highbench = result(rootvalue[2], index + X);
            String lowbench = result(rootvalue[1], index);
            if (lowbench.equals("empty")) {
                return highbench;
            } else if (highbench.equals("empty")) {
                return lowbench;
            } else {
                return highbench + "," + lowbench;//  ,
            }

        }
    }

    static double probability(String root, double[] probc, String[] probname) {//
        if (root.equals("0")) {
            return 0.0;
        } else if (root.equals("1")) {
            return 1.0;
        } else if (probability.get("probability-" + root) != null) {
            return Double.parseDouble(probability.get("probability-" + root).toString());
        } else {
            String root1 = String.valueOf(ite.get(root));//  ite
            String[] index = root1.split("-");
            String low = index[1];
            String high = index[2];
            double pro = p(index[0], probc, probname) * probability(high, probc, probname)
                    + (1 - p(index[0], probc, probname)) * probability(low, probc, probname);//
            probability.put("probability-" + root, pro);
            return pro;
        }
    }

    static double p(String c, double[] probc, String[] probname) {//
        return probc[Arrays.binarySearch(probname, c)];
    }
}

