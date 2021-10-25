package cn.udesk.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

/**
 * @author zjw
 * @date 2021/10/25 17:41
 */
@Component
public class MessageListener {

    @RabbitListener(queues = {"queue1","queue2","queue3"})
    public void doMessageListen(@Payload String msg){
        System.out.println("msg = " + msg);
    }
}
