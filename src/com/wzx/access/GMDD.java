package com.wzx.access;

/**
 * @(#)IFCConstruction.java 构造基于不完全覆盖无关组件三元决策图，含非
 * 求Ficm 近似值  参考《An Imperfect Fault Coverage Model With Coverage of Irrelevant COmponents》Jianwen Xiang,Fumio etc
 * @周四维
 * @version 4.00 2016/6/8此版本 主要计算无关性概率 不计算最小割集或最小蕴含式
 */

import java.util.Arrays;
import java.util.Hashtable;
import java.util.Map;

public class GMDD {
    //注意我这里是static静态的 如果不需要可以去掉
    private static Map CASE = new Hashtable();    //TDD存放表CASE结构
    private static Map compute = new Hashtable();  //TDD存放表 反case结构
    private static Map app = new Hashtable();  //apply函数动态编程记录表
    private static Map con = new Hashtable();//construction函数动态编程记录表
    private static Map Probability = new Hashtable();//probability函数动态编程表
    private static String R = "2";//BDD索引从2开始, 这里叶子结点仍然为0，1,合并了2与1，根据香浓分解

    public GMDD() {
    }

    public static void main(String[] args) {
        test();
    }

    static String construction(String root, String indexof, String[] gate, String[] gatename) {//两两拆分中缀表达式，先左后右 Nc001非事件 Ic001覆盖事件 Uc001未覆盖事件 NIc001非覆盖事件
        String Rb = R;
        if (con.get(root) != null) {//查找是否已求解
            return String.valueOf(con.get(root));
        }
        if (root.equals("1") || root.equals("0")) { //边界事件,叶子结点
            return root;
        } else if (root.contains("&") == false && root.contains("|") == false) {//单个基本事件或门
            if (root.indexOf("c") == 0 || root.indexOf("N") == 0 || root.indexOf("I") == 0 || root.indexOf("U") == 0) {
                return root;
            }
            if (root.indexOf("g") == 0) {
                String sign = "&";
                String[] consiste;
                String right = "";
                String left = "";
                String root1 = gate[Arrays.binarySearch(gatename, root)];////利用二分查找找出对应gate分支对应中缀表达式
                if (root1.contains("|")) {
                    sign = "|";
                    consiste = root1.split("\\|");
                    left = construction(consiste[0], indexof, gate, gatename);
                    right = construction(root1.replaceFirst(consiste[0] + "\\|", ""), indexof, gate, gatename);
                } else {
                    consiste = root1.split("&");
                    left = construction(consiste[0], indexof, gate, gatename);

                    right = construction(root1.replaceFirst(consiste[0] + "&", ""), indexof, gate, gatename);
                }
                //int len=consiste.length;
                Rb = apply(sign, left, right, indexof);//计算左右分支
            }
        } else if (root.contains("&") && root.contains("|")) {//处理voter门
            String[] consiste = root.split("\\|");
//	int len=consiste.length;
            String left = construction(consiste[0], indexof, gate, gatename);

            String right = construction(root.replaceFirst(consiste[0] + "\\|", ""), indexof, gate, gatename);
            Rb = apply("|", left, right, indexof);//计算左右分支
        } else {
            if (root.contains("&")) {//与门
                String[] consiste = root.split("&");
//	int len=consiste.length;
                String left = construction(consiste[0], indexof, gate, gatename);
                String right = construction(root.replaceFirst(consiste[0] + "&", ""), indexof, gate, gatename);
                Rb = apply("&", left, right, indexof);//计算左右分支
            } else {
                String[] consiste = root.split("\\|");//或门
//	int len=consiste.length;
                String left = construction(consiste[0], indexof, gate, gatename);

                String right = construction(root.replaceFirst(consiste[0] + "\\|", ""), indexof, gate, gatename);
                Rb = apply("|", left, right, indexof);    //计算左右分支
            }
        }
        con.put(root, Rb);//记录解
        return Rb;
    }

