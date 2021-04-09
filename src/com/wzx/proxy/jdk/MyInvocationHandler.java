package com.wzx.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 可以代理所有的类?
 */
public class MyInvocationHandler implements InvocationHandler {

    private final Object target;

    public MyInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before method :::" + method.getName());
        Object result = method.invoke(target, args);
        System.out.println("after method :::" + method.getName());
        return result;
    }
}
