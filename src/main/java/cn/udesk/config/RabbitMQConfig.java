package cn.udesk.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zjw
 * @date 2021/10/25 16:57
 */
@Configuration
public class RabbitMQConfig {

    @Bean
    public Queue testDirectQueue() {
        return new Queue("testQueue",true);
    }

    @Bean
    DirectExchange testDirectExchange() {
        return new DirectExchange("testEx",true,false);
    }

    @Bean
    Binding bindingDirect() {
        return BindingBuilder.bind(testDirectQueue()).to(testDirectExchange()).with("testRouter");
    }
}