    static String apply(String sign, String left, String right, String indexof) {//计算3个TDD分支过程，即construct里的左右分支Nc001非事件 Ic001覆盖事件 Ucoo1未覆盖事件 c001完整事件 NI覆盖的非事件

        String Ra = R;
        if (app.get(sign + "-" + left + "-" + right) != null) {

            return String.valueOf(app.get(sign + "-" + left + "-" + right));
        } else if (sign.equals("&")) {//优化与关系
            if (right.equals("1") && left.equals("1")) {//1*1
                return "1";
            }
            if (right.equals("0") || left.equals("0")) {//0*0
                return "0";
            }

            if (right.equals("1") && left.equals("0")) {//0*1
                return "0";
            }

            if (left.equals("1") && right.equals("0")) {//1*0
                return "0";
            }

            if (left.equals("1") && (right.equals("1")) == false) {//1*
                if (right.contains("c") == false) {
                    app.put(sign + "-" + left + "-" + right, right);
                    return right;
                }
                Ra = Mk(right, low(right), mid(right), high(right));
                app.put(sign + "-" + left + "-" + right, Ra);
                return Ra;
            }
            if (right.equals("1") && (left.equals("1") == false)) {//*1
                if (left.contains("c") == false) {
                    app.put(sign + "-" + left + "-" + right, left);
                    return left;
                }
                Ra = Mk(left, low(left), mid(left), high(left));
                app.put(sign + "-" + left + "-" + right, Ra);
                return Ra;

            }
        }//以下优化 或关系
        else if (sign.equals("|")) {
            if (right.equals("0") && left.equals("0")) {//0+0
                return "0";
            }

            if (left.equals("0") && right.equals("1")) {//0+1
                return "1";
            }
            if (right.equals("0") && left.equals("1")) {//1+0
                return "1";
            }
            if (right.equals("1") || left.equals("1")) {//1+1
                return "1";
            }
            if (left.equals("0") && (right.equals("0") == false)) {//0+
                if (right.contains("c") == false) {
                    app.put(sign + "-" + left + "-" + right, right);
                    return right;
                }
                Ra = Mk(right, low(right), mid(right), high(right));

                app.put(sign + "-" + left + "-" + right, Ra);
                return Ra;
            }
            if (right.equals("0") && (left.equals("0") == false)) {//+0
                if (left.contains("c") == false) {
                    app.put(sign + "-" + left + "-" + right, left);
                    return left;
                }
                Ra = Mk(left, low(left), mid(left), high(left));

                app.put(sign + "-" + left + "-" + right, Ra);
                return Ra;
            }
        }

        if (left.contains("c") && (right.contains("c"))) {//CASE1:纯基本事件
            //以下香浓分解3种情况
            if (indexof.indexOf(PN(left)) == indexof.indexOf(PN(right))) {
                //	System.out.println(PN(left));
                Ra = Mk(PN(left), apply(sign, low(left), low(right), indexof), apply(sign, mid(left), mid(right), indexof), apply(sign, high(left), high(right), indexof));
            } else if (indexof.indexOf(PN(left)) < indexof.indexOf(PN(right))) {
                Ra = Mk(PN(left), apply(sign, low(left), right, indexof), apply(sign, mid(left), right, indexof), apply(sign, high(left), right, indexof));
            } else if (indexof.indexOf(PN(left)) > indexof.indexOf(PN(right))) {
                Ra = Mk(PN(right), apply(sign, left, low(right), indexof), apply(sign, left, mid(right), indexof), apply(sign, left, high(right), indexof));
            }
            app.put(sign + "-" + left + "-" + right, Ra);
            return Ra;
        }

        if ((left.contains("c") == false) && (right.contains("c") == false)) {//CASE2:纯门之间

            String left1 = String.valueOf(CASE.get(left));
            String[] index = left1.split("-");
            String low = index[1];
            String mid = index[2];
            String high = index[3];
            String right1 = String.valueOf(CASE.get(right));
            String[] index1 = right1.split("-");
            String low1 = index1[1];
            String mid1 = index1[2];
            String high1 = index1[3];
            //以下香浓分解3种情况
            if (indexof.indexOf(index[0]) == indexof.indexOf(index1[0])) {
                Ra = Mk(index[0], apply(sign, low, low1, indexof), apply(sign, mid, mid1, indexof), apply(sign, high, high1, indexof));
            } else if (indexof.indexOf(index[0]) < indexof.indexOf(index1[0])) {
                Ra = Mk(index[0], apply(sign, low, right, indexof), apply(sign, mid, right, indexof), apply(sign, high, right, indexof));
            } else if (indexof.indexOf(index[0]) > indexof.indexOf(index1[0])) {
                Ra = Mk(index1[0], apply(sign, left, low1, indexof), apply(sign, left, mid1, indexof), apply(sign, left, high1, indexof));
            }
            app.put(sign + "-" + left + "-" + right, Ra);

            return Ra;
        }
        if (left.contains("c") == false) {//CASE3:左门右事件

            String left1 = String.valueOf(CASE.get(left));
            String[] index = left1.split("-");
            String low = index[1];
            String mid = index[2];
            String high = index[3];
            //以下香浓分解3种情况
            if (indexof.indexOf(index[0]) == indexof.indexOf(PN(right))) {
                Ra = Mk(index[0], apply(sign, low, low(right), indexof), apply(sign, mid, mid(right), indexof), apply(sign, high, high(right), indexof));
            } else if (indexof.indexOf(index[0]) < indexof.indexOf(PN(right))) {
                Ra = Mk(index[0], apply(sign, low, right, indexof), apply(sign, mid, right, indexof), apply(sign, high, right, indexof));
            } else if (indexof.indexOf(index[0]) > indexof.indexOf(PN(right))) {
                Ra = Mk(PN(right), apply(sign, left, low(right), indexof), apply(sign, left, mid(right), indexof), apply(sign, left, high(right), indexof));
            }
            app.put(sign + "-" + left + "-" + right, Ra);
            return Ra;
        }

        if (right.contains("c") == false) {  //CASE4:右门左事件

            String right1 = String.valueOf(CASE.get(right));
            String[] index1 = right1.split("-");
            String low1 = index1[1];
            String mid1 = index1[2];
            String high1 = index1[3];
            //以下香浓分解3种情况
            if (indexof.indexOf(PN(left)) == indexof.indexOf(index1[0])) {
                Ra = Mk(PN(left), apply(sign, low(left), low1, indexof), apply(sign, high(left), mid1, indexof), apply(sign, high(left), high1, indexof));
            } else if (indexof.indexOf(PN(left)) < indexof.indexOf(index1[0])) {
                Ra = Mk(PN(left), apply(sign, low(left), right, indexof), apply(sign, mid(left), right, indexof), apply(sign, high(left), right, indexof));
            } else if (indexof.indexOf(PN(left)) > indexof.indexOf(index1[0])) {
                Ra = Mk(index1[0], apply(sign, left, low1, indexof), apply(sign, left, mid1, indexof), apply(sign, left, high1, indexof));
            }
        }
        app.put(sign + "-" + left + "-" + right, Ra);

        return Ra;
    }

