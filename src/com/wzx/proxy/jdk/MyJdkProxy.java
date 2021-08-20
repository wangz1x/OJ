package com.wzx.proxy.jdk;

import java.lang.reflect.Proxy;

public class MyJdkProxy {
    public static Object getProxyObject(Object target) {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(),
                new MyInvocationHandler(target));
    }
}
