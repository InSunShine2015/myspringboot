package com.sun.rabbit;

import com.sun.entity.TblSmsProjectInfo;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class HelloReceive {
    //    @RabbitListener(queues="queue")    //监听器监听指定的Queue
//    public void processC(String str) {
//        System.out.println("Receive:"+str);
//    }
    @RabbitListener(queues="queue")    //监听器监听指定的Queue
    public void processC(TblSmsProjectInfo info) {
        System.out.println("Receive:"+info);
    }

    // Topic模式
    @RabbitListener(queues="topic.message")    //监听器监听指定的Queue
    public void process1(String str) {
        System.out.println("message:"+str);
    }
    @RabbitListener(queues="topic.messages")    //监听器监听指定的Queue
    public void process2(String str) {
        System.out.println("messages:"+str);
    }

    //Fanout模式监听
    @RabbitListener(queues="fanout.A")
    public void processA(String str1) {
        System.out.println("ReceiveA:"+str1);
    }
    @RabbitListener(queues="fanout.B")
    public void processB(String str) {
        System.out.println("ReceiveB:"+str);
    }
    @RabbitListener(queues="fanout.C")
    public void processC(String str) {
        System.out.println("ReceiveC:"+str);
    }
}