    static String PN(String u)//事件去除前缀
    {
        return u.substring(u.indexOf("c"));
    }

    static String Mk(String i, String l, String m, String h) {//双向记录HASH表,构造TDD,例如c001-0-1-1 先底后高

        String R1 = R;
        i = i.replace("N", "");
        i = i.replace("I", "");
        i = i.replace("U", "");
        if (compute.get(i + "-" + l + "-" + m + "-" + h) != null) {
            return String.valueOf(compute.get(i + "-" + l + "-" + m + "-" + h));
        } else {
            CASE.put(R, i + "-" + l + "-" + m + "-" + h);
            compute.put(i + "-" + l + "-" + m + "-" + h, R);
//            System.out.println(i + "-" + l + "-" + m + "-" + h + "," + R);
            R = String.valueOf(Integer.parseInt(R) + 1);
            return R1;
        }
    }

    static String low(String u) {//非事件
        if (u.contains("N")) {
            return "1";
        } else if (u.equals("1")) {
            return "1";
        } else {
            return "0";
        }
    }

    static String mid(String u) {//covered事件
        if (u.contains("I") && u.contains("N") == false) {
            return "1";
        }
        if (u.contains("NU")) {
            return "1";
        }
        if (u.contains("N") == false && u.contains("I") == false && u.contains("U") == false) {//故障事件
            return "1";
        }
        if (u.equals("1")) {
            return "1";
        } else {
            return "0";
        }
    }

