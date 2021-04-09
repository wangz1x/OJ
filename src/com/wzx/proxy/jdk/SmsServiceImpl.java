package com.wzx.proxy.jdk;

public class SmsServiceImpl implements SmsService {

    @Override
    public String send(String message) {
        System.out.println("send message :::" + message + "::: by SmsServiceImpl object :::" + this.toString() + ":::");
        return message;
    }
}
