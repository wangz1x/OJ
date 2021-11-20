package com.wzx.access;

public class Huawei_1014 {

    void onMessage(MessageMo messageMo) {
        try {
            Consumer consumer = ConsumerFactory.getBean(messageMo.getMessageType());
            consumer.handle(messageMo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class MessageMo {
    private String messageType;
    public String getMessageType() {
        return messageType;
    }
}

class ConsumerFactory {
    public static Consumer getBean(String type) throws Exception {
        if ("a".equals(type)) {
            return new ConsumerA();
        } else if ("b".equals(type)) {
            return new ConsumerB();
        } else {
            throw new Exception("unknown message type");
        }
    }
}

interface Consumer{
    void handle(MessageMo messageMo);
}

class ConsumerA implements Consumer {
    @Override
    public void handle(MessageMo messageMo) {
        System.out.println("message is type a");
    }
}

class ConsumerB implements Consumer {
    @Override
    public void handle(MessageMo messageMo) {
        System.out.println("message is type b");
    }
}