    static String high(String u) {//signle-fault(uncovered failure)
        if (u.contains("U") && u.contains("N") == false) {
            return "1";
        }
        if (u.contains("NI")) {
            return "1";
        }
        if (u.contains("N") == false && u.contains("I") == false && u.contains("U") == false) {//故障事件
            return "1";
        }

        if (u.equals("1")) {
            return "1";
        } else {
            return "0";
        }

    }

    static double probability(String root, double[] failureProbability, double[] coverage, String[] probname) {//定量分析算概率
        if (root.equals("0")) {
            return 0.0;
        } else if (root.equals("1")) {
            return 1.0;
        } else if (Probability.get("probability-" + root) != null) {
            return Double.parseDouble(Probability.get("probability-" + root).toString());
        } else {
            String root1 = String.valueOf(CASE.get(root));//拆CASE
            String[] index = root1.split("-");
            String low = index[1];
            String mid = index[2];
            String high = index[3];
//            double pro = (1 - p(index[0], probc, probname)) * probability(low, probc, probname) + 0.947965 * p(index[0], probc, probname) * probability(mid, probc, probname) + 0.052035 * p(index[0], probc, probname) * probability(high, probc, probname);//概率计算公式 cover因子0.99
            double pro = (1 - p(index[0], failureProbability, probname)) * probability(low, failureProbability, coverage, probname) + coverage(index[0], coverage, probname) * p(index[0], failureProbability, probname) * probability(mid, failureProbability, coverage, probname) + (1 - coverage(index[0], coverage, probname)) * p(index[0], failureProbability, probname) * probability(high, failureProbability, coverage, probname);//概率计算公式 cover因子0.99
            Probability.put("probability-" + root, pro);
            return pro;
        }
    }

    static double p(String c, double[] probc, String[] probname) {//查找基本事件对应的概率
        return probc[Arrays.binarySearch(probname, c)];
    }

    static double coverage(String c, double[] coverage, String[] coverageName) {
        return coverage[Arrays.binarySearch(coverageName, c)];
    }

    static void test() {


        String g001 = "Ic01|Ic02|Ic03";        // x1
        String g002 = "g001&Ic04";

        String g003 = "Uc01|Uc02|Uc03|Uc04";        // not-covered x4
        String goot = "g002|g003";

        String[] gatename = {"g001", "g002", "g003", "goot"};
        String[] gate = {g001, g002, g003, goot};
        String indexof = "c01c02c03c04";//故障树深度优先顺序
        double[] probc = {0.100386, 0.191219, 0.191219, 0.191219};//每个基本事件的原始概率
        double[] coverage = {1.000000, 0.947965, 0.947965, 1.000000};
        String[] probname = {"c01", "c02", "c03", "c04"};//基本事件，请按顺序存放否二分查找返回错误
        String IPCTDD = construction("goot", indexof, gate, gatename);//计算根TDD索引
        double proba = probability(IPCTDD, probc, coverage, probname);//概率（将probc输入完整）
        System.out.println("Ficm近似值=" + proba);//输出Ficm近似概率
    }

}