package com.wzx.test;

import java.util.*;

public class TestXOR {
    public static void main(String[] args){
        String s = "abc#cde##agfe####f#f####gdajk#";
        String[] split = s.split("#+");
        System.out.println(Arrays.toString(split));

    }
}


