package com.wzx.test;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class TestXOR {
    public static void main(String[] args){
        String path = "/a/./b/../../c/";
        System.out.println(simplifyPath(path));
    }

    public static String simplifyPath(String path) {
        String[] dirs = path.split("/");
        Deque<String> deque = new LinkedList<>();

        for (String dir : dirs) {
            if (".".equals(dir) || "".equals(dir)) continue;
            if ("..".equals(dir)) {
                if (!deque.isEmpty()) {
                    deque.pollLast();
                }
            }
            else {
                deque.addLast(dir);
            }
        }
        StringBuilder ret = new StringBuilder();
        ret.append("/");
        while (!deque.isEmpty()) {
            ret.append(deque.pollFirst());
            if (!deque.isEmpty()) {
                ret.append("/");
            }
        }

        return ret.toString();
    }
}
