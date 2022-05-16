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
    private static double COVERAGE_FACTOR = 0.950200;

    public GMDD() {
    }

    public static void main(String[] args) {
<<<<<<< HEAD
        test();
=======
<<<<<<< HEAD
//        withoutSub();     // 0.031 0.042 0.042 0.046 0.031 0.028 0.031 0.039 0.037
//        withSub();          // 0.031 0.025 0.022 0.031 0.025
        case1();
=======


//        withoutSub();       //   2 2 2 4 4 : 0.01921  5 5 5 5 5 : 0.03175
        withSub();            //   2 2 2 4 4 : 0.01293  5 5 5 5 5 : 0.01592
>>>>>>> a169a11b15efef0809d6342f961334c68044b321
>>>>>>> f3ac6b4c98c211675acad8c5de2503f9a7ee5819
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
<<<<<<< HEAD
//            double pro = (1 - p(index[0], probc, probname)) * probability(low, probc, probname) + 0.947965 * p(index[0], probc, probname) * probability(mid, probc, probname) + 0.052035 * p(index[0], probc, probname) * probability(high, probc, probname);//概率计算公式 cover因子0.99
=======
//            double pro = (1 - p(index[0], failureProbability, probname)) * probability(low, failureProbability, coverage, probname) + COVERAGE_FACTOR * p(index[0], failureProbability, probname) * probability(mid, failureProbability, coverage, probname) + (1 - COVERAGE_FACTOR) * p(index[0], failureProbability, probname) * probability(high, failureProbability, coverage, probname);//概率计算公式 cover因子0.99
>>>>>>> f3ac6b4c98c211675acad8c5de2503f9a7ee5819
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


<<<<<<< HEAD
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
=======
    static double coverage(String c, double[] coverage, String[] coverageName) {
        return coverage[Arrays.binarySearch(coverageName, c)];
    }

    static double[] p1(String c, double[][] probc, String[] probname) {//查找基本事件对应的概率
        return probc[Arrays.binarySearch(probname, c)];
    }

<<<<<<< HEAD
//    static void withoutSub() {
//        long a = System.currentTimeMillis();//记录函数开始时间
//
//        String g001 = "Ic011&Ic012&Ic013";        // x1
//        String g002 = "Ic021&Ic022&Ic023";        // x2
//        String g003 = "Ic031&Ic032";              // x3
//        String g004 = "Ic041&Ic042&Ic043";        // x4
//        String g005 = "Ic051&Ic052&Ic053";        // x5
//
//        String g013 = "Uc011|Uc012|Uc013";        // not-covered x1
//        String g014 = "Uc021|Uc022|Uc023";        // not-covered x2
//        String g015 = "Uc031|Uc032";              // not-covered x3
//        String g016 = "Uc041|Uc042|Uc043";        // not-covered x4
//        String g017 = "Uc051|Uc052|Uc053";        // not-covered x5
//
//        String g006 = "g004&g005";                // x4·x5
//        String g007 = "g003|g006";                // x3+x4·x5
//        String g008 = "g001&g007";                // x1·(x3+x4·x5)
//
//        String g009 = "g003&g005";                // x3·x5
//        String g010 = "g004|g009";                // x4+x3·x5
//        String g011 = "g002&g010";                // x2·(x4+x3·x5)
//        String g012 = "g008|g011";                // x1·(x3+x4·x5)+x2·(x4+x3·x5)
//
//        String goot = "g012|g013|g014|g015|g016|g017";
//        String[] gatename = {"g001", "g002", "g003", "g004", "g005", "g006", "g007", "g008", "g009", "g010", "g011", "g012", "g013", "g014", "g015", "g016", "g017", "goot"};
//        String[] gate = {g001, g002, g003, g004, g005, g006, g007, g008, g009, g010, g011, g012, g013, g014, g015, g016, g017, goot};
//        String indexof = "c011c012c013c021c022c023c031c032c041c042c043c051c052c053";//故障树深度优先顺序
//        double[] probc = {0.26, 0.26, 0.26, 0.04, 0.04, 0.04, 0.15, 0.15, 0.11, 0.11, 0.11, 0.09, 0.09, 0.09};//每个基本事件的原始概率
//        String[] probname = {"c011", "c012", "c013", "c021", "c022", "c023", "c031", "c032", "c041", "c042", "c043", "c051", "c052", "c053",};//基本事件，请按顺序存放否二分查找返回错误
//        String IPCTDD = construction("goot", indexof, gate, gatename);//计算根TDD索引
////        System.out.println("IPCTDD: " + IPCTDD);
//        double proba = probability(IPCTDD, probc, probname);//概率（将probc输入完整）
//        System.out.println("Ficm近似值=" + proba);//输出Ficm近似概率
//        System.out.println("执行耗时 : " + (System.currentTimeMillis() - a) / 1000f + " 秒 ");//计算执行时间
//    }
=======
    static void withoutSub() {

        String g001 = "Ic011&Ic012&Ic013&Ic014&Ic015";        // x1
        String g002 = "Ic021&Ic022&Ic023&Ic024&Ic025";        // x2
        String g003 = "Ic031&Ic032&Ic033&Ic034&Ic035";        // x3
        String g004 = "Ic041&Ic042&Ic043&Ic044&Ic045";        // x4
        String g005 = "Ic051&Ic052&Ic053&Ic054&Ic055";        // x5

        String g013 = "Uc011|Uc012|Uc013|Uc014|Uc015";        // not-covered x1
        String g014 = "Uc021|Uc022|Uc023|Uc024|Uc025";        // not-covered x2
        String g015 = "Uc031|Uc032|Uc033|Uc034|Uc035";        // not-covered x3
        String g016 = "Uc041|Uc042|Uc043|Uc044|Uc045";        // not-covered x4
        String g017 = "Uc051|Uc052|Uc053|Uc054|Uc055";        // not-covered x5

        String g006 = "g004&g005";                // x4·x5
        String g007 = "g003|g006";                // x3+x4·x5
        String g008 = "g001&g007";                // x1·(x3+x4·x5)

        String g009 = "g003&g005";                // x3·x5
        String g010 = "g004|g009";                // x4+x3·x5
        String g011 = "g002&g010";                // x2·(x4+x3·x5)
        String g012 = "g008|g011";                // x1·(x3+x4·x5)+x2·(x4+x3·x5)

        long a = System.nanoTime();//记录函数开始时间

        String goot = "g012|g013|g014|g015|g016|g017";
        String[] gatename = {"g001", "g002", "g003", "g004", "g005", "g006", "g007", "g008", "g009", "g010", "g011", "g012", "g013", "g014", "g015", "g016", "g017", "goot"};
        String[] gate = {g001, g002, g003, g004, g005, g006, g007, g008, g009, g010, g011, g012, g013, g014, g015, g016, g017, goot};
        String indexof = "c011c012c013c014c015c021c022c023c024c025c031c032c033c034c035c041c042c043c044c045c051c052c053c054c055";//故障树深度优先顺序
        double[] probc = {0.26, 0.26, 0.26, 0.26, 0.26, 0.04, 0.04, 0.04, 0.04, 0.04, 0.15, 0.15, 0.15, 0.15, 0.15, 0.11, 0.11, 0.11, 0.11, 0.11, 0.09, 0.09, 0.09, 0.09, 0.09};//每个基本事件的原始概率
        String[] probname = {"c011", "c012", "c013", "c014", "c015", "c021", "c022", "c023", "c024", "c025", "c031", "c032", "c033", "c034", "c035", "c041", "c042", "c043", "c044", "c045", "c051", "c052", "c053", "c054", "c055",};//基本事件，请按顺序存放否二分查找返回错误
        String IPCTDD = construction("goot", indexof, gate, gatename);//计算根TDD索引
        double proba = probability(IPCTDD, probc, probname);//概率（将probc输入完整）
//        System.out.println("Ficm近似值=" + proba);//输出Ficm近似概率
        System.out.println("执行耗时 : " + (System.nanoTime() - a) / 1000000000f + " 秒 ");//计算执行时间
//        return (System.currentTimeMillis() - a) / 1000f;
    }
>>>>>>> a169a11b15efef0809d6342f961334c68044b321

    static void withSub() {

        String g001 = "Ic011&Ic012&Ic013&Ic014&Ic015";        // x1
        String g002 = "Ic021&Ic022&Ic023&Ic024&Ic025";        // x2
        String g003 = "Ic031&Ic032&Ic033&Ic034&Ic035";        // x3
        String g004 = "Ic041&Ic042&Ic043&Ic044&Ic045";        // x4
        String g005 = "Ic051&Ic052&Ic053&Ic054&Ic055";        // x5

        String g013 = "Uc011|Uc012|Uc013|Uc014|Uc015";        // not-covered x1
        String g014 = "Uc021|Uc022|Uc023|Uc024|Uc025";        // not-covered x2
        String g015 = "Uc031|Uc032|Uc033|Uc034|Uc035";        // not-covered x3
        String g016 = "Uc041|Uc042|Uc043|Uc044|Uc045";        // not-covered x4
        String g017 = "Uc051|Uc052|Uc053|Uc054|Uc055";        // not-covered x5

        // 每个子系统都已经合并了，相当于一个单独的组件，且三边的概率也都知道了

        double[][] substitutions = new double[5][3];


        String g006 = "c104&c105";                // x4·x5
        String g007 = "c103|g006";                // x3+x4·x5
        String g008 = "c101&g007";                // x1·(x3+x4·x5)

        String g009 = "c103&c105";                // x3·x5
        String g010 = "c104|g009";                // x4+x3·x5
        String g011 = "c102&g010";                // x2·(x4+x3·x5)


        long a = System.nanoTime();//记录函数开始时间
        String goot1 = "g001|g013";
        String[] gatename1 = {"g001", "g013", "goot1"};
        String[] gate1 = {g001, g013, goot1};
        String indexof1 = "c011c012c013c014c015";//故障树深度优先顺序
        double[] probc1 = {0.26, 0.26, 0.26, 0.26, 0.26};//每个基本事件的原始概率
        String[] probname1 = {"c011", "c012", "c013", "c014", "c015"};//基本事件，请按顺序存放否二分查找返回错误
        String IPCTDD1 = construction("goot1", indexof1, gate1, gatename1);//计算根TDD索引
        probability1(IPCTDD1, probc1, probname1, substitutions[0], 1.0, 0, 0);

        String goot2 = "g002|g014";
        String[] gatename2 = {"g002", "g014", "goot2"};
        String[] gate2 = {g002, g014, goot2};
        String indexof2 = "c021c022c023c024c025";//故障树深度优先顺序
        double[] probc2 = {0.04, 0.04, 0.04, 0.04, 0.04};//每个基本事件的原始概率
        String[] probname2 = {"c021", "c022", "c023", "c024", "c025"};//基本事件，请按顺序存放否二分查找返回错误
        String IPCTDD2 = construction("goot2", indexof2, gate2, gatename2);//计算根TDD索引
        probability1(IPCTDD2, probc2, probname2, substitutions[1], 1.0, 0, 0);


        String goot3 = "g003|g015";
        String[] gatename3 = {"g003", "g015", "goot3"};
        String[] gate3 = {g003, g015, goot3};
        String indexof3 = "c031c032c033c034c035";//故障树深度优先顺序
        double[] probc3 = {0.15, 0.15, 0.15, 0.15, 0.15};//每个基本事件的原始概率
        String[] probname3 = {"c031", "c032", "c033", "c034", "c035"};//基本事件，请按顺序存放否二分查找返回错误
        String IPCTDD3 = construction("goot3", indexof3, gate3, gatename3);//计算根TDD索引
        probability1(IPCTDD3, probc3, probname3, substitutions[2], 1.0, 0, 0);


        String goot4 = "g004|g016";
        String[] gatename4 = {"g004", "g016", "goot4"};
        String[] gate4 = {g004, g016, goot4};
        String indexof4 = "c041c042c043c044c045";//故障树深度优先顺序
        double[] probc4 = {0.11, 0.11, 0.11, 0.11, 0.11};//每个基本事件的原始概率
        String[] probname4 = {"c041", "c042", "c043", "c044", "c045"};//基本事件，请按顺序存放否二分查找返回错误
        String IPCTDD4 = construction("goot4", indexof4, gate4, gatename4);//计算根TDD索引
        probability1(IPCTDD4, probc4, probname4, substitutions[3], 1.0, 0, 0);

        String goot5 = "g005|g017";
        String[] gatename5 = {"g005", "g017", "goot5"};
        String[] gate5 = {g005, g017, goot5};
        String indexof5 = "c051c052c053c054c055";//故障树深度优先顺序
        double[] probc5 = {0.09, 0.09, 0.09, 0.09, 0.09};//每个基本事件的原始概率
        String[] probname5 = {"c051", "c052", "c053", "c054", "c055"};//基本事件，请按顺序存放否二分查找返回错误
        String IPCTDD5 = construction("goot5", indexof5, gate5, gatename5);//计算根TDD索引
        probability1(IPCTDD5, probc5, probname5, substitutions[4], 1.0, 0, 0);

        String goot6 = "g008|g011|Uc101|Uc102|Uc103|Uc104|Uc105";                // x1·(x3+x4·x5)+x2·(x4+x3·x5)
        String[] gatename6 = {"g006", "g007", "g008", "g009", "g010", "g011", "goot6"};
        String[] gate6 = {g006, g007, g008, g009, g010, g011, goot6};
        String indexof6 = "c101c102c103c104c105";//故障树深度优先顺序
        String[] probname6 = {"c101", "c102", "c103", "c104", "c105"};//基本事件，请按顺序存放否二分查找返回错误
        String IPCTDD6 = construction("goot6", indexof6, gate6, gatename6);//计算根TDD索引

        double[] failures = new double[3];

<<<<<<< HEAD
        probability4(IPCTDD6, probname6, failures, 1.0, 0, 0, substitutions);
//        double proba6 = probability2(IPCTDD6, substitutions, probname6);//概率（将probc输入完整）
        System.out.println("Ficm近似值=" + (failures[1] + failures[2]));//输出Ficm近似概率
        System.out.println("执行耗时 : " + (System.currentTimeMillis() - a) / 1000f + " 秒 ");//计算执行时间
=======
        double proba6 = probability2(IPCTDD6, substitutions, probname6);//概率（将probc输入完整）
//        System.out.println("Ficm近似值=" + proba6);//输出Ficm近似概率
        System.out.println("执行耗时 : " + (System.nanoTime() - a) / 1000000000f + " 秒 ");//计算执行时间
>>>>>>> a169a11b15efef0809d6342f961334c68044b321
>>>>>>> f3ac6b4c98c211675acad8c5de2503f9a7ee5819
    }

    static void case1() {
        String g001 = "Ic001|Ic002|Ic003";        // a+b+c
        String g002 = "g001&Ic004";               // (a+b+c)·d
        String g003 = "Uc002&Nc001";
        String g004 = "Uc003&Nc001";
//        String g005 = "Uc001|Uc004";

//        String goot = "g002|g003|g004|g005";
        String goot = "g002|g003|g004";

        String[] gatename = {"g001", "g002", "g003", "g004", "goot"};
        String[] gate = {g001, g002, g003, g004, goot};
        String indexof = "c001c002c003c004";//故障树深度优先顺序
        double[] failureProbability = {0.095163, 0.191219, 0.191219, 0.181269};//每个基本事件的原始概率
        double[] coverage = {1.000000, 0.947965, 0.947965, 1.000000};
        String[] event = {"c001", "c002", "c003", "c004"};//基本事件，请按顺序存放否二分查找返回错误
        String IPCTDD = construction("goot", indexof, gate, gatename);//计算根TDD索引
        double proba = probability(IPCTDD, failureProbability, coverage, event);//概率（将probc输入完整）
        System.out.println(proba);//输出Ficm近似概率
    }
}