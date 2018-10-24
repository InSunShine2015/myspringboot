package com.sun.rabbit;

import com.sun.entity.TblSmsProjectInfo;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class HelloSender {
    @Autowired
    private AmqpTemplate template;

    public void send() {
        //Direct模式
//        template.convertAndSend("queue","hello,rabbit~");  //发送字符串


        TblSmsProjectInfo info = new TblSmsProjectInfo();   //类实现Serializable接口
        info.setValidMinutes(30);
        info.setLimitCount(3);
        info.setStatus(true);
        info.setProjectName("testProject");
        info.setAppId("110");
        info.setCreateTime( new Date());
        info.setUpdateTime( new Date());
        template.convertAndSend("queue",info); //发送序列化类

        //Topic模式
        //方法的第一个参数是交换机名称,第二个参数是发送的key,第三个参数是内容,RabbitMQ将会根据第二个参数去寻找有没有匹配此规则的队列,
        // 如果有,则把消息给它,如果有不止一个,则把消息分发给匹配的队列(每个队列都有消息!),显然在我们的测试中,参数2匹配了两个队列,
        // 因此消息将会被发放到这两个队列中,而监听这两个队列的监听器都将收到消息!
        // 那么如果把参数2改为topic.messages呢?显然只会匹配到一个队列,那么process2方法对应的监听器收到消息!
        template.convertAndSend("exchange","topic.message","hello,rabbit!!!!!!!!!!");

        // Fanout模式
        template.convertAndSend("fanoutExchange","","xixi,hlhdidi");//参数2将忽略

    }
}