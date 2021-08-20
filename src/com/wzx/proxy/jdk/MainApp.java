package com.wzx.proxy.jdk;

public class MainApp {
    public static void main(String[] args) {
        SmsService smsServiceProxy = (SmsService) MyJdkProxy.getProxyObject(new SmsServiceImpl());
//        Object smsServiceProxy = MyJdkProxy.getProxyObject(new SmsServiceImpl());
        System.out.println(smsServiceProxy.send("message"));
    }
}
