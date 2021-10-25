package cn.udesk.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zjw
 * @date 2021/10/25 10:48
 */
@RestController
@RequestMapping("/rabbit")
public class RabbitController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping("/test")
    public void test(){
        rabbitTemplate.convertAndSend("ex","router","0");
        rabbitTemplate.convertAndSend("ex1","bind1","1");
        rabbitTemplate.convertAndSend("ex2","bind2","2");
        rabbitTemplate.convertAndSend("ex3","bind3","3");
        rabbitTemplate.convertAndSend("ex4","bind4","4");
        rabbitTemplate.convertAndSend("ex5","bind5","5");
        rabbitTemplate.convertAndSend("testEx","testRouter","6");
        System.out.println("--------------");
    }

}
