package com.wzx.algorithm;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

class SolutionTest {

    public static void main(String[] args) {
//        dealSequence("A<B*A<C+D<E*F<G+M<N");
    }

    // A<B*A<C + D<E*F<G + M<N
//    public static void dealSequence(String order) {
//        String[] sequences = order.split("\\+");
//        for (int i = 0; i < sequences.length; i++) {   // 第i个正向, 这里每次循环都表示一种时序关系, 需要和事件进行结合
//            List<StringBuilder> last = new ArrayList<>();
//            for (int j = 0; j < i; j++) {              // 前边的反向, 涉及到与取反变为或, 如果带有*, 取反时需要再次使用SDP
//                List<StringBuilder> temp = new ArrayList<>();
//                if (sequences[j].contains("*")) {      // 如果当前取反项中包含有"*"号，需要额外处理
//                    String[] more = sequences[j].split("\\*");
//
//                    for (int k = 0; k < more.length; k++) {
//                        StringBuilder sb1 = new StringBuilder();
//                        StringBuilder sb2 = new StringBuilder();
//                        for (int l = 0; l < k; l++) {  // 前边不用取反
//                            if (sb1.length() > 0) {
//                                sb1.append("*");
//                            }
//                            sb1.append(more[l]);
//                        }
//                        // 当前的需要取反
//                        String[] events = more[k].split("<");
//                        sb2.append(events[1]);
//                        sb2.append("<");
//                        sb2.append(events[0]);
//                        if (sb1.length() > 0) {
//                            sb1.append("*");
//                        }
//                        sb1.append(sb2);
//                        temp.add(sb1);
//                    }
//                } else {   // 不包含"*", 说明只有单独的一项
//                    StringBuilder sb = new StringBuilder();
//                    String[] split = sequences[j].split("<");
//                    sb.append(split[1]);
//                    sb.append("<");
//                    sb.append(split[0]);
//                    temp.add(sb);
//                }
//
//                if (last.size() == 0) {
//                    last = temp;
//                } else {  // last中的要和temp中的相乘
//                    List<StringBuilder> res = new ArrayList<>();
//                    for (StringBuilder sb1 : last) {
//                        for (StringBuilder sb2 : temp) {
//                            StringBuilder sb = new StringBuilder(sb1).append("*").append(sb2);
//                            res.add(sb);
//                        }
//                    }
//                    last = res;
//                }
//            }
//            if (last.size() > 0) {
//                for (StringBuilder sb : last
//                ) {
//                    sb.append("*");
//                    sb.append(sequences[i]);
//                }
//            } else {
//                last.add(new StringBuilder(sequences[i]));
//            }
//
//            // TODO: 再往后处理last
//            System.out.println(Arrays.toString(last.toArray()));
//        }
//    }
}