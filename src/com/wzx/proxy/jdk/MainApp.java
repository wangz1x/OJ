package com.wzx.proxy.jdk;

public class MainApp {
    public static void main(String[] args) {
        SmsService smsServiceProxy = (SmsService) MyJdkProxy.getProxyObject(new SmsServiceImpl());

        smsServiceProxy.send("java");
    }
}
