package cn.udesk.config;


import lombok.Getter;
import org.springframework.amqp.core.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zjw
 * @date 2021/10/25 13:38
 */
@Getter
public class RabbitRegistry {

    private Map<String, Exchange> exchangeMap = new HashMap<>();

    private Map<String, Queue> queueMap = new HashMap<>();

    private Map<String, Binding> bindingMap = new HashMap<>();


    public void register(String exchangeName, String queueName, String routerKey){
        DirectExchange exchange = new DirectExchange(exchangeName);
        Queue queue = new Queue(queueName);
        register(exchange, queue, routerKey);
    }

    public void register(Exchange exchange,Queue queue, String routerKey){
        String exchangeBeanName = exchange.getName() + "_" + exchange.getType();
        exchangeMap.put(exchangeBeanName,exchange);
        String queueBeanName = queue.getName();
        queueMap.put(queueBeanName, queue);
        Binding binding = BindingBuilder.bind(queue).to(exchange).with(routerKey).noargs();
        String bindingBeanName = exchangeBeanName + "_" + queueBeanName;
        bindingMap.put(bindingBeanName, binding);
    }

